package Arvores;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class NodoAVL implements Nodo {
    private int dado, altd, alte, ocorrencias; 
    private Nodo dir, esq;

    public NodoAVL(int dado) {
        this.dado = dado;
        dir = esq = null;
        altd = alte = 0;
        ocorrencias = 1; 
    }

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public int getAltd() {
		return altd;
	}

	public void setAltd(int altd) {
		this.altd = altd;
	}

	public int getAlte() {
		return alte;
	}

	public void setAlte(int alte) {
		this.alte = alte;
	}

	public int getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(int ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	public Nodo getDir() {
		return dir;
	}

	public void setDir(Nodo dir) {
		this.dir = dir;
	}

	public Nodo getEsq() {
		return esq;
	}

	public void setEsq(Nodo esq) {
		this.esq = esq;
	}
    
	@Override
	public void addNodo(Nodo nodo) {
	   if (nodo == null) {
	       throw new IllegalArgumentException("Nodo não pode ser nulo");
	   }

	   // Se a árvore está vazia, o novo nó se torna a raiz
	   if (this.getDado() == 0) {
	       this.setDado(nodo.getDado());
	       this.setOcorrencias(((NodoAVL) nodo).getOcorrencias());
	       this.setAltd(((NodoAVL) nodo).getAltd());
	       this.setAlte(((NodoAVL) nodo).getAlte());
	   } else {
	       // Se a árvore não está vazia, adicione o novo nó de acordo com as regras da árvore AVL
	       if (nodo.getDado() < this.getDado()) {
	           if (this.getEsq() == null) {
	               this.setEsq(nodo);
	           } else {
	               this.getEsq().addNodo(nodo);
	           }
	       } else if (nodo.getDado() > this.getDado()) {
	           if (this.getDir() == null) {
	               this.setDir(nodo);
	           } else {
	               this.getDir().addNodo(nodo);
	           }
	       } else {
	           this.setOcorrencias(this.getOcorrencias() + ((NodoAVL) nodo).getOcorrencias());
	       }

	       // Atualize a altura do nó
	       this.setAltd(1 + Math.max(getAltd(this.getEsq()), getAltd(this.getDir())));
	       this.setAlte(1 + Math.max(getAlte(this.getEsq()), getAlte(this.getDir())));

	       // Balanceie a árvore se ela estiver desequilibrada
	       NodoAVL raiz = (NodoAVL) balancear(this);
	       this.setDado(raiz.getDado());
	       this.setOcorrencias(raiz.getOcorrencias());
	       this.setAltd(raiz.getAltd());
	       this.setAlte(raiz.getAlte());
	       this.setEsq(raiz.getEsq());
	       this.setDir(raiz.getDir());
	   }
	}

	private int getAltd(Nodo n) {
	   if (n == null) {
	       return 0;
	   }
	   return ((NodoAVL) n).getAltd();
	}

	private int getAlte(Nodo n) {
	   if (n == null) {
	       return 0;
	   }
	   return ((NodoAVL) n).getAlte();
	}

	private Nodo balancear(Nodo n) {
	   if (getAltd(n.getEsq()) - getAlte(n.getDir()) > 1) {
	       if (getAltd(n.getEsq().getEsq()) >= getAltd(n.getEsq().getDir())) {
	           n = rotacaoDireita(n);
	       } else {
	           n.setEsq(rotacaoEsquerda(n.getEsq()));
	           n = rotacaoDireita(n);
	       }
	   } else if (getAlte(n.getDir()) - getAltd(n.getEsq()) > 1) {
	       if (getAlte(n.getDir().getDir()) >= getAlte(n.getDir().getEsq())) {
	           n = rotacaoEsquerda(n);
	       } else {
	           n.setDir(rotacaoDireita(n.getDir()));
	           n = rotacaoEsquerda(n);
	       }
	   }
	   ((NodoAVL) n).setAltd(1 + Math.max(getAltd(n.getEsq()), getAltd(n.getDir())));
	   ((NodoAVL) n).setAlte(1 + Math.max(getAlte(n.getEsq()), getAlte(n.getDir())));
	   return n;
	}

	private Nodo rotacaoDireita(Nodo n) {
	   Nodo aux = n.getEsq();
	   n.setEsq(aux.getDir());
	   aux.setDir(n);
	   ((NodoAVL) n).setAltd(1 + Math.max(getAltd(n.getEsq()), getAltd(n.getDir())));
	   ((NodoAVL) aux).setAltd(1 + Math.max(getAltd(aux.getEsq()), getAltd(aux.getDir())));
	   return aux;
	}

	private Nodo rotacaoEsquerda(Nodo n) {
	   Nodo aux = n.getDir();
	   n.setDir(aux.getEsq());
	   aux.setEsq(n);
	   ((NodoAVL) n).setAlte(1 + Math.max(getAlte(n.getEsq()), getAlte(n.getDir())));
	   ((NodoAVL) aux).setAlte(1 + Math.max(getAlte(aux.getEsq()), getAlte(aux.getDir())));
	   return aux;
	}

	@Override
	public void removeNodo(Nodo nodo) {
	   if (nodo == null) {
	       throw new IllegalArgumentException("Nodo não pode ser nulo");
	   }

	   // Encontre o nó que você deseja remover
	   NodoAVL nodeToRemove = findNode(nodo.getDado());
	   if (nodeToRemove == null) {
	       return; // Nó não encontrado
	   }

	   // Nó com um ou nenhum filho
	   if (nodeToRemove.getEsq() == null || nodeToRemove.getDir() == null) {
	       Nodo childNode = nodeToRemove.getEsq() != null ? nodeToRemove.getEsq() : nodeToRemove.getDir();
	       if (childNode != null) {
	           ((NodoAVL) childNode).setAltd(nodeToRemove.getAltd());
	           ((NodoAVL) childNode).setAlte(nodeToRemove.getAlte());
	       }
	       replaceNode(nodeToRemove, (NodoAVL) childNode);
	   }
	   // Nó com dois filhos
	   else {
	       NodoAVL successor = findSuccessor(nodeToRemove);
	       nodeToRemove.setDado(successor.getDado());
	       nodeToRemove.setOcorrencias(successor.getOcorrencias());
	       nodeToRemove.setAltd(successor.getAltd());
	       nodeToRemove.setAlte(successor.getAlte());
	       removeNodo(successor);
	   }

	   // Balanceie a árvore se ela estiver desequilibrada
	   NodoAVL raiz = (NodoAVL) balancear(this);
	   this.setDado(raiz.getDado());
	   this.setOcorrencias(raiz.getOcorrencias());
	   this.setAltd(raiz.getAltd());
	   this.setAlte(raiz.getAlte());
	   this.setEsq(raiz.getEsq());
	   this.setDir(raiz.getDir());
	}

	private NodoAVL findNode(int dado) {
	   if (dado == this.getDado()) {
	       return this;
	   } else if (dado < this.getDado() && this.getEsq() != null) {
	       return ((NodoAVL) this.getEsq()).findNode(dado);
	   } else if (dado > this.getDado() && this.getDir() != null) {
	       return ((NodoAVL) this.getDir()).findNode(dado);
	   }
	   return null; // Nó não encontrado
	}

	private NodoAVL findSuccessor(NodoAVL node) {
	   NodoAVL successor = null;
	   if (node.getDir() != null) {
	       successor = ((NodoAVL) node.getDir()).findMinNode();
	   } else {
	       NodoAVL ancestor = this;
	       while (ancestor != node) {
	           if (node.getDado() < ancestor.getDado()) {
	               successor = ancestor;
	               ancestor = (NodoAVL) ancestor.getEsq();
	           } else {
	               ancestor = (NodoAVL) ancestor.getDir();
	           }
	       }
	   }
	   return successor;
	}

	private NodoAVL findMinNode() {
	   NodoAVL current = this;
	   while (current.getEsq() != null) {
	       current = (NodoAVL) current.getEsq();
	   }
	   return current;
	}

	private void replaceNode(NodoAVL node, NodoAVL newNode) {
		  if (node.getEsq() != null) {
		      node.getEsq().setDir(newNode);
		  }
		  if (node.getDir() != null) {
		      node.getDir().setEsq(newNode);
		  }
		  if (node == this) {
		      this.setDado(newNode.getDado());
		      this.setOcorrencias(newNode.getOcorrencias());
		      this.setAltd(newNode.getAltd());
		      this.setAlte(newNode.getAlte());
		      this.setEsq(newNode.getEsq());
		      this.setDir(newNode.getDir());
		  } else if (node == node.getEsq()) {
		      node.getEsq().setDado(newNode.getDado());
		      ((NodoAVL) node.getEsq()).setOcorrencias(newNode.getOcorrencias());
		      ((NodoAVL) node.getEsq()).setAltd(newNode.getAltd());
		      ((NodoAVL) node.getEsq()).setAlte(newNode.getAlte());
		      node.getEsq().setEsq(newNode.getEsq());
		      node.getEsq().setDir(newNode.getDir());
		  } else {
		      node.getDir().setDado(newNode.getDado());
		      ((NodoAVL) node.getDir()).setOcorrencias(newNode.getOcorrencias());
		      ((NodoAVL) node.getDir()).setAltd(newNode.getAltd());
		      ((NodoAVL) node.getDir()).setAlte(newNode.getAlte());
		      node.getDir().setEsq(newNode.getEsq());
		      node.getDir().setDir(newNode.getDir());
		  }
		}

	@Override
	public Nodo getNodo(int index) {
	   if (index < 0) {
	       throw new IllegalArgumentException("Índice não pode ser negativo");
	   }

	   int count = 0;
	   Queue<NodoAVL> queue = new LinkedList<>();
	   queue.add(this);

	   while (!queue.isEmpty()) {
	       NodoAVL node = queue.poll();
	       count++;

	       if (count == index) {
	           return node;
	       }

	       if (node.getEsq() != null) {
	           queue.add((NodoAVL) node.getEsq());
	       }
	       if (node.getDir() != null) {
	           queue.add((NodoAVL) node.getDir());
	       }
	   }

	   throw new NoSuchElementException("Índice fora do intervalo");
	}
    
}

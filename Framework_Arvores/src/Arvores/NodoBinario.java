package Arvores;

public class NodoBinario implements Nodo {
	
    private int dado;
    private Nodo dir, esq;
    private static Nodo raiz; 
    

    
    public NodoBinario(int dado) {
        this.dado = dado;
        dir = esq = null;
    }

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
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

	 public void addNodo(Nodo nodo) {
	      if (nodo == null) {
	          throw new IllegalArgumentException("Nodo não pode ser nulo");
	      }
	      // Se o nó a ser adicionado é menor que o nó atual, ele deve ser adicionado à subárvore esquerda
	      if (nodo.getDado() < this.dado) {
	          if (this.esq == null) {
	              this.esq = nodo;
	          } else {
	              ((NodoBinario) this.esq).addNodo(nodo);
	          }
	      } 
	      // Se o nó a ser adicionado é maior que o nó atual, ele deve ser adicionado à subárvore direita
	      else if (nodo.getDado() > this.dado) {
	          if (this.dir == null) {
	              this.dir = nodo;
	          } else {
	              ((NodoBinario) this.dir).addNodo(nodo);
	          }
	      } 
	      // Se o nó a ser adicionado é igual ao nó atual, você pode optar por ignorar a adição ou lançar uma exceção
	      else {
	          throw new IllegalArgumentException("Nodo com valor duplicado não é permitido");
	      }
	  }
	 
	 
	 public void removeNodo(Nodo nodo) {
	      if (nodo == null) {
	          throw new IllegalArgumentException("Nodo não pode ser nulo");
	      }

	      // Se o nó a ser removido é o nó atual
	      if (this == nodo) {
	          // Caso 1: O nó é uma folha
	          if (this.dir == null && this.esq == null) {
	              // Se o nó é a raiz da árvore, então você pode simplesmente definir a raiz para null
	              if (this == raiz) {
	                 raiz = null;
	              } else {
	                 // Se o nó não é a raiz, então você precisa encontrar o pai do nó e ajustar os ponteiros
	                 // Isso é mais complexo e depende de como sua árvore é implementada
	              }
	          } 
	          // Caso 2: O nó tem um filho
	          else if (this.dir == null) {
	              this.dado = this.esq.getDado();
	              this.dir = this.esq.getDir();
	              this.esq = this.esq.getEsq();
	          } else if (this.esq == null) {
	              this.dado = this.dir.getDado();
	              this.esq = this.dir.getEsq();
	              this.dir = this.dir.getDir();
	          } 
	          // Caso 3: O nó tem dois filhos
	          else {
	              Nodo minNode = findMin(this.dir);
	              this.dado = minNode.getDado();
	              ((NodoBinario) this.dir).removeNodo(minNode);
	          }
	      } 
	      // Se o nó a ser removido é filho do nó atual
	      else {
	          if (this.dir != null && this.dir == nodo) {
	              this.dir = nodo.getDir();
	          } else if (this.esq != null && this.esq == nodo) {
	              this.esq = nodo.getEsq();
	          } else {
	              if (this.dir != null) {
	                ((NodoBinario) this.dir).removeNodo(nodo);
	              }
	              if (this.esq != null) {
	                ((NodoBinario) this.esq).removeNodo(nodo);
	              }
	          }
	      }
	  }


	   private Nodo findMin(Nodo node) {
	       while (node.getEsq() != null) {
	           node = node.getEsq();
	       }
	       return node;
	   }
	

		   public Nodo getNodo(int index) {
		       if (index < 0) {
		           throw new IllegalArgumentException("Index não pode ser negativo");
		       }

		       // Inicializa o índice atual e o nó encontrado
		       int currentIndex = 0;
		       Nodo foundNode = null;

		       // Inicia a busca na raiz da árvore
		       foundNode = getNodo(this, index, currentIndex);

		       if (foundNode == null) {
		           throw new IllegalArgumentException("Nodo não encontrado");
		       }

		       return foundNode;
		   }

		   private Nodo getNodo(Nodo node, int index, int currentIndex) {
		       if (node == null) {
		           return null;
		       }

		       // Visita a subárvore esquerda
		       Nodo foundNode = getNodo(node.getEsq(), index, currentIndex);

		       if (foundNode != null) {
		           return foundNode;
		       }

		       // Verifica se o índice atual é igual ao índice desejado
		       if (currentIndex == index) {
		           return node;
		       }

		       // Visita a subárvore direita
		       currentIndex++;
		       return getNodo(node.getDir(), index, currentIndex);
		   }

	
}

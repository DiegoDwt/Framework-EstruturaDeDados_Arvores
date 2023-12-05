package Arvores;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe para representar um nó composto em uma árvore.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
public class NodoCompositeImpl implements NodoComposite {
	
	  private List<Nodo> childNodes = new ArrayList<>();
	  private int dado;
	  private Nodo dir;
	  private Nodo esq;

	  /**
	  * Retorna o dado armazenado no nó.
	  *
	  * @return o dado armazenado no nó
	  */
	  @Override
	  public int getDado() {
	      return this.dado;
	  }

	  /**
	   * Define o dado armazenado no nó.
	   *
	   * @param dado o novo dado a ser armazenado no nó
	   */
	  @Override
	  public void setDado(int dado) {
	      this.dado = dado;
	  }

	  /**
	   * Retorna o nó filho à direita do nó atual.
	   *
	   * @return o nó filho à direita do nó atual
	   */
	  @Override
	  public Nodo getDir() {
	      return this.dir;
	  }

	  /**
	   * Define o nó filho à direita do nó atual.
	   *
	   * @param dir o novo nó filho à direita
	   */
	  @Override
	  public void setDir(Nodo dir) {
	      this.dir = dir;
	  }

	  /**
	   * Retorna o nó filho à esquerda do nó atual.
	   *
	   * @return o nó filho à esquerda do nó atual
	   */
	  @Override
	  public Nodo getEsq() {
	      return this.esq;
	  }

	  /**
	   * Define o nó filho à esquerda do nó atual.
	   *
	   * @param esq o novo nó filho à esquerda
	   */
	  @Override
	  public void setEsq(Nodo esq) {
	      this.esq = esq;
	  }

	  /**
	   * Adiciona um novo nó à lista de nós filhos.
	   *
	   * @param nodo o novo nó a ser adicionado
	   */
	  @Override
	  public void addNodo(Nodo nodo) {
	      this.childNodes.add(nodo);
	  }

	  /**
	   * Remove um nó da lista de nós filhos.
	   *
	   * @param nodo o nó a ser removido
	   */
	  @Override
	  public void removeNodo(Nodo nodo) {
	      this.childNodes.remove(nodo);
	  }

	  /**
	   * Retorna o nó no índice especificado na lista de nós filhos.
	   *
	   * @param index o índice do nó a ser retornado
	   * @return o nó no índice especificado
	   */
	  @Override
	  public Nodo getNodo(int index) {
	      if(index < 0 || index >= this.childNodes.size()) {
	          throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.childNodes.size());
	      }
	      return this.childNodes.get(index);
	  }
	  
	  /**
	   * Retorna o número total de nós na árvore.
	   *
	   * @return o número total de nós na árvore
	   */
	  public int getCount() {
		  int count = 1; // conta o nó atual
		  if (this.getEsq() != null) {
		      count += ((NodoCompositeImpl) this.getEsq()).getCount();
		  }
		  if (this.getDir() != null) {
		      count += ((NodoCompositeImpl) this.getDir()).getCount();
		  }
		  return count;
		}
	  
	  /**
	   * Retorna a lista de nós filhos do nó atual.
	   *
	   * @return a lista de nós filhos do nó atual
	   */
	  public List<Nodo> getChildNodes() {
		   return this.childNodes;
		}


}

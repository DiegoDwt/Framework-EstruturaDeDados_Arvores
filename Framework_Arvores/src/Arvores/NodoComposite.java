package Arvores;

/**
 * Interface para representar um nó composto em uma árvore.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
public interface NodoComposite extends Nodo {
	
	 /**
	  * Adiciona um novo nó à lista de nós filhos.
	  *
	  * @param nodo o novo nó a ser adicionado
	  */
    void addNodo(Nodo nodo);
    
    /**
     * Remove um nó da lista de nós filhos.
     *
     * @param nodo o nó a ser removido
     */
    void removeNodo(Nodo nodo);
    
    /**
     * Retorna o nó no índice especificado na lista de nós filhos.
     *
     * @param index o índice do nó a ser retornado
     * @return o nó no índice especificado
     */
    Nodo getNodo(int index);
    
    
}
package Arvores;

/**
 * Interface para representar um nó genérico em uma árvore.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
public interface Nodo {
	
	 /**
	   * Retorna o dado armazenado no nó.
	   *
	   * @return o dado armazenado no nó
	   */
    int getDado();
    
    /**
     * Define o dado armazenado no nó.
     *
     * @param dado o novo dado a ser armazenado no nó
     */
    void setDado(int dado);
    
    /**
     * Retorna o nó filho à direita do nó atual.
     *
     * @return o nó filho à direita do nó atual
     */
    Nodo getDir();
    
    /**
     * Define o nó filho à direita do nó atual.
     *
     * @param dir o novo nó filho à direita
     */
    void setDir(Nodo dir);
    
    /**
     * Retorna o nó filho à esquerda do nó atual.
     *
     * @return o nó filho à esquerda do nó atual
     */
    Nodo getEsq();
    
    /**
     * Define o nó filho à esquerda do nó atual.
     *
     * @param esq o novo nó filho à esquerda
     */
    void setEsq(Nodo esq);
    
    /**
     * Adiciona um novo nó à árvore.
     *
     * @param nodo o novo nó a ser adicionado
     */
	void addNodo(Nodo nodo);
	
	/**
	   * Remove um nó da árvore.
	   *
	   * @param nodo o nó a ser removido
	   */
	void removeNodo(Nodo nodo);
	
	/**
	   * Retorna o nó no índice especificado na árvore.
	   *
	   * @param index o índice do nó a ser retornado
	   * @return o nó no índice especificado
	   */
	Nodo getNodo(int index);
}

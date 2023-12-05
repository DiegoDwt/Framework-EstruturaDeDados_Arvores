package Arvores;

/**
 * Interface para representar uma árvore genérica.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
public interface Arvore {
	  /**
	    * Insere um novo nó na árvore com a chave fornecida.
	    *
	    * @param chave a chave do novo nó
	    */
    void inserir(int chave);
    
    /**
    * Busca um nó na árvore com a chave fornecida.
    *
    * @param chave a chave do nó a ser buscado
    * @return true se a chave for encontrada, false caso contrário
    */
    boolean buscar(int chave);
}

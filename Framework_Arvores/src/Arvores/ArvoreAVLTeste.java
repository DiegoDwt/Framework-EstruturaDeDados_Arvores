package Arvores;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a classe ArvoreAVL.
 *
 * @author DIego Dal Witt
 * @version 1.0
 */
class ArvoreAVLTeste {

	  /**
	    * Testa a inserção de um nó na árvore AVL.
	    */
	    @Test
	    public void testInserir() {
	        Arvore arvore = new ArvoreAVL();
	        arvore.inserir(5);
	       
	    }

	    /**
	     * Testa a busca de um nó na árvore AVL.
	     */
	    @Test
	    public void testBuscar() {
	        Arvore arvore = new ArvoreAVL();
	        arvore.inserir(5);
	        assertTrue(arvore.buscar(5));
	        assertFalse(arvore.buscar(6));
	    }

	   
}

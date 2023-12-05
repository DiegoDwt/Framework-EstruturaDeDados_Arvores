package Arvores;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a classe ArvoreBinaria.
 *
 * @author DIego Dal Witt
 * @version 1.0
 */
class ArvoreBinariaTeste {
 
	    /**
	    * Testa a inserção de um nó na árvore binária.
	    */
	    @Test
	    public void testInserir() {
	        Arvore arvore = new ArvoreBinaria();
	        arvore.inserir(5);
	        // Aqui você pode adicionar asserções para verificar o estado da árvore após a inserção
	    }

	    /**
	     * Testa a busca de um nó na árvore binária.
	     */
	    @Test
	    public void testBuscar() {
	        Arvore arvore = new ArvoreBinaria();
	        arvore.inserir(5);
	        assertTrue(arvore.buscar(5));
	        assertFalse(arvore.buscar(6));
	    }
	

}

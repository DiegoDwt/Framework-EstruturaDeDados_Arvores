package Arvores;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a classe NodoBinario.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
class NodoBinarioTeste {
	
	 /**
	    * Testa a obtenção e definição do dado de um nó binário.
	    */
	    @Test
	    public void testGetSetDado() {
	        Nodo nodo = new NodoBinario(5);
	        assertEquals(5, nodo.getDado());
	        nodo.setDado(6);
	        assertEquals(6, nodo.getDado());
	    }

	    /**
	     * Testa a obtenção e definição dos nós à direita e à esquerda de um nó binário.
	     */
	    @Test
	    public void testGetSetDirEsq() {
	        Nodo nodo = new NodoBinario(5);
	        Nodo nodoDir = new NodoBinario(6);
	        Nodo nodoEsq = new NodoBinario(4);
	        nodo.setDir(nodoDir);
	        nodo.setEsq(nodoEsq);
	        assertEquals(nodoDir, nodo.getDir());
	        assertEquals(nodoEsq, nodo.getEsq());
	    }

	    /**
	     * Testa a adição de um nó à árvore binária.
	     */
	    @Test
	    public void testAddNodo() {
	        Nodo nodo = new NodoBinario(5);
	        Nodo nodoAdicionado = new NodoBinario(6);
	        nodo.addNodo(nodoAdicionado);
	        assertEquals(nodoAdicionado, nodo.getDir());
	    }

	    /**
	     * Testa a remoção de um nó à árvore binária.
	     */
	    @Test
	    public void testRemoveNodo() {
	        Nodo nodo = new NodoBinario(5);
	        Nodo nodoAdicionado = new NodoBinario(6);
	        nodo.addNodo(nodoAdicionado);
	        nodo.removeNodo(nodoAdicionado);
	        assertNull(nodo.getDir());
	    }

	    /**
	     * Testa a obtenção de um nó à árvore binária.
	     */
	    @Test
	    public void testGetNodo() {
	       Nodo nodo = new NodoBinario(5);
	       Nodo nodoAdicionado = new NodoBinario(6);
	       nodo.addNodo(nodoAdicionado);
	       assertEquals(nodoAdicionado, nodo.getNodo(0));
	    }


}

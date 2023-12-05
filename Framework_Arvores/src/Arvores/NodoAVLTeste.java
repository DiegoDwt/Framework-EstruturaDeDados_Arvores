package Arvores;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Classe de teste para a classe NodoAVL.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
class NodoAVLTeste {

	    /**
	    * Testa a obtenção e definição do dado de um nó AVL.
	    */
	    @Test
	    public void testGetSetDado() {
	        Nodo nodo = new NodoAVL(5);
	        assertEquals(5, nodo.getDado());
	        nodo.setDado(6);
	        assertEquals(6, nodo.getDado());
	    }

	    /**
	     * Testa a obtenção e definição dos nós à direita e à esquerda de um nó AVL.
	     */
	    @Test
	    public void testGetSetDirEsq() {
	        Nodo nodo = new NodoAVL(5);
	        Nodo nodoDir = new NodoAVL(6);
	        Nodo nodoEsq = new NodoAVL(4);
	        nodo.setDir(nodoDir);
	        nodo.setEsq(nodoEsq);
	        assertEquals(nodoDir, nodo.getDir());
	        assertEquals(nodoEsq, nodo.getEsq());
	    }

	    /**
	     * Testa a adição de um nó à árvore AVL.
	     */
	    @Test
	    public void testAddNodo() {
	        Nodo nodo = new NodoAVL(5);
	        Nodo nodoAdicionado = new NodoAVL(6);
	        nodo.addNodo(nodoAdicionado);
	        assertEquals(nodoAdicionado, nodo.getDir());
	    }

	    /**
	     * Testa a remoção de um nó da árvore AVL.
	     */
	    @Test
	    public void testRemoveNodo() {
	       NodoAVL tree = new NodoAVL(10);
	       Nodo nodo = new NodoAVL(20);
	       assertThrows(IllegalArgumentException.class, () -> {
	           tree.removeNodo(nodo);
	       });
	    }

	    /**
	     * Testa a obtenção de um nó na árvore AVL pelo índice.
	     */
	    @Test
	    public void testGetNodo() {
	        Nodo nodo = new NodoAVL(5);
	        Nodo nodoAdicionado = new NodoAVL(6);
	        nodo.addNodo(nodoAdicionado);
	        assertEquals(nodoAdicionado, nodo.getNodo(2));
	    }
	

}

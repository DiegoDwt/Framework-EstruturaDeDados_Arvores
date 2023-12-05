package Arvores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para a classe NodoCompositeImpl.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
public class NodoCompositeImplTeste {
	
  private NodoCompositeImpl nodoComposite;
  private Nodo nodo1;
  private Nodo nodo2;

  /**
   * Configuração antes de cada teste.
   */
  @BeforeEach
  public void setUp() {
      nodoComposite = new NodoCompositeImpl();
      nodo1 = new NodoCompositeImpl();
      nodo2 = new NodoCompositeImpl();
  }

  /**
   * Testa a adição de um nó à lista de nós filhos do nó composto.
   */
  @Test
  public void testAddNodo() {
      nodoComposite.addNodo(nodo1);
      assertEquals(1, nodoComposite.getChildNodes().size());
      nodoComposite.addNodo(nodo2);
      assertEquals(2, nodoComposite.getChildNodes().size());
  }

  /**
  * Testa a remoção de um nó da lista de nós filhos do nó composto.
  */
  @Test
  public void testRemoveNodo() {
      nodoComposite.addNodo(nodo1);
      nodoComposite.addNodo(nodo2);
      nodoComposite.removeNodo(nodo1);
      assertEquals(1, nodoComposite.getChildNodes().size());
      nodoComposite.removeNodo(nodo2);
      assertEquals(0, nodoComposite.getChildNodes().size());
  }

  /**
  * Testa a obtenção de um nó na lista de nós filhos do nó composto pelo índice.
  */
  @Test
  public void testGetNodo() {
      nodoComposite.addNodo(nodo1);
      nodoComposite.addNodo(nodo2);
      assertEquals(nodo1, nodoComposite.getNodo(0));
      assertEquals(nodo2, nodoComposite.getNodo(1));
  }

  /**
   * Testa a obtenção de um nó na lista de nós filhos do nó composto pelo índice com um índice inválido.
   */
  @Test
  public void testGetNodoWithInvalidIndex() {
      nodoComposite.addNodo(nodo1);
      assertThrows(IndexOutOfBoundsException.class, () -> nodoComposite.getNodo(1));
  }
}

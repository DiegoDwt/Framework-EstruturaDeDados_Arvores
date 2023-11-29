package Arvores;

import java.util.ArrayList;
import java.util.List;

public class NodoCompositeImpl implements NodoComposite {
	
	  private List<Nodo> childNodes = new ArrayList<>();
	  private int dado;
	  private Nodo dir;
	  private Nodo esq;

	  @Override
	  public int getDado() {
	      return this.dado;
	  }

	  @Override
	  public void setDado(int dado) {
	      this.dado = dado;
	  }

	  @Override
	  public Nodo getDir() {
	      return this.dir;
	  }

	  @Override
	  public void setDir(Nodo dir) {
	      this.dir = dir;
	  }

	  @Override
	  public Nodo getEsq() {
	      return this.esq;
	  }

	  @Override
	  public void setEsq(Nodo esq) {
	      this.esq = esq;
	  }

	  @Override
	  public void addNodo(Nodo nodo) {
	      this.childNodes.add(nodo);
	  }

	  @Override
	  public void removeNodo(Nodo nodo) {
	      this.childNodes.remove(nodo);
	  }

	  @Override
	  public Nodo getNodo(int index) {
	      if(index < 0 || index >= this.childNodes.size()) {
	          throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.childNodes.size());
	      }
	      return this.childNodes.get(index);
	  }
}

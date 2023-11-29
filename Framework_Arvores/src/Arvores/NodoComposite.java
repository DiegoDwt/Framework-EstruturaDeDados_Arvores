package Arvores;

public interface NodoComposite extends Nodo {
    void addNodo(Nodo nodo);
    void removeNodo(Nodo nodo);
    Nodo getNodo(int index);
    
    
}
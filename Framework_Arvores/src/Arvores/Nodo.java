package Arvores;

public interface Nodo {
    int getDado();
    void setDado(int dado);
    Nodo getDir();
    void setDir(Nodo dir);
    Nodo getEsq();
    void setEsq(Nodo esq);
	void addNodo(Nodo nodo);
	void removeNodo(Nodo nodo);
	Nodo getNodo(int index);
}

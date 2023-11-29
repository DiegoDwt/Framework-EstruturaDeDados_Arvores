package Arvores;

public class Main {
	
	   public static void main(String[] args) {
		   
	       // Testando ArvoreAVL
	       ArvoreAVL arvoreAVL = new ArvoreAVL();
	       arvoreAVL.inserir(10);
	       arvoreAVL.inserir(20);
	       arvoreAVL.inserir(30);
	       System.out.println(arvoreAVL.buscar(20)); // Deve imprimir true
	       System.out.println(arvoreAVL.buscar(50)); // Deve imprimir false

	       // Testando ArvoreBinaria
	       ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
	       arvoreBinaria.inserir(10);
	       arvoreBinaria.inserir(20);
	       arvoreBinaria.inserir(30);
	       System.out.println(arvoreBinaria.buscar(20)); // Deve imprimir true
	       System.out.println(arvoreBinaria.buscar(50)); // Deve imprimir false

	       // Testando NodoCompositeImpl
	       NodoCompositeImpl nodoComposite = new NodoCompositeImpl();
	       NodoAVL nodo1 = new NodoAVL(10);
	       NodoAVL nodo2 = new NodoAVL(20);
	       NodoAVL nodo3 = new NodoAVL(30);
	       nodoComposite.addNodo(nodo1);
	       nodoComposite.addNodo(nodo2);
	       nodoComposite.addNodo(nodo3);
	       System.out.println(nodoComposite.getNodo(0).getDado()); // Deve imprimir 10
	       nodoComposite.removeNodo(nodo1);
	       System.out.println(nodoComposite.getNodo(0).getDado()); // Deve imprimir 20
	       
	       NodoCompositeImpl nodoComposite2 = new NodoCompositeImpl();
	       NodoBinario nodo4 = new NodoBinario(40);
	       NodoBinario nodo5 = new NodoBinario(50);
	       NodoBinario nodo6 = new NodoBinario(60);
	       nodoComposite2.addNodo(nodo4);
	       nodoComposite2.addNodo(nodo5);
	       nodoComposite2.addNodo(nodo6);
	       System.out.println(nodoComposite2.getNodo(0).getDado()); // Deve imprimir 40
	       nodoComposite2.removeNodo(nodo4);
	       System.out.println(nodoComposite2.getNodo(0).getDado()); // Deve imprimir 50
	       
	     
	   }
	}

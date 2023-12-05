package Arvores;

public class Main {

	    public static void main(String[] args) {
	        ArvoreAVL arvoreAVL = new ArvoreAVL();
	        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

	        // Inserindo mais nós na árvore AVL
	        arvoreAVL.inserir(60);
	        arvoreAVL.inserir(70);
	        arvoreAVL.inserir(80);
	        arvoreAVL.inserir(90);
	        arvoreAVL.inserir(100);
	        arvoreAVL.inserir(110);

	        // Inserindo mais nós na árvore binária
	        arvoreBinaria.inserir(60);
	        arvoreBinaria.inserir(70);
	        arvoreBinaria.inserir(80);
	        arvoreBinaria.inserir(90);
	        arvoreBinaria.inserir(100);
	        arvoreBinaria.inserir(110);

	        // Buscando um nó na árvore AVL
	        boolean existe = arvoreAVL.buscar(70);
	        System.out.println(existe ? "Nó encontrado na árvore AVL" : "Nó não encontrado na árvore AVL");
	      
	        
	        boolean existe2 = arvoreAVL.buscar(80);
	        System.out.println(existe2 ? "Nó encontrado na árvore AVL" : "Nó não encontrado na árvore AVL");
	        
	        // Buscando um nó na árvore binária
	        existe = arvoreBinaria.buscar(90);
	        System.out.println(existe ? "Nó encontrado na árvore binária" : "Nó não encontrado na árvore binária");

	        
	        existe2 = arvoreBinaria.buscar(100);
	        System.out.println(existe2 ? "Nó encontrado na árvore binária" : "Nó não encontrado na árvore binária");
	        
	        // Testando NodoCompositeImpl
		       NodoCompositeImpl nodoComposite = new NodoCompositeImpl();
		       NodoAVL nodo1 = new NodoAVL(10);
		       NodoAVL nodo2 = new NodoAVL(20);
		       NodoAVL nodo3 = new NodoAVL(30);
		      
		       // Adiciona Nodo
		       nodoComposite.addNodo(nodo1);
		       nodoComposite.addNodo(nodo2);
		       nodoComposite.addNodo(nodo3);
		       System.out.println(nodoComposite.getNodo(0).getDado()); // Deve imprimir 10
		       // Remove Nodo
		       nodoComposite.removeNodo(nodo1);
		       System.out.println(nodoComposite.getNodo(0).getDado()); // Deve imprimir 20
		       
		       NodoCompositeImpl nodoComposite2 = new NodoCompositeImpl();
		       NodoBinario nodo4 = new NodoBinario(40);
		       NodoBinario nodo5 = new NodoBinario(50);
		       NodoBinario nodo6 = new NodoBinario(60);
		       // Adiciona Nodo
		       nodoComposite2.addNodo(nodo4);
		       nodoComposite2.addNodo(nodo5);
		       nodoComposite2.addNodo(nodo6);
		       System.out.println(nodoComposite2.getNodo(0).getDado()); // Deve imprimir 40
		       // Remove Nodo
		       nodoComposite2.removeNodo(nodo4);
		       System.out.println(nodoComposite2.getNodo(0).getDado()); // Deve imprimir 50
		       
	      
	   
	    }
	


}

package Arvores;

/**
 * Classe para representar uma árvore binária.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
public class ArvoreBinaria implements Arvore {
    private Nodo raiz;

    /**
     * Construtor para criar uma nova árvore binária.
     */
    public ArvoreBinaria() {
        raiz = null;
    }

    /**
     * Insere um novo nó na árvore binária com a chave fornecida.
     *
     * @param chave a chave do novo nó
     */
    @Override
    public void inserir(int chave) {
        raiz = inserirRecursivo(raiz, chave);
    }

    private Nodo inserirRecursivo(Nodo atual, int chave) {
        if (atual == null) {
            return new NodoBinario(chave);
        }

        if (chave < atual.getDado()) {
            atual.setEsq(inserirRecursivo(atual.getEsq(), chave));
        } else if (chave > atual.getDado()) {
            atual.setDir(inserirRecursivo(atual.getDir(), chave));
        }

        return atual;
    }

    /**
     * Busca um nó na árvore binária com a chave fornecida.
     *
     * @param chave a chave do nó a ser buscado
     * @return true se a chave for encontrada, false caso contrário
     */
    @Override
    public boolean buscar(int chave) {
        return buscarRecursivo(raiz, chave);
    }

    private boolean buscarRecursivo(Nodo atual, int chave) {
        if (atual == null) {
            return false;
        }

        if (chave == atual.getDado()) {
            return true;
        }

        return chave < atual.getDado() 
            ? buscarRecursivo(atual.getEsq(), chave)
            : buscarRecursivo(atual.getDir(), chave);
    }
}

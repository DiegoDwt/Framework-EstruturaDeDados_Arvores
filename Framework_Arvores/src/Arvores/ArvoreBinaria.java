package Arvores;

public class ArvoreBinaria implements Arvore {
    private Nodo raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

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

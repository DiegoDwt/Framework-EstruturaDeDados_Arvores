package Arvores;

/**
 * Classe para representar uma árvore AVL.
 *
 * @author Diego Dal Witt
 * @version 1.0
 */
public class ArvoreAVL implements Arvore {
    private NodoAVL raiz;

    /**
     * Construtor para criar uma nova árvore AVL.
     */
    public ArvoreAVL() {
        raiz = null;
    }

    /**
     * Insere um novo nó na árvore AVL com a chave fornecida.
     *
     * @param chave a chave do novo nó
     */
    @Override
    public void inserir(int chave) {
        raiz = inserirRecursivo(raiz, chave);
    }

    /**
     * Busca um nó na árvore AVL com a chave fornecida.
     *
     * @param chave a chave do nó a ser buscado
     * @return true se a chave for encontrada, false caso contrário
     */
    private NodoAVL inserirRecursivo(NodoAVL atual, int chave) {
        if (atual == null) {
            return new NodoAVL(chave);
        }

        if (chave < atual.getDado()) {
            atual.setEsq(inserirRecursivo((NodoAVL) atual.getEsq(), chave));
        } else if (chave > atual.getDado()) {
            atual.setDir(inserirRecursivo((NodoAVL) atual.getDir(), chave));
        } else {
            // Chave duplicada, não faz nada
            return atual;
        }

        // Atualiza altura do nó ancestral
        atual.setAlte(1 + Math.max(height((NodoAVL) atual.getEsq()), height((NodoAVL) atual.getDir())));

        // Verifica o balanceamento
        int balance = getBalance(atual);

        // Se o nó está desbalanceado, há 4 casos a serem tratados
        if (balance > 1 && chave < atual.getEsq().getDado()) {
            return rotacaoDireita(atual);
        }

        if (balance < -1 && chave > atual.getDir().getDado()) {
            return rotacaoEsquerda(atual);
        }

        if (balance > 1 && chave > atual.getEsq().getDado()) {
            atual.setEsq(rotacaoEsquerda((NodoAVL) atual.getEsq()));
            return rotacaoDireita(atual);
        }

        if (balance < -1 && chave < atual.getDir().getDado()) {
            atual.setDir(rotacaoDireita((NodoAVL) atual.getDir()));
            return rotacaoEsquerda(atual);
        }

        return atual;
    }

    @Override
    public boolean buscar(int chave) {
        return buscarRecursivo(raiz, chave) != null;
    }

    private NodoAVL buscarRecursivo(NodoAVL atual, int chave) {
        if (atual == null || atual.getDado() == chave) {
            return atual;
        }

        if (atual.getDado() > chave) {
            return buscarRecursivo((NodoAVL) atual.getEsq(), chave);
        }

        return buscarRecursivo((NodoAVL) atual.getDir(), chave);
    }
    
    // Funções auxiliares para balanceamento da árvore AVL
    private NodoAVL rotacaoDireita(NodoAVL y) {
        NodoAVL x = (NodoAVL) y.getEsq();
        NodoAVL T2 = (NodoAVL) x.getDir();
  
        x.setDir(y);
        y.setEsq(T2);
  
        y.setAlte(Math.max(height((NodoAVL) y.getEsq()), height((NodoAVL) y.getDir())) + 1);
        x.setAlte(Math.max(height((NodoAVL) x.getEsq()), height((NodoAVL) x.getDir())) + 1);
  
        return x;
    }

    private NodoAVL rotacaoEsquerda(NodoAVL x) {
        NodoAVL y = (NodoAVL) x.getDir();
        NodoAVL T2 = (NodoAVL) y.getEsq();
  
        y.setEsq(x);
        x.setDir(T2);
  
        x.setAlte(Math.max(height((NodoAVL) x.getEsq()), height((NodoAVL) x.getDir())) + 1);
        y.setAlte(Math.max(height((NodoAVL) y.getEsq()), height((NodoAVL) y.getDir())) + 1);
  
        return y;
    }

    private int getBalance(NodoAVL N) {
        if (N == null) return 0;
        return height((NodoAVL) N.getEsq()) - height((NodoAVL) N.getDir());
    }

    private int height(NodoAVL N) {
        if (N == null) return 0;
        return N.getAlte();
    }
}

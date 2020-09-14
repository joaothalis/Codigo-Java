package arvorebinaria;

public class Tree<T extends Comparable<T>> {

    private TreeNode<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    public void inserir(T value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            root.inserirNode(root, value);
        }
    }

    public T buscar(T value) {
        if (root == null) {
            return null;
        } else {
            return root.buscarNode(value);
        }
    }

    public void remover(T value) {
        if (root == null) {
            System.out.println("Árvoze vazia!");
        } else {
            root = remover(root, value);
        }
    }

    private TreeNode<T> remover(TreeNode<T> r, T value) {
        if (r == null) {
            System.out.println("Elemento não encontrado!");
        } else if (value.compareTo(r.getInfo()) == 0) {
            TreeNode<T> pai, filho;
            if (r.getLeft() == null && r.getRight() == null) {
                r = null;
            } else if (r.getLeft() == null) {
                r = r.getRight();
            } else if (r.getRight() == null) {
                r = r.getLeft();
            } else {
                pai = r.getLeft();
                filho = pai.getRight();
                if(filho != null){
                    while(filho.getRight()!= null){
                        pai = filho;
                        filho = filho.getRight();
                    }
                    r.setInfo(filho.getInfo());
                    pai.setRight(filho.getRight());
                } else{
                    r.setLeft(pai.getLeft());
                    r.setInfo(pai.getInfo());
                }
            }
        } else if (value.compareTo(r.getInfo()) < 0) {
            r.setLeft(remover(r.getLeft(), value));
        } else {
            r.setRight(remover(r.getRight(), value));
        }
        return r;
    }

    public void imprimirMenor() {
        if (root == null) {
            System.out.println("Árvore vazia!");
        } else {
            System.out.println(menorElemento(root).getInfo());
        }
    }

    private TreeNode<T> menorElemento(TreeNode<T> r) {
        if (r != null && r.getLeft() == null) {
            return r;
        } else {
            return menorElemento(r.getLeft());
        }
    }

    public void imprimirMaior() {
        if (root == null) {
            System.out.println("Árvore vazia!");
        } else {
            System.out.println(maiorElemento(root).getInfo());
        }
    }

    private TreeNode<T> maiorElemento(TreeNode<T> r) {
        if (r != null && r.getRight() == null) {
            return r;
        } else {
            return maiorElemento(r.getRight());
        }
    }

    public void emOrdem() {
        if (root == null) {
            System.out.println("Árvore vazia!");
        } else {
            percorrerEmOrdem(root);
        }
    }

    private void percorrerEmOrdem(TreeNode<T> r) {
        if (r != null) {
            percorrerEmOrdem(r.getLeft());
            System.out.println(r.getInfo());
            percorrerEmOrdem(r.getRight());
        }
    }

    public void preOrdem() {
        if (root == null) {
            System.out.println("Árvore vazia!");
        } else {
            percorrerPreOrdem(root);
        }
    }

    private void percorrerPreOrdem(TreeNode<T> r) {
        if (r != null) {
            System.out.println(r.getInfo());
            percorrerPreOrdem(r.getLeft());
            percorrerPreOrdem(r.getRight());
        }
    }

    public void posOrdem() {
        if (root == null) {
            System.out.println("Árvore vazia!");
        } else {
            percorrerPosOrdem(root);
        }
    }

    private void percorrerPosOrdem(TreeNode<T> r) {
        if (r != null) {
            percorrerPosOrdem(r.getLeft());
            percorrerPosOrdem(r.getRight());
            System.out.println(r.getInfo());
        }
    }
}

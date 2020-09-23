package arvoreavl;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AVLTree<K, V> implements MyMap<K, V> {

    private AVLNode<K, V> root;
    private int numKeys;
    
    private AVLNode menorElemento(AVLNode r) {
        if (r != null && r.getLeft() == null) {
            return r;
        } else {
            return menorElemento(r.getLeft());
        }
    }
    
    private int altura(AVLNode<K, V> r) {
        if (r != null) {
            return r.getHeight();
        }
        return 0;
    }

    private int getBalance(AVLNode<K, V> r) {
        if (r != null) {
            return (altura(r.getLeft()) - altura(r.getRight()));
        }
        return 0;
    }

    private AVLNode<K, V> rightRotate(AVLNode<K, V> r) {
        AVLNode<K, V> nodeL = r.getLeft();
        AVLNode<K, V> lChildren = nodeL.getRight();

        nodeL.setRight(r);
        r.setLeft(lChildren);

        return nodeL;
    }

    private AVLNode<K, V> leftRotate(AVLNode<K, V> r) {
        AVLNode<K, V> nodeR = r.getRight();
        AVLNode<K, V> rChildren = nodeR.getLeft();

        nodeR.getLeft();
        r.setRight(rChildren);

        return nodeR;
    }

    @Override
    public int size() {
        return numKeys;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root, (Comparable) key);
    }

    private V get(AVLNode<K, V> r, Comparable key) {
        if (r == null) {
            return null;
        }

        if (key.compareTo(r.getKey()) == 0) {
            return (V) r.getValue();
        } else if (key.compareTo(r.getKey()) < 0) {
            return (V) get(r.getLeft(), key);
        } else {
            return (V) get(r.getRight(), key);
        }
    }

    @Override
    public void put(K key, V value) {
        if (key == null || value == null) {
            System.out.println("Não é permitido!");
        } else {
            root = put(root, (Comparable) key, value);
        }
    }

    private AVLNode<K, V> put(AVLNode<K, V> r, Comparable key, V value) {
        if (r == null) {
            numKeys++;
            return new AVLNode(key, value);
        }

        if (key.compareTo(r.getKey()) < 0) {
            r.setLeft(put(r.getLeft(), key, value));
        } else if (key.compareTo(r.getKey()) > 0) {
            r.setRight(put(r.getRight(), key, value));
        } else {
            return r;
        }

        r.setHeight(1 + Math.max(altura(r.getLeft()), altura(r.getRight())));
        int balance = getBalance(r);

        if (balance > 1 && key.compareTo(r.getLeft().getKey()) < 0) {
            return rightRotate(r);
        }

        if (balance < -1 && key.compareTo(r.getRight().getKey()) > 0) {
            return leftRotate(r);
        }

        if (balance > 1 && key.compareTo(r.getLeft().getKey()) > 0) {
            r.setLeft(leftRotate(r.getLeft()));
            return rightRotate(r);
        }
        if (balance < -1 && key.compareTo(r.getRight().getKey()) < 0) {
            r.setRight(rightRotate(r));
            return leftRotate(r);
        }
        return r;
    }

    @Override
    public V remove(K key) {
        V aux = get(key);
        if (aux == null) {
            System.out.println("Elemento não encontrado");
        } else {
            root = remove(root, (Comparable) key);
        }
        return aux;
    }

    private AVLNode<K, V> remove(AVLNode<K, V> r, Comparable key) {
        if (root == null) {
            return root;
        }
        if (key.compareTo(r.getKey()) < 0) {
            r.setLeft(remove(r.getLeft(), key));
        } else if (key.compareTo(r.getKey()) > 0) {
            r.setRight(remove(r.getRight(), key));
        } else {
            if ((r.getLeft() == null) || (r.getRight() == null)) {
                AVLNode aux = null;
                if (aux == r.getLeft()) {
                    aux = r.getRight();
                } else {
                    aux = r.getLeft();
                }

                if (aux == null) {
                    aux = r;
                    r = null;
                } else {
                    r = aux;
                }
            } else {
                AVLNode aux = menorElemento(r.getRight());
                r.setKey((K) aux.getKey());
                r.setRight(remove(r.getRight(), key));
                numKeys--;
            }
        }
        if (r == null) {
            return r;
        }
        r.setHeight(1 + Math.max(altura(r.getLeft()), altura(r.getRight())));
        
        int balance = getBalance(r);

        if (balance > 1 && key.compareTo(r.getLeft().getKey()) < 0) {
            return rightRotate(r);
        }

        if (balance < -1 && key.compareTo(r.getRight().getKey()) > 0) {
            return leftRotate(r);
        }

        if (balance > 1 && key.compareTo(r.getLeft().getKey()) > 0) {
            r.setLeft(leftRotate(r.getLeft()));
            return rightRotate(r);
        }
        if (balance < -1 && key.compareTo(r.getRight().getKey()) < 0) {
            r.setRight(rightRotate(r));
            return leftRotate(r);
        }
        return r;
    }

    @Override
    public void clear() {
        root = null;
        numKeys = 0;
    }

    @Override
    public Set<K> keySet() {
        List set = new LinkedList();
        keySet(root, set);
        return (Set<K>) set;
    }

    private void keySet(AVLNode<K, V> r, List set) {
        if(r != null){
            keySet(r.getLeft(), set);
            set.add(r.getKey());
            keySet(r.getRight(), set);
        }
    }
}

package arvoreavl;

class AVLNode<K, V> {

    private K key;
    private V value;
    private int height;
    private AVLNode left;
    private AVLNode right;

    AVLNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.height = 1;
    }

    V getValue() {
        return this.value;
    }

    void setValue(V value) {
        this.value = value;
    }

    K getKey() {
        return key;
    }

    void setKey(K key) {
        this.key = key;
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    AVLNode getLeft() {
        return left;
    }

    void setLeft(AVLNode left) {
        this.left = left;
    }

    AVLNode getRight() {
        return right;
    }

    void setRight(AVLNode right) {
        this.right = right;
    }
}

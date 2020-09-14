package arvorebinaria;

class TreeNode<T extends Comparable<T>> {

    private TreeNode<T> left;
    private TreeNode<T> right;
    private T info;

    TreeNode(T value) {
        this.info = value;
    }

    TreeNode<T> getLeft() {
        return left;
    }

    void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    TreeNode<T> getRight() {
        return right;
    }

    void setRight(TreeNode<T> right) {
        this.right = right;
    }

    T getInfo() {
        return info;
    }

    void setInfo(T value) {
        this.info = value;
    }

    TreeNode<T> inserirNode(TreeNode<T> r, T value) {
        if (r == null) {
            r = new TreeNode(value);
        } else if (value.compareTo(r.getInfo()) < 0) {
            r.setLeft(inserirNode(r.getLeft(), value));
        } else {
            r.setRight(inserirNode(r.getRight(), value));
        }
        return r;
    }

    T buscarNode(T value) {
        if (value.compareTo(this.info) == 0) {
            return this.info;
        } else if (value.compareTo(this.info) < 0) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.buscarNode(value);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.buscarNode(value);
            }
        }
    }
}

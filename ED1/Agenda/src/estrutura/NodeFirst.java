package estrutura;

import classes.Letra;

class NodeFirst{

    private NodeFirst prev;
    private Letra info;
    private NodeFirst next;

    public NodeFirst(Letra info) {
        this.info = info;
    }

    public NodeFirst getPrev() {
        return prev;
    }

    public void setPrev(NodeFirst prev) {
        this.prev = prev;
    }

    public Letra getInfo() {
        return info;
    }

    public void setInfo(Letra info) {
        this.info = info;
    }

    public NodeFirst getNext() {
        return next;
    }

    public void setNext(NodeFirst next) {
        this.next = next;
    }

}

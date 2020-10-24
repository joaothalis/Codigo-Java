package estrutura;

import classes.Contato;

public class NodeSecond {
    
    private NodeSecond prev;
    private Contato info;
    private NodeSecond next;

    public NodeSecond(Contato info) {
        this.info = info;
    }

    public NodeSecond getPrev() {
        return prev;
    }

    public void setPrev(NodeSecond prev) {
        this.prev = prev;
    }

    public Contato getInfo() {
        return info;
    }

    public void setInfo(Contato info) {
        this.info = info;
    }

    public NodeSecond getNext() {
        return next;
    }

    public void setNext(NodeSecond next) {
        this.next = next;
    }
    
}

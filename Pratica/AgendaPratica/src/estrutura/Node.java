package estrutura;
import classes.Contato;
import java.io.Serializable;

class Node implements Serializable{
    private Node prev;
    private Contato info;
    private Node next;

    Node (Contato info) {
        this.info = info;
    }

    Node getPrev() {
        return prev;
    }

    void setPrev(Node prev) {
        this.prev = prev;
    }

    Contato getInfo() {
        return info;
    }

    void setInfo(Contato info) {
        this.info = info;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}

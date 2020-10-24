package produtosloja;

class Node {
    private Produto info;
    private Node next;
    
    Node (Produto info){
        this.info = info;
    }
    
    void setInfo(Produto info){
        this.info = info;
    }
    
    Produto getInfo(){
        return this.info;
    }
    
    void setNext(Node next){
        this.next = next;
    }
    
    Node getNext(){
        return this.next;
    }
}
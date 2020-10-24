package primeiralista;

class Node {
    private Integer info;
    private Node next;
    
    void setInfo (int info){
        this.info = info;
    }
    
    int getInfo(){
        return this.info;
    }
    
    void setNext (Node next){
        this.next = next;
    }
    
    Node getNext(){
        return this.next;
    }
}
//questão 4)
package br.unicap.listaSoma.Q4;

class Node {
    private int info;
    private Node next;
    
    Node(int info){
        this.info=info;
    }
    
    void setInfo(int info){
        this.info=info;
    }
    
    int getInfo(){
        return this.info;
    }
    
    void setNext(Node next){
        this.next=next;
    }
    
    Node getNext(){
        return this.next;
    }
}
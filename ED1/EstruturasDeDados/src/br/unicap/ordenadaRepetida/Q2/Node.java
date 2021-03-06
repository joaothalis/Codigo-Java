//questão 2)
package br.unicap.ordenadaRepetida.Q2;

class Node<T> {
    
    private T info;
    private Node<T> next;
    
    Node (T info){
        this.info=info;
    }
    
    void setInfo(T info){
        this.info=info;
    }
    
    T getInfo(){
        return this.info;
    }
    
    void setNext(Node<T> next){
        this.next = next;
    }
    
    Node<T> getNext(){
        return this.next;
    }
}
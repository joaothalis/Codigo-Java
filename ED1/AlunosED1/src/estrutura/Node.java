package estrutura;
import classes.Aluno;

class Node {
    private Aluno info;
    private Node next;
    
    Node(Aluno info){ //construtor
        this.info = info;
    }
    
    void setInfo(Aluno info){
        this.info = info;
    }
    
    Aluno getInfo(){
        return this.info;
    }
    
    void setNext(Node next){
        this.next = next;
    }
    
    Node getNext(){
        return this.next;
    }
}
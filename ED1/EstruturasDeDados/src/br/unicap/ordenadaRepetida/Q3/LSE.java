//questão 3)
package br.unicap.ordenadaRepetida.Q3;

public class LSE<T extends Comparable <T>> {
    private Node<T> first;
    private Node<T> last;
    private int qtd;
    
    public boolean isEmpty(){
        return this.qtd==0;
    }
    
    public void inserirOrdenado(T value){
        Node novo = new Node(value);
        Node<T> atual, anterior;
        if(this.isEmpty()==true){
            this.first=novo;
            this.last=novo;
            this.qtd++;
        }else{
            if(this.first.getInfo().compareTo(value) > 0){
                novo.setNext(this.first);
                this.first = novo;
                this.qtd++;
            }else{
                anterior = this.first;
                atual = anterior.getNext();
                while(atual != null){
                    if(atual.getInfo().compareTo(value) > 0){
                        break;
                    }
                    anterior = anterior.getNext();
                    atual = atual.getNext();
                }
                anterior.setNext(novo);
                novo.setNext(atual);
                if(atual == null){
                    this.last = novo;
                }
                this.qtd++;
            }
        }
    }
}
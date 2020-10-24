//questão 2)
package br.unicap.ordenadaRepetida.Q2;

public class LSE<T extends Comparable <T>> {
    private Node<T> first;
    private Node<T> last;
    private int qtd;
    
    public boolean isEmpty(){
        return this.qtd==0;
    }
    
    public int remover(T value){
        Node<T> ant, atual;
        int removido = 0;
        if(this.isEmpty()==true){
            System.out.println("Lista vazia");
        }else{
            if(this.first.getInfo().compareTo(value)==0){
                if(this.qtd==1){
                    this.first=null;
                    this.last=null;
                    this.qtd--;
                    removido++;
                }else{
                    this.first = this.first.getNext();
                    this.qtd--;
                    removido++;
                    ant = this.first;
                    atual = ant.getNext();
                    while(atual.getInfo().compareTo(value)>0){
                        if(atual.getInfo().compareTo(value)==0){
                            ant.setNext(atual.getNext());
                            this.qtd--;
                            removido++;
                        }
                        ant=ant.getNext();
                        atual=atual.getNext();
                    }
                }
            }else{
                ant=this.first;
                atual=ant.getNext();
                while(atual.getInfo().compareTo(value)>0){
                    if(atual.getInfo().compareTo(value)==0){
                        ant.setNext(atual.getNext());
                        this.qtd--;
                        removido++;
                    }
                    ant=ant.getNext();
                    atual=atual.getNext();
                }
            }
        }
        return removido;
    }
}
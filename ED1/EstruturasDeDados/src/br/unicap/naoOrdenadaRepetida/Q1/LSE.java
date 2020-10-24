//questão 1)
package br.unicap.naoOrdenadaRepetida.Q1;

public class LSE<T extends Comparable <T>> {
    private Node<T> first;
    private Node<T> last;
    private int qtd;
    
    public boolean isEmpty(){
        return this.qtd==0;
    }
    
    public int remover (T value){
        Node<T> ant, atual;
        boolean achou = false;
        int removido=0;
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
                    ant =this.first;
                    atual = ant.getNext();
                    while(atual != null){
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
                ant = this.first;
                atual = ant.getNext();
                while(atual != null){
                    if(atual.getInfo().compareTo(value)==0){
                        ant.setNext(atual.getNext());
                        this.qtd--;
                        removido++;
                        achou = true;
                    }
                    ant=ant.getNext();
                    atual=atual.getNext();
                }if(achou==false){
                    System.out.println("Elemento não encontrado");
                }
            }
        }
        return removido;
    }
}
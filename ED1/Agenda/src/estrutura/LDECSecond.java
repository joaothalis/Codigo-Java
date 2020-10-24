package estrutura;
import classes.Contato;

public class LDECSecond {
    private NodeSecond first;
    private NodeSecond last;
    private int qtd;
    
    public boolean isEmpty(){
        return this.qtd==0;
    }
    
    public void inserirOrdenado (Contato value){
        NodeSecond novo = new NodeSecond (value);
        NodeSecond aux;
        if(this.isEmpty()==true){
            this.first = novo;
            this.last = novo;
            this.qtd++;
            this.first.setPrev(this.last);
            this.last.setNext(this.first);
        }
        else if(this.first.getInfo().compareTo(value)==0){
            System.out.println("Contato já existente!");
        }
        else if(this.first.getInfo().compareTo(value)>0){
            novo.setNext(this.first);
            this.first.setPrev(novo);
            this.first = novo;
            this.qtd++;
            this.first.setPrev(this.last);
            this.last.setNext(this.first);
        }
        else if (this.last.getInfo().compareTo(value)==0){
            System.out.println("Contato já existente!");
        }
        else if(this.last.getInfo().compareTo(value)<0){
            this.last.setNext(novo);
            novo.setPrev(this.last);
            this.last = novo;
            this.qtd++;
            this.last.setNext(this.first);
            this.first.setPrev(this.last);
        }
        else{
            aux = this.first.getNext();
            do{
                if(aux.getInfo().compareTo(value)==0){
                    System.out.println("Contato já existente!");
                }
                else if(aux.getInfo().compareTo(value)>0){
                    aux.getPrev().setNext(novo);
                    novo.setPrev(aux.getPrev());
                    novo.setNext(aux);
                    aux.setPrev(novo);
                    this.qtd++;
                }
                else{
                    aux = aux.getNext();
                }
            }while(aux != this.first);
        }
    }
    
    public void remover(Contato value){
        NodeSecond atual;
        if(this.first.getInfo().compareTo(value)==0){
            if(this.qtd==1){
                this.first=null;
                this.last=null;
                this.qtd--;
            }
            else{
                this.first = this.first.getNext();
                this.first.setPrev(this.last);
                this.last.setNext(this.first);
                this.qtd--;
            }
        }
        else if(this.last.getInfo().compareTo(value)==0){
            this.last = this.last.getPrev();
            this.last.setNext(this.first);
            this.first.setPrev(this.last);
            this.qtd--;
        }
        else{
            atual = this.first;
            while(true){
                if(atual.getInfo().compareTo(value)==0){
                    atual.getNext().setPrev(atual.getPrev());
                    atual.getPrev().setNext(atual.getNext());
                    this.qtd--;
                    break;
                }
                else if(atual.getInfo().compareTo(value)<0){
                    atual = atual.getNext();
                }
                else{
                    System.out.println("Elemento não encontrado!");
                    break;
                }
            }
        }
    }
    
    public void exibir (Contato value){
        NodeSecond aux=this.first;
        while(true){
            if(aux.getInfo().compareTo(value)==0){
                aux.getInfo().exibirEmail();
                aux.getInfo().exibirTelefone();
                break;
            }
            else if(aux.getInfo().compareTo(value)<0){
                aux=aux.getNext();
            }
            else{
                System.out.println("Elemento não encontrado!");
                break;
            }
        }
    }
}

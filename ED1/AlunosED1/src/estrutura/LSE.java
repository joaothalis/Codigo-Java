package estrutura;
import classes.Aluno;

public class LSE {
    private Node first;
    private Node last;
    private int qtd;
    
    public boolean isEmpty(){
        if(this.qtd == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void inserirInicio(Aluno value){
        Node novo = new Node (value);
        if(this.isEmpty()==true){
            this.first = novo;
            this.last = novo;
            this.qtd++;
        }
        else{
            novo.setNext(this.first);
            this.first = novo;
            this.qtd++;
        }
    }
    
    public void inserirFinal(Aluno value){
        Node novo = new Node (value);
        if(this.isEmpty()==true){
            this.first = novo;
            this.last = novo;
            this.qtd++;
        }
        else{
            this.last.setNext(novo);
            this.last = novo;
            this.qtd++;
        }
    }
    
    public void remorverInicio(){
        if(this.isEmpty()==true){
            System.out.println("Lista vazia!");
        }
        else{
            this.first = this.first.getNext();
            this.qtd--;
            if(this.isEmpty()==true){
                this.last = null;
            }
        }
    }
    
    public void removerFinal(){
        Node aux = this.first;
        if(this.isEmpty()==true){
            System.out.println("Lista vazia!");
        }
        else if(this.qtd==1){
            this.remorverInicio();
        }
        else{
            while(aux.getNext()!= this.last){
                aux=aux.getNext();
            }
            this.last=aux;
            aux.setNext(null);
            this.qtd--;
        }
    }
    
    public void exibirTodos(){
        Node aux = this.first;
        if(this.isEmpty()==true){
            System.out.println("Lista vazia!");
        }
        else{
            while(aux!=null){
                System.out.println(aux.getInfo());
                aux=aux.getNext();
            }
        }
    }
}
    
    /*
    public void inserirInicio1(Aluno value){
        Aluno result;
        result = this.buscar(value);
        if(result != null){
            System.out.println("Aluno repetido!");
        }
        else{
            Node novo = new Node (value);
            if(this.isEmpty()==true){
                this.first = novo;
                this.last = novo;
                this.qtd++;
            }
            else{
                novo.setNext(this.first);
                this.first = novo;
                this.qtd++;
            }
        }
    }
    
    public void inserirFinal1(Aluno value){
        Aluno result;
        result = this.buscar(value);
        if(result != null){
            System.out.println("Aluno repetido!");
        }
        else{
            Node novo = new Node (value);
            if(this.isEmpty()==true){
                this.first = novo;
                this.last = novo;
                this.qtd++;
            }
            else{
                this.last.setNext(novo);
                this.last = novo;
                this.qtd++;
            }
        }
    }
    
    private Aluno buscar (Aluno value){
        Node aux = this.first;
        if(this.isEmpty()==true){
            return null;
        }
        else{
            while (aux != null){
                if(aux.getInfo().compareTo(value)==0){
                    return aux.getInfo();
                }
                aux = aux.getNext();
            }
            return null;
        }
    }

    public void exibirTamanho(){
        if(this.isEmpty()==true){
            System.out.println("Lista vazia!");
        }
        else{
            System.out.println("A lista tem: "+this.qtd+" elemento(s).");
        }
    }
    
    public void exibirNo(Aluno value){
        Aluno result;
        result = this.buscar(value);
        if(result == null){
            System.out.println("Elemento não existe!");
        }
        else{
            System.out.println(result);
        }
    }
    
    private Aluno buscar (Aluno value){
        Node aux = this.first;
        if(this.isEmpty()==true){
            return null;
        }
        else{
            while (aux != null){
                if(aux.getInfo().compareTo(value)==0){
                    return aux.getInfo();
                }
                aux = aux.getNext();
            }
            return null;
        }
    }
    */


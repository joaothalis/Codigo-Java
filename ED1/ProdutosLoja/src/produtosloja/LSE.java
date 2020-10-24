package produtosloja;

public class LSE {
    private Node first;
    private Node last;
    private int qtd;
    
    public boolean isEmpty(){
        if(this.qtd==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    private Produto buscar (Produto value){
        Node aux = this.first;
        if(this.isEmpty()==true){
            return null;
        }
        else{
            while(aux != null){
                if(aux.getInfo().compareTo(value)==0){
                    return aux.getInfo();
                }
                aux=aux.getNext();
            }
            return null;
        }
    }
    
    public void inserirInicio(Produto value){
        Produto result;
        result = this.buscar(value);
        if(result != null){
            System.out.println("Produto repetido!");
        }
        else{
            Node novo = new Node(value);
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
    
    public void inserirFinal(Produto value){
        Produto result;
        result = this.buscar(value);
        if(result != null){
            System.out.println("Produto repetido!");
        }
        else{
            Node novo = new Node(value);
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
    
    public void removerPrimeiro(){
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
            this.removerPrimeiro();
        }
        else{
            while(aux.getNext()!=this.last){
                aux=aux.getNext();
            }
            this.last=aux;
            aux.setNext(null);
            this.qtd--;
        }
    }
    
    public void removerNo(Produto value){
        Node ant, atual;
        boolean achou = false;
        
        if(this.isEmpty() == true){
            System.out.println("Lista vazia!");
        }
        else if(this.qtd == 1){
            if(this.first.getInfo().compareTo(value)==0){
                this.first=null;
                this.last=null;
                this.qtd=0;
            }
            else{
                System.out.println("Elemento não encontrado!");
            }
        }
        else{
            if(this.first.getInfo().compareTo(value)==0){
                this.first = this.first.getNext();
                this.qtd--;
            }
            else if(this.last.getInfo().compareTo(value)==0){
                ant = this.first;
                while(ant.getNext()!= this.last){
                    ant = ant.getNext();
                }
                ant.setNext(null);
                this.last = ant;
                this.qtd--;
            }
            else{
                ant = this.first;
                atual = ant.getNext();
                while(ant != null){
                    if(atual.getInfo().compareTo(value)==0){
                        ant.setNext(atual.getNext());
                        this.qtd--;
                        achou = true;
                        break;
                    }
                    else{
                        atual = atual.getNext();
                        ant = ant.getNext();
                    }
                }
                if(achou == false){
                    System.out.println("Elemento não encontrado!");
                }
            }
        }
    }
    
    public void exibirTodos (){
        Node aux = this.first;
        if(this.isEmpty()==true){
            System.out.println("Lista Vazia!");
        }
        else{
            while (aux != null){
                System.out.println(aux.getInfo());
                aux = aux.getNext();
            }
        }
    }
    
    public void exibirUm (Produto value){
        Produto result;
        result = this.buscar(value);
        if(result == null){
            System.out.println("Elemento não encontrado");
        }
        else{
            System.out.println(result);
        }
    }
    
    public void alterar (Produto value, int op){
        Produto result;
        result = this.buscar(value);
        if(result == null){
            System.out.println("Elemento não encontrado");
        }
        else{
            if(op == 1){
                result.setPreco(value.getPreco());
            }
            else if(op == 2){
                result.setEstoque(value.getEstoque());
            }
            else{
                result.setEstoque(value.getEstoque());
                result.setPreco(value.getPreco());
            }
        }
    }
}
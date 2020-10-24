package primeiralista;

public class LSE {
    private Node first;
    private Node last;
    private int qtd;
    
    public void inserirInicio(int value){
        Node novo = new Node();
        novo.setInfo(value);
        if(this.isEmpty()){
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
    
    public void inserirFinal(int value){
        Node novo = new Node();
        novo.setInfo(value);
        if(this.isEmpty()){
            this.first = novo;
            this.last = novo;
            this.qtd++;
        }
        else{
            novo.setNext(this.last);
            this.last = novo;
            this.qtd++;
        }
    }
    
    public void removerPrimeiro(){
        this.first = this.first.getNext();
        this.qtd--;
    }
    
    public void removerUltimo(){
        this.last = null;
        this.qtd--;
    }
    
    public boolean isEmpty(){
        if(this.qtd == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void exibirTodos(){
        Node aux;
        if(this.isEmpty()==true){
            System.out.println("Lista vazia!");
        }
        else{
            aux = this.first;
            while(aux != null){
                System.out.println(aux.getInfo());
                aux=aux.getNext();
            }
        }
    }
}
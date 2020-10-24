package estrutura;
import classes.Address;
import classes.Contato;
import java.io.Serializable;
import java.util.Scanner;

public class Lista implements Serializable{
    private Node first;
    private Node last;
    private int qtd;
    
    private boolean isEmpty(){
        return this.qtd==0;
    }
    
    public void inserirOrdenado(Contato value){
        Node novo = new Node(value);
        Node aux;
        if(this.isEmpty()){
            this.first = novo;
            this.last = novo;
            this.qtd++;
        }
        else if(this.first.getInfo().compareTo(value) > 0){
            novo.setNext(this.first);
            this.first.setPrev(novo);
            this.first = novo;
            this.qtd++;
        }
        else if(this.last.getInfo().compareTo(value) < 0){
            this.last.setNext(novo);
            novo.setPrev(this.last);
            this.last = novo;
            this.qtd++;
        }
        else{
            aux = this.first.getNext();
            while(aux != null){
                if(aux.getInfo().compareTo(value) > 0){
                    aux.getPrev().setNext(novo);
                    novo.setPrev(aux.getPrev());
                    aux.setPrev(novo);
                    novo.setNext(aux);
                    this.qtd++;
                    return;
                }
                aux = aux.getNext();
            }
        }
    }
    public void exibirTodos(){
        Node aux = this.first;
        if(this.isEmpty()){
            System.out.println("Lista vazia!");
        }
        else{
            while(aux!=null){
                System.out.println(aux.getInfo());
                aux = aux.getNext();
            }
        }
    }
    
    public void exibirUm(Contato value){
        Contato result;
        result = this.buscar(value).getInfo();
        if(result == null){
            System.out.println("Elemento não existe!");
        }
        else{
            System.out.println(result);
        }
    }
    
    private Node buscar (Contato value){
        Node aux = this.first;
        while(true){
            if(this.isEmpty()){
                System.out.println("Lista vazia!");
                return null;
            }
            else if(aux.getInfo().compareTo(value)==0){
                return aux;
            }
            else if(aux.getInfo().compareTo(value)<0){
                aux=aux.getNext();
            }
            else{
                System.out.println("Elemento não encontrado!");
                return null;
            }
        }
    }
    
    public void alterarContato(Contato value){
        Node aux = buscar(value);
        String nome, celular, rua, numero, complemento, bairro, cidade, estado, pais, cep;
        Address endereco;
        int op;
        Scanner in = new Scanner (System.in);
        if(aux!=null){
            System.out.println("O que deseja alterar?\n"
                    + "1 - nome\n"
                    + "2 - celular\n"
                    + "3 - endereço");
            op = in.nextInt(); in.nextLine();
            switch(op){
                case 1:
                    remove(aux.getInfo());
                    System.out.println("Digite o novo nome:");
                    nome = in.nextLine();
                    aux.getInfo().setNome(nome);
                    inserirOrdenado(aux.getInfo());
                    System.out.println("Nome alterado!");
                case 2:
                    System.out.println("Digite o novo numero: ");
                    celular = in.nextLine();
                    aux.getInfo().setCelular(celular);
                    System.out.println("Numero alterado!");
                case 3:
                    System.out.println("Digite a rua:");
                    rua = in.nextLine();
                    System.out.println("Digite o numero:");
                    numero = in.nextLine();
                    System.out.println("Digite o complemento:");
                    complemento = in.nextLine();
                    System.out.println("Digite o bairro:");
                    bairro = in.nextLine();
                    System.out.println("Digite a cidade:");
                    cidade = in.nextLine();
                    System.out.println("Digite o estado:");
                    estado = in.nextLine();
                    System.out.println("Digite o pais");
                    pais = in.nextLine();
                    System.out.println("Digite o CEP");
                    cep = in.nextLine();
                    endereco = new Address(rua,numero,complemento,bairro,cidade,estado,pais,cep);
                    aux.getInfo().setEndereço(endereco);
                    System.out.println("Endereço alterado!");
            }
        }
        else{
            System.out.println("Não encontrado!");
        }
    }
    
    public void remove(Contato value){
        Node aux = this.first;
        if(this.isEmpty()){
            System.out.println("Lista vazia");
        }
        else{
            if(value.compareTo(this.first.getInfo())==0){
                if(this.qtd==1){
                    this.first=null;
                    this.last=null;
                    this.qtd--;
                }
                else{
                    this.first = this.first.getNext();
                    this.first.setPrev(null);
                    this.qtd--;
                }
            }
            else if(value.compareTo(this.last.getInfo())==0){
                if(this.qtd==1){
                    this.first=null;
                    this.last=null;
                    this.qtd--;
                }
                else{
                    this.last = this.last.getPrev();
                    this.last.setNext(null);
                    this.qtd--;
                }
            }
            else{
                while(value.compareTo(aux.getInfo())<0){
                    if(value.compareTo(aux.getInfo())==0){
                        aux.setNext(aux.getNext());
                        aux.setPrev(aux.getPrev());
                        this.qtd--;
                        return;
                    }
                }
            }
        }
    }
}

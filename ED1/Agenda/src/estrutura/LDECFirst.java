package estrutura;
import classes.*;

public class LDECFirst {
    private NodeFirst first;
    private NodeFirst last;
    private int qtd;
    
    public boolean isEmpty() {
        return this.qtd == 0;
    }

    public void cadastar(Contato value) {
        char aux = value.getNome().toLowerCase().charAt(0);
        Letra l = new Letra(aux);
        l.setLista(value);
        NodeFirst novo = new NodeFirst(l);
        NodeFirst aux1;
        if (this.isEmpty()) {
            this.first = novo;
            this.last = novo;
            this.qtd++;
            this.first.setPrev(this.last);
            this.last.setNext(this.first);
        } else if (this.first.getInfo().getLetra() == novo.getInfo().getLetra()) {
            this.first.getInfo().setLista(value);
        } else if (this.first.getInfo().getLetra() > novo.getInfo().getLetra()) {
            novo.setNext(this.first);
            this.first.setPrev(novo);
            this.first = novo;
            this.qtd++;
            this.first.setPrev(this.last);
            this.last.setNext(this.first);
        } else if (this.last.getInfo().getLetra() == novo.getInfo().getLetra()) {
            this.last.getInfo().setLista(value);
        } else if (this.last.getInfo().getLetra() < novo.getInfo().getLetra()) {
            this.last.setNext(novo);
            novo.setPrev(this.last);
            this.last = novo;
            this.qtd++;
            this.last.setNext(this.first);
            this.first.setPrev(this.last);
        } else {
            aux1 = this.first.getNext();
            do {
                if (aux1.getInfo().getLetra() == novo.getInfo().getLetra()) {
                    aux1.getInfo().setLista(value);
                } else if (aux1.getInfo().getLetra() > novo.getInfo().getLetra()) {
                    aux1.getPrev().setNext(novo);
                    novo.setPrev(aux1.getPrev());
                    novo.setNext(aux1);
                    aux1.setPrev(novo);
                    this.qtd++;
                } else {
                    aux1 = aux1.getNext();
                }
            } while (aux1 != this.first);
        }
    }

    public void remover(Contato value) {
        NodeFirst atual;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else {
            if (this.first.getInfo().getLetra() == value.getNome().toLowerCase().charAt(0)) {
                if (this.qtd == 1) {
                    this.first.getInfo().removerLista(value);
                    this.first = null;
                    this.last = null;
                    this.qtd--;
                } else {
                    this.first.getInfo().removerLista(value);
                    if (this.first.getInfo().getLista().isEmpty() == true) {
                        this.first = this.first.getNext();
                        this.first.setPrev(this.last);
                        this.last.setNext(this.first);
                        this.qtd--;
                    }
                }
            } else if (this.last.getInfo().getLetra() == value.getNome().toLowerCase().charAt(0)) {
                this.last.getInfo().removerLista(value);
                if (this.last.getInfo().getLista().isEmpty() == true) {
                    this.last = this.last.getPrev();
                    this.last.setNext(this.first);
                    this.first.setPrev(this.last);
                    this.qtd--;
                }
            } else {
                atual = this.first;
                while (true) {
                    if (atual.getInfo().getLetra() == value.getNome().toLowerCase().charAt(0)) {
                        atual.getInfo().removerLista(value);
                        if (atual.getInfo().getLista().isEmpty() == true) {
                            atual.getNext().setPrev(atual.getPrev());
                            atual.getPrev().setNext(atual.getNext());
                            this.qtd--;
                        }
                        break;
                    } else if (atual.getInfo().getLetra() < value.getNome().toLowerCase().charAt(0)) {
                        atual = atual.getNext();
                    } else {
                        System.out.println("Elemento não encontrado");
                        break;
                    }
                }
            }
        }
    }

    public void exibirDados(Contato value) {
        NodeFirst aux;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else {
            aux = this.first;
            while (true) {
                if (aux.getInfo().getLetra() == value.getNome().toLowerCase().charAt(0)) {
                    aux.getInfo().getLista().exibir(value);
                    break;
                } else if (aux.getInfo().getLetra() == value.getNome().toLowerCase().charAt(0)) {
                    aux = aux.getNext();
                } else {
                    System.out.println("Elemento não encontrado");
                    break;
                }
            }
        }
    }
}

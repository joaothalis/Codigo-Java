package br.unicap.questaoOrdenada;

public class LSE<T extends Comparable<T>> {

    private Node<T> first;
    private Node<T> last;
    private int qtd;

    public boolean isEmpty() {
        if (this.qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    private Node<T> buscarMelhorada(T value) {
        Node<T> aux = this.first;
        if (this.isEmpty() == true) {
            return null;
        } else {
            while (aux != null) {
                if (aux.getInfo().compareTo(value) == 0) {
                    return aux;
                } else if (aux.getInfo().compareTo(value) > 0) {
                    return null;
                } else {
                    aux = aux.getNext();
                }
            }
            return null;
        }
    }

    private void remover(T value) {
        Node<T> ant, atual;
        if (this.isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else if (this.qtd == 1) {
            if (this.first.getInfo().compareTo(value) == 0) {
                this.first = null;
                this.last = null;
                this.qtd--;
            } else {
                System.out.println("Não encontrado");
            }
        } else if (this.first.getInfo().compareTo(value) > 0) {
            System.out.println("Valor não encontrado");
        } else if (this.first.getInfo().compareTo(value) == 0) {
            this.first = this.first.getNext();
            this.qtd--;
        } else if (this.last.getInfo().compareTo(value) < 0) {
            System.out.println("Valor não encontrado");
        } else if (this.last.getInfo().compareTo(value) == 0) {
            atual = this.first;
            while (atual.getNext() != null) {
                atual = atual.getNext();
            }
            atual.setNext(null);
            this.last = atual;
            this.qtd--;
        } else {
            ant = this.first;
            atual = ant.getNext();
            while (atual != null) {
                if (atual.getInfo().compareTo(value) == 0) {
                    ant.setNext(atual.getNext());
                    this.qtd--;
                    return;
                } else if (atual.getInfo().compareTo(value) > 0) {
                    System.out.println("elemento não encontrado");
                    return;
                } else {
                    ant = atual;
                    atual = atual.getNext();
                }
            }
        }
    }
}
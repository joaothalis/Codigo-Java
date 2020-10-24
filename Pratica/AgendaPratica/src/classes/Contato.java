package classes;

import classes.Address;
import java.io.Serializable;

public class Contato implements Serializable {
    private String nome;
    private String celular;
    private Address endereço;

    public Contato(String nome, String celular, Address endereço) {
        this.nome = nome;
        this.celular = celular;
        this.endereço = endereço;
    }
    public Contato(){
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Address getEndereço() {
        return endereço;
    }

    public void setEndereço(Address endereço) {
        this.endereço = endereço;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", celular=" + celular + ", endereço=" + endereço + '}';
    }
    
    public int compareTo(Contato value){
        return this.nome.compareToIgnoreCase(value.getNome());
    }
}

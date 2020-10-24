package objetopratica;

import java.io.Serializable;

public class Address implements Serializable{
    private String end;
    private String cidade;
    private String estado;
    private String cep;

    public Address(String end, String cidade, String estado, String cep) {
        this.end = end;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    Address() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return "Address{" + "end=" + end + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + '}';
    }
    
}

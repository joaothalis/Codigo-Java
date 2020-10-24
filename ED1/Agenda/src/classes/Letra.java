package classes;
import estrutura.LDECSecond;

public class Letra {
    private final char letra;
    private final LDECSecond lista;
    
    public Letra (char letra){
        this.letra = letra;
        this.lista = new LDECSecond();
    }

    public char getLetra() {
        return letra;
    }
    
    public LDECSecond getLista(){
        return this.lista;
    }
    
    public void setLista(Contato value){
        this.lista.inserirOrdenado(value);
    }
    
    public void removerLista (Contato value){
        this.lista.remover(value);
    }
}

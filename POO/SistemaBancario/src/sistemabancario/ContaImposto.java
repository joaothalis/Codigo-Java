package sistemabancario;

public class ContaImposto extends Conta{
    
    private double imposto;
    
    public ContaImposto (int numId, double valor){
        super(numId,valor);
    }
    
    public boolean sacar(double valor){
        this.imposto = valor * 1.05;
        return super.sacar(this.imposto);
    }
}

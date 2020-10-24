package sistemabancario;

public class Conta {
    private int numId;
    private double saldo;
    private boolean status;

    public Conta(int numId, double saldo) {
        this.numId = numId;
        this.saldo = saldo;
        status = true;
    }
    
    public void desativar(){
        this.status = false;
    }
    
    public void depositar(double valor){
        if(this.status){
            this.saldo = this.saldo + valor;
        }
    }
    
    public boolean sacar(double valor){
        if(this.saldo >= valor && this.status){
            this.saldo = this.saldo - valor;
            return true;
        }
        return false;
    }
}

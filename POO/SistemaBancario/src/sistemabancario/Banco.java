package sistemabancario;

public class Banco {
    private int contConta;
    private Conta[] contas = new Conta[100];
    
    public Banco(){
        this.contConta = 0;
    }
    
    public int criarConta(){
        Conta c = new Conta (contConta, 0.0);
        contas[contConta] = c;
        return this.contConta++;
    }
    
    public void desativar(int numId){
        contas[numId].desativar();
    }
    
    public boolean sacarConta(double valor, int numId){
        if(numId <= contConta){
            return contas[numId].sacar(valor);
        }
        return false;
    }
    
    public boolean depositarConta(double valor, int numId){
        if(numId <= contConta){
            contas[numId].depositar(valor);
            return true;
        }
        return false;
    }
}

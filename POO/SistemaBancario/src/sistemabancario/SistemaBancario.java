package sistemabancario;
import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op, num;
        double valor;
        boolean aux;
        Banco b = new Banco();
        do{
            System.out.println("O que deseja realizar?\n"
                    + "1 - Criar conta\n"
                    + "2 - Desativar conta\n"
                    + "3 - Realizar saque\n"
                    + "4 - Realizar deposito\n"
                    + "5 - Sair");
            op = in.nextInt();
            switch(op){
                case 1:
                    num = b.criarConta();
                    System.out.println("Conta criado com sucesso.\n"
                            + "Sua ID é: " +num);
                    break;
                case 2:
                    System.out.println("Digite a ID da conta para desativar:");
                    num = in.nextInt();
                    b.desativar(num);
                    System.out.println("Conta ID: "+num+" desativada!");
                    break;
                case 3:
                    System.out.println("Digite a ID da conta:");
                    num = in.nextInt();
                    System.out.println("Digite o valor do saque:");
                    valor = in.nextDouble();
                    aux = b.sacarConta(valor, num);
                    if(aux){
                        System.out.println("Saque realizado com sucesso!");
                    }
                    else{
                        System.out.println("Saque não pôde ser realizado!");
                    }
                    break;
                case 4:
                    System.out.println("Digite a ID da conta:");
                    num = in.nextInt();
                    System.out.println("Digite valor do deposito:");
                    valor = in.nextDouble();
                    aux = b.depositarConta(valor, num);
                    if(aux){
                        System.out.println("Deposito realizado com sucesso!");
                    }
                    else{
                        System.out.println("Deposito não pôde ser realizado!");
                    }
                    break;
                case 5:
                    System.out.println("Saindo!");
                    break;
                default:
                    System.out.println("Digito invalido!"
                            + "Digite novamente:");
                    op = in.nextInt();
            }
        }while(op != 5);
    }
}

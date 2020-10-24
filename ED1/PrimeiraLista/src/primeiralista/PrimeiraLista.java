package primeiralista;
import java.util.Scanner;

public class PrimeiraLista {

    public static void main(String[] args) {
        int aux = 0, v;
        Scanner in = new Scanner (System.in);
        LSE lista = new LSE();

        do{
            System.out.println("O que deseja fazer?\n"
                    + "1 - inserir no início;\n"
                    + "2 - inserir no final\n"
                    + "3 - remover o primeiro\n"
                    + "4 - remover o último\n"
                    + "5 - exibir todos\n");
            
            switch (aux) {
                case 1:
                    System.out.println("informe valor que será inserido: ");
                    v = in.nextInt();
                    lista.inserirInicio(v);
                    break;
                case 2:
                    System.out.println("Informe valor que será inserido: ");
                    v = in.nextInt();
                    lista.inserirFinal(v);
                    break;
                case 3:
                    System.out.println("Você está removendo o primeiro.");
                    lista.removerPrimeiro();
                    break;
                case 4:
                    System.out.println("Você está removendo o ultimo.");
                    lista.removerUltimo();
                    break;
                case 5:
                    System.out.println("Aqui está todos os valores da lista: ");
                    lista.exibirTodos();
                    break;
                case 6:
                    System.out.println("Você está saindo!");
                    break;
                default:
                    System.out.println("Digito invalido!");
                    break;
            }
        }while (aux != 6);
    }
}
package arvorebinaria;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int op = 0, chave;
        Scanner in = new Scanner(System.in);
        Tree arv = new Tree();

        do {
            System.out.println("O que deseja fazer?\n"
                    + "1 - inserir um elemento\n"
                    + "2 - buscar um elemento\n"
                    + "3 - remover um elemento\n"
                    + "4 - imprimir Em Ordem\n"
                    + "5 - imprimir Pre Ordem\n"
                    + "6 - imprimir Pos Ordem\n"
                    + "7 - imprimir maior elemento\n"
                    + "8 - imprimir menor elemento\n"
                    + "9 - sair");
            op = in.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Informe o número a ser inserido:");
                    chave = in.nextInt();
                    arv.inserir(chave);
                    System.out.println("Valor inserido.");
                    break;
                case 2:
                    System.out.println("Informe o número que deseja buscar:");
                    chave = in.nextInt();
                    if (arv.buscar(chave) == null) {
                        System.out.println("Não encontrado");
                    } else {
                        System.out.println("O elemento é: " + arv.buscar(chave));
                    }
                    break;
                case 3:
                    System.out.println("Informe o número a ser removido:");
                    chave = in.nextInt();
                    arv.remover(chave);
                    break;
                case 4:
                    System.out.println("Os valores em ordem são: ");
                    arv.emOrdem();
                    break;
                case 5:
                    System.out.println("Os valores em pré-ordem são:");
                    arv.preOrdem();
                    break;
                case 6:
                    System.out.println("Os valores em pós-ordem são:");
                    arv.posOrdem();
                    break;
                case 7:
                    System.out.println("O maior valor é: ");
                    arv.imprimirMaior();
                    break;
                case 8:
                    System.out.println("O menor valor é: ");
                    arv.imprimirMenor();
                    break;
                case 9:
                    System.out.println("Você está saindo.");
                    break;
                default:
                    System.out.println("Digito invalido!");
                    break;
            }
        } while (op != 9);
    }
}

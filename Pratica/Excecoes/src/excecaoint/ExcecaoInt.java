package excecaoint;

import java.util.Scanner;

public class ExcecaoInt {

    public static void main(String[] args) {
        int colecao[] = new int[10];
        String n;
        int num, pos;
        Scanner in = new Scanner(System.in);
            for(int i = 0;i < 10;i++){
                try{
                    System.out.println("Informe um número:");
                    n = in.nextLine();
                    num = Integer.parseInt(n);
                    System.out.println("Informe uma posição:");
                    pos = in.nextInt(); in.nextLine();
                    colecao[pos]=num;
                }
                catch(ArrayIndexOutOfBoundsException a){
                    throw new ArrayIndexOutOfBoundsException("Posição errada!");
                }
                catch(NumberFormatException b){
                    throw new NumberFormatException("Não é um número!");
                }
        }
    }
}
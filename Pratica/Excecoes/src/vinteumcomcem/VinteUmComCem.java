package vinteumcomcem;

import java.util.Scanner;

public class VinteUmComCem {

    public static void main(String[] args) throws AcimaCemException {
        int soma = 0, qtd = 0, num;
        String n;
        Scanner in = new Scanner(System.in);
        do{
            try{
                System.out.println("Informe um número:");
                n = in.nextLine();
                num = Integer.parseInt(n);
                if(soma + num > 100){
                    throw new AcimaCemException();
                }
                soma += num;
                qtd++;
            }
            catch(NumberFormatException b){
                throw new NumberFormatException("Não é um número!");
            }
            finally{
                System.out.println("Total da soma: " + soma);
                System.out.println("Quantidade de números somados: " + qtd);
                System.out.printf("Média: %.2f \n\n", (double)soma/qtd);
            }
        }while(soma < 100);
    }
}
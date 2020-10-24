package aulanic;
import java.util.Scanner;

public class AulaNic {

    public static void main(String[] args) {
        Televisao [] t = new Televisao [5];
        int i, tamanho;
        Scanner in = new Scanner (System.in);
        
        for (i = 0; i<t.length; i++){
            System.out.println("Digite tamanho da Tv: ");
            tamanho = in.nextInt();
            t[i] = new Televisao(tamanho);
            System.out.println(t[i].toString());
        }
    }
}
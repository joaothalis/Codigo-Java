package lerfilial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LerFilial {
    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt");
        
        try{
            if(!arquivo.exists())
                arquivo.createNewFile();
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter (fw);
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            bw.write("1,189.90");
            bw.newLine();
            bw.write("1,45.70");
            bw.newLine();
            bw.write("3,29.90");
            bw.newLine();
            bw.write("4,55.00");
            bw.newLine();
            bw.close();
            fw.close();
            
            int qtd1=0, qtd2=0, qtd3=0, qtd4=0;
            double filial1=0, filial2=0, filial3=0, filial4=0;
            while(br.ready()){
                String linha = br.readLine();
                String nova;
                
                if(linha.charAt(0) == '1'){
                    nova = linha.substring(2);
                    filial1 = filial1 + Double.parseDouble(nova);
                    qtd1++;
                }else if(linha.charAt(0) == '2'){
                    nova = linha.substring(2);
                    filial2 = filial2 + Double.parseDouble(nova);
                    qtd2++;
                }else if(linha.charAt(0) == '3'){
                    nova = linha.substring(2);
                    filial3 = filial3 + Double.parseDouble(nova);
                    qtd3++;
                }else{
                    nova = linha.substring(2);
                    filial4 = filial4 + Double.parseDouble(nova);
                    qtd4++;
                }
            }
            System.out.printf("O total da filial 1 é: %.2f\n", filial1);
            System.out.printf("valor medio de vendas é: %.2f\n", media(filial1, qtd1));
            System.out.printf("O total da filial 2 é: %.2f\n", filial2);
            System.out.printf("valor medio de vendas é: %.2f\n", media(filial2, qtd2));
            System.out.printf("O total da filial 3 é: %.2f\n", filial3);
            System.out.printf("valor medio de vendas é: %.2f\n", media(filial3, qtd3));
            System.out.printf("O total da filial 4 é: %.2f\n", filial4);
            System.out.printf("valor medio de vendas é: %.2f\n", media(filial4, qtd4));
            
            br.close();
            fr.close();
            
        }catch (IOException ex) {
            Logger.getLogger(LerFilial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static double media(double filial, int qtd){
        if(qtd==0){
            return 0.0;
        }else{
            return filial/qtd;
        }
    }
}

package PraticaArquivo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Arquivo {
    public static void main(String[] args) {
        File arquivo = new File("arquivo.txt");
        
        try {
            if(!arquivo.exists())
                arquivo.createNewFile();
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter (fw);
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            
            bw.write("Olá!");
            bw.newLine();
            bw.write("Oi!");
            bw.newLine();
            bw.close();
            fw.close();
            
            while(br.ready()){
                String linha = br.readLine();
                System.out.println(linha);
            }
            br.close();
            fr.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Arquivo.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}

package objetopratica;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjetoPratica {

    public static void main(String[] args) {
        String end = "Rua Sapiranga, Nº5";
        String cidade = "Recife";
        String estado = "PE";
        String cep = "50.000-000";
        Address end1 = new Address(end, cidade, estado, cep);
        System.out.println(end1);
        File arquivo = new File("arquivoObjeto.obj");
        
        try{
            if(!arquivo.exists())
                arquivo.createNewFile();
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(end1);
            
            oos.close();
            fout.close();
        }catch (IOException ex) {
            Logger.getLogger(ObjetoPratica.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("\nLendo arquivo...");
        try{
            FileInputStream fin = new FileInputStream(arquivo);
            ObjectInputStream ois = new ObjectInputStream(fin);
            while(true){
                System.out.println(ois.readObject());
            }
        } catch (EOFException eofe){
            System.out.println("\nFim de arquivo.");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjetoPratica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjetoPratica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjetoPratica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

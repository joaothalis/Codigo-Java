package listardiretorio;

import java.io.File;

public class ListarDiretorio {
    public static void main(String[] args) {
        File arquivo = new File("C:\\Users\\joaot\\OneDrive\\Área de Trabalho");
        
        if(arquivo.exists()){
            File[] files = arquivo.listFiles();
            if(files.length>0){
                for(int i = 0; i < files.length; i++){
                    System.out.println(files[i].getName());
                }
            }else{
                System.out.println("Diretório está vazio!");
            }
        }else{
            System.out.println("Diretório não existe!");
        }
    }
}
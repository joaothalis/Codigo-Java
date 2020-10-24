package aplicacao;

import classes.Address;
import classes.Contato;
import java.util.Scanner;
import estrutura.Lista;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgendaPratica {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File arquivo = new File("arquivoObjeto.obj");
        Contato con, conBusca;
        String nome, celular, rua, numero, complemento, bairro, cidade, estado, pais, cep;
        Address endereço;
        Lista list = new Lista();
        boolean escolha;
        int op;
        try{
            if(!arquivo.exists())
                arquivo.createNewFile();
            do{
                System.out.println("O que deseja fazer:\n"
                        + "1 - criar contato\n"
                        + "2 - buscar contato\n"
                        + "3 - alterar contato\n"
                        + "4 - listar contatos\n"
                        + "5 - sair");
                op = in.nextInt(); in.nextLine();

                switch(op){
                    case 1:
                        System.out.println("Escreva nome:");
                        nome = in.nextLine();
                        System.out.println("Escreva celular:");
                        celular = in.nextLine();
                        System.out.println("Deseja informar o endereço do contato?\n"
                                + "1 - sim\n"
                                + "2 - não");
                        op = in.nextInt(); in.nextLine();
                        if(op == 1){
                            System.out.println("Escreva nome da rua:");
                            rua = in.nextLine();
                            System.out.println("Escreva o numero do endereço:");
                            numero = in.nextLine();
                            System.out.println("Escreva o complemento do endereço:");
                            complemento = in.nextLine();
                            System.out.println("Escreva o bairro:");
                            bairro = in.nextLine();
                            System.out.println("Escreva a cidade:");
                            cidade = in.nextLine();
                            System.out.println("Escreva o estado:");
                            estado = in.nextLine();
                            System.out.println("Escreva o pais:");
                            pais = in.nextLine();
                            System.out.println("Escreva o cep:");
                            cep = in.nextLine();
                            endereço = new Address(rua, numero, complemento, bairro, cidade, estado, pais, cep);
                            con = new Contato(nome, celular, endereço);
                        } else{
                            con = new Contato(nome, celular, null);
                        }
                        list.inserirOrdenado(con);
                        break;
                    case 2:
                        System.out.println("Escreva nome do contato:");
                        nome = in.nextLine();
                        conBusca = new Contato(nome, null, null);
                        list.exibirUm(conBusca);
                        break;
                    case 3:
                        System.out.println("Escreva nome do contato:");
                        nome = in.nextLine();
                        conBusca = new Contato(nome, null, null);
                        list.alterarContato(conBusca);
                        break;
                    case 4:
                        list.exibirTodos();
                        break;
                    case 5:
                        System.out.println("Saindo!");
                        break;
                    default:
                        System.out.println("Digito inválido!"
                                + "Digite novamente:");
                        op = in.nextInt(); in.nextLine();
                }
            }while(op!=5);
            FileOutputStream fout = new FileOutputStream(arquivo);
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(list);
            
            oos.close();
            fout.close();
        }catch (IOException ex) {
            Logger.getLogger(AgendaPratica.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AgendaPratica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AgendaPratica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgendaPratica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

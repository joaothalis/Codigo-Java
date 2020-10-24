package aplicacao;
import java.util.Scanner;
import classes.Contato;
import estrutura.LDECFirst;

public class Agenda {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDECFirst agenda = new LDECFirst();
        Contato con;
        String nome, email, telefone;
        int op;
        do{
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastra contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Exibir dados do contato");
            System.out.println("0 - Sair");
            System.out.println("Informe a opção: ");
            op = in.nextInt(); in.nextLine();
            switch(op){
                case 1: 
                    System.out.println("Informe o nome: ");
                    nome = in.nextLine();
                    con = new Contato(nome);
                    System.out.println("Informe o email: ");
                    email = in.nextLine();
                    con.setEmail(email);
                    System.out.println("Informe o telefone: ");
                    telefone = in.nextLine();
                    con.setTelefone(telefone);
                    agenda.cadastar(con);
                    System.out.println("Contato cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Informe o nome do contato: ");
                    nome = in.nextLine();
                    con = new Contato(nome);
                    agenda.remover(con);
                    break;
                case 3:
                    System.out.println("Informe o nome do contato: ");
                    nome = in.nextLine();
                    con = new Contato(nome);
                    agenda.exibirDados(con);
                    break;
                case 0:
                    System.out.println("Você está saindo.");
                    break;
                default:
                    System.out.println("Opção não é válida!");
                    break;
            }
        }while(op!=0);
    }
}
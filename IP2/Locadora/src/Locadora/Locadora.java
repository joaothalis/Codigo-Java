package Locadora;
import java.util.Scanner;

public class Locadora {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        String t, d, c;
        int qtd, aux;
        Filme [][] m = new Filme[5][3];
        
        System.out.println("Informe quantidade de filmes para cadastro: ");
        qtd = in.nextInt();
        CadastroFilmes net = new CadastroFilmes(qtd);
        
        do{
            System.out.println("Qual operação deseja fazer?\n"
                    + "1 - Cadastrar filme\n"
                    + "2 - Consultar\n"
                    + "3 - Remover\n"
                    + "4 - Listar pela categoria\n"
                    + "5 - Listar Filmes\n"
                    + "0 - Sair");
            aux = in.nextInt(); in.nextLine();
            switch (aux){
                case 1:
                    System.out.println("Informe o titulo do filme: ");
                    t = in.nextLine();
                    System.out.println("Informe o diretor do filme: ");
                    d = in.nextLine();
                    System.out.println("Informe a categoria do filme: ");
                    c = in.nextLine();
                    Filme f = new Filme(t,d,c);
                    net.inserirOrdenado(f);
                    System.out.println("Filme cadastrado!");
                    break;
                case 2:
                    System.out.println("Qual filme está procurando?");
                    t = in.nextLine();
                    System.out.println(net.consultar(t).toString());
                    break;
                case 3:
                    System.out.println("Qual filme quer remover?");
                    t = in.nextLine();
                    net.remover(t);
                    break;
                case 4:
                    System.out.println("Em qual categoria?");
                    c = in.nextLine();
                    System.out.println("Esses são os filmes dessa categoria:");
                    net.listarCategoria(c);
                    break;
                case 5:
                    System.out.println("Esses são todos os filmes: ");
                    net.listarFilmes();
                    break;
                case 0:
                    System.out.println("Você está saindo");
                    break;
                default:
                    System.out.println("Digito inválido");
                    break;
            }
        } while(aux != 0);
    }
}
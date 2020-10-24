package aplicacao;
import java.util.Scanner;
import estrutura.LSE;
import classes.Aluno;

public class AlunosED1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSE turma = new LSE();
        Aluno al;
        String matricula, nome;
        double media;
        int op, faltas;
        do{
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Inserir aluno no iníco");
            System.out.println("2 - Inserir aluno no final");
            System.out.println("3 - Remover aluno no iníco");
            System.out.println("4 - Remover aluno no final");
            System.out.println("5 - Exibir alunos da turma");
            System.out.println("0 - Sair");
            System.out.println("Informe a opção: ");
            op = in.nextInt(); in.nextLine();
            switch(op){
                case 1: 
                    System.out.println("Informe a matrícula: ");
                    matricula = in.nextLine();
                    al = new Aluno(matricula);
                    System.out.println("Informe o nome: ");
                    nome = in.nextLine();
                    al.setNome(nome);
                    System.out.println("Informe a média: ");
                    media = in.nextDouble(); in.nextLine();
                    al.setMedia(media);
                    System.out.println("Informe as faltas: ");
                    faltas = in.nextInt(); in.nextLine();
                    al.setFaltas(faltas);
                    turma.inserirInicio(al);
                    System.out.println("Aluno inserido com sucesso!");
                    break;
                case 2:
                    System.out.println("Informe a matrícula: ");
                    matricula = in.nextLine();
                    al = new Aluno(matricula);
                    System.out.println("Informe o nome: ");
                    nome = in.nextLine();
                    al.setNome(nome);
                    System.out.println("Informe a média: ");
                    media = in.nextDouble(); in.nextLine();
                    al.setMedia(media);
                    System.out.println("Informe as faltas: ");
                    faltas = in.nextInt(); in.nextLine();
                    al.setFaltas(faltas);
                    turma.inserirFinal(al);
                    System.out.println("Aluno inserido com sucesso!");
                    break;
                case 3:
                    turma.remorverInicio();
                    break;
                case 4:
                    turma.removerFinal();
                    break;
                case 5:
                    turma.exibirTodos();
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
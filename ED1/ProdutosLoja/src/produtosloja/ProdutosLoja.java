package produtosloja;
import java.util.Scanner;

public class ProdutosLoja {

    public static void main(String[] args) {
        Produto p;
        String codigo, descricao;
        double preco;
        int op, estoque;
        Scanner in = new Scanner (System.in);
        LSE loja = new LSE();
        do{
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Inserir produto no início");
            System.out.println("2 - Inserir produto no final");
            System.out.println("3 - Remover produto no início");
            System.out.println("4 - Remover produto no final");
            System.out.println("5 - Exibir todos os produtos");
            System.out.println("6 - Exibir um produto");
            System.out.println("7 - Alterar dados de um produto");
            System.out.println("8 - Remover um produto da lista");
            System.out.println("0 - Sair");
            System.out.println("Informe a opção: ");
            op = in.nextInt(); in.nextLine();
            switch (op){
                case 1:
                    System.out.println("Informe o código: ");
                    codigo = in.nextLine();
                    p = new Produto(codigo);
                    System.out.println("Informe a descrição: ");
                    descricao = in.nextLine();
                    p.setDescricao(descricao);
                    System.out.println("Informe o preço: ");
                    preco = in.nextDouble(); in.nextLine();
                    p.setPreco(preco);
                    System.out.println("Informe o estoque: ");
                    estoque = in.nextInt(); in.nextLine();
                    p.setEstoque(estoque);
                    loja.inserirInicio(p);
                    break;
                case 2:
                    System.out.println("Informe o código: ");
                    codigo = in.nextLine();
                    p = new Produto(codigo);
                    System.out.println("Informe a descrição: ");
                    descricao = in.nextLine();
                    p.setDescricao(descricao);
                    System.out.println("Informe o preço: ");
                    preco = in.nextDouble(); in.nextLine();
                    p.setPreco(preco);
                    System.out.println("Informe o estoque: ");
                    estoque = in.nextInt(); in.nextLine();
                    p.setEstoque(estoque);
                    loja.inserirFinal(p);
                    break;
                case 3:
                    loja.removerPrimeiro();
                    break;
                case 4:
                    loja.removerFinal();
                    break;
                case 5:
                    loja.exibirTodos();
                    break;
                case 6:
                    System.out.println("Informe o código do produto: ");
                    codigo = in.nextLine();
                    p = new Produto(codigo);
                    loja.exibirUm(p);
                    break;
                case 7:
                    System.out.println("Informe o código do produto: ");
                    codigo = in.nextLine();
                    p = new Produto(codigo);
                    System.out.println("O que deseja alterar: \n1 - preço \n2 - estoque \n3 - ambos");
                    int op2 = in.nextInt(); in.nextLine();
                    if(op2 == 1){
                        System.out.println("Informe o novo preço: ");
                        preco = in.nextDouble(); in.nextLine();
                        p.setPreco(preco);
                        loja.alterar(p, op2);
                    }
                    else if (op2 == 2){
                        System.out.println("Informe o novo estoque: ");
                        estoque = in.nextInt(); in.nextLine();
                        p.setEstoque(estoque);
                        loja.alterar(p, op2);
                    }
                    else if(op2 == 3){
                        System.out.println("Informe o novo preço: ");
                        preco = in.nextDouble(); in.nextLine();
                        p.setPreco(preco);
                        System.out.println("Informe o novo estoque: ");
                        estoque = in.nextInt(); in.nextLine();
                        p.setEstoque(estoque);
                        loja.alterar(p, op2);
                    }
                    else{
                        System.out.println("Opção não é válida!");
                    }
                    break;
                case 8:
                    System.out.println("Informe o código do produto: ");
                    codigo = in.nextLine();
                    p = new Produto(codigo);
                    loja.removerNo(p);
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
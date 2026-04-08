package main;

import service.ProdutoService;

import java.util.Locale;
import java.util.Scanner;

public class SistemaMain {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ProdutoService produtoService = new ProdutoService();

        int opcao = 7;
        String nomeProduto = null;
        String nomeBusca = null;
        double valorProduto = 0;
        int quantidadeProduto = 0;
        int ID = 0;
        int buscarId = 0;
        String voltarMenuPrincipal = null;

        while (opcao != 0){
            System.out.println("===== SISTEMA DE ESTOQUE =====");
            System.out.println();
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por ID");
            System.out.println("4 - Buscar produto por nome");
            System.out.println("5 - Remover produto por ID");
            System.out.println("6 - Mostrar valor total do estoque");
            System.out.println("7 - Mostrar valor por produto");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            System.out.println();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    nomeProduto = sc.nextLine();
                    System.out.print("Digite o valor do produto: ");
                    valorProduto = sc.nextInt();
                    System.out.print("Digite a quantidade: ");
                    quantidadeProduto = sc.nextInt();
                    sc.nextLine();

                    produtoService.adicionarProdutos(nomeProduto, valorProduto, quantidadeProduto);
                    System.out.println();
                    System.out.println("Produto adicionado com sucesso!");
                    System.out.println();

                    break;
                case 2:
                    produtoService.listarProdutos();
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Digite o ID do poduto: ");
                    ID = sc.nextInt();
                    sc.nextLine();
                    produtoService.buscaPorId(ID);
                    break;
                case 4:
                    System.out.print("Digite o nome do produto: ");
                    nomeBusca = sc.nextLine();
                    produtoService.buscarPorNome(nomeBusca);

                    break;
                case 5:
                    System.out.print("Digite o id do produto: ");
                    buscarId = sc.nextInt();
                    sc.nextLine();
                    produtoService.removerProdutoPorId(buscarId);
                    break;
                case 6:
                    produtoService.valorTotalEstoque();
                    System.out.println();
                    break;
                case 7:
                    produtoService.valorProdutosSeparadamente();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha uma opção valida!");
                    break;


            }

        }

        sc.close();
    }
}

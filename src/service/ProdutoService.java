package service;

public class ProdutoService {

    Produto[] estoque = new Produto[10];
    int posicaoProduto = 0;


    public void adicionarProdutos(String nomeProduto, double valor, int quantidade) {

        if (posicaoProduto == estoque.length) {
            System.out.println("Estoque cheio!");
            return;
        }

        if (valor <= 0 || quantidade <= 0){
            System.out.println("Valor e quantidade devem ser maiores que 0!");
            return;
        }

        Produto produto = new Produto();

        produto.nome = nomeProduto;
        produto.valor = valor;
        produto.quantidade = quantidade;
        produto.ID = posicaoProduto + 1;
        estoque[posicaoProduto] = produto;
        posicaoProduto++;

    }

    public void listarProdutos() {

        if (posicaoProduto == 0) {
            System.out.println("Não há produtos no estoque!");
            return;
        }


        for (int i = 0; i < posicaoProduto; i++) {
            System.out.printf(
                    "ID: %03d | %-10s | R$ %8.2f | Qtd: %3d%n",
                    estoque[i].ID,
                    estoque[i].nome,
                    estoque[i].valor,
                    estoque[i].quantidade
            );

        }
    }

    public void valorTotalEstoque() {

        if (posicaoProduto == 0) {
            System.out.println("Não há produtos no estoque!");
            return;
        }

        double total = 0;

        for (int i = 0; i < posicaoProduto; i++) {
            double valorProduto = estoque[i].valor * estoque[i].quantidade;
            total += valorProduto;
        }

        System.out.println("Valor total do estoque: " + total);
    }


    public void valorProdutosSeparadamente() {

        if (posicaoProduto == 0) {
            System.out.println("⚠️ Nenhum produto cadastrado no estoque.");
            return;
        }

        for (int i = 0; i < posicaoProduto; i++) {
            double valorTotal = estoque[i].valor * estoque[i].quantidade;

            System.out.println("------------------------------");
            System.out.printf("ID: %03d%n", estoque[i].ID);
            System.out.printf("Produto: %s%n", estoque[i].nome);
            System.out.printf("Quantidade: %d%n", estoque[i].quantidade);
            System.out.printf("Preço: R$ %.2f%n", estoque[i].valor);
            System.out.printf("Total: R$ %.2f%n", valorTotal);
        }

        System.out.println("------------------------------");

    }
}

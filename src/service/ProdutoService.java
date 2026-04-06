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

        for (int i = 0; i < posicaoProduto; i++){
            if (estoque[i].nome.equalsIgnoreCase(nomeProduto)){
                System.out.println("Já existe esse produto no estoque!");
                return;
            }
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

    public void removerProdutoPorId(int idProdutoRemover){
        int idEncontrado = -1;

        for(int i = 0; i < posicaoProduto; i++){
            if (estoque[i].ID == idProdutoRemover){
                idEncontrado = i;
                break;
            }
        }

        if(idEncontrado == -1){
            System.out.println("produto não encontrado!");
            return;
        }

        for(int i = idEncontrado; i < posicaoProduto - 1; i++){
            estoque[i] = estoque[i + 1];
        }

        estoque[posicaoProduto - 1] = null;
        posicaoProduto--;

        System.out.println("Produto removido com sucesso! ");

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

    public void buscarPorNome(String buscarNome){

        for (int i = 0; i < posicaoProduto; i++){
            if (estoque[i].nome.equalsIgnoreCase(buscarNome)){
                System.out.println("\n✅ Produto encontrado!");
                System.out.println("------------------------------");
                System.out.println("📦 DETALHES DO PRODUTO");
                System.out.println("------------------------------");

                System.out.printf("ID: %03d%n", estoque[i].ID);
                System.out.printf("Produto: %s%n", estoque[i].nome);
                System.out.printf("Preço: R$ %.2f%n", estoque[i].valor);
                System.out.printf("Quantidade: %d%n", estoque[i].quantidade);

                double total = estoque[i].valor * estoque[i].quantidade;
                System.out.printf("Valor total em estoque: R$ %.2f%n", total);

                System.out.println("------------------------------");
                return;
            }
        }
        System.out.println("\n❌ Produto não encontrado.");
    }


    public void buscaPorId(int buscarId){

    for (int i = 0; i < posicaoProduto; i++){

        if (estoque[i].ID == buscarId){
            System.out.println("\n✅ Produto encontrado!");
            System.out.println("------------------------------");
            System.out.println("📦 DETALHES DO PRODUTO");
            System.out.println("------------------------------");

            System.out.printf("ID: %03d%n", estoque[i].ID);
            System.out.printf("Produto: %s%n", estoque[i].nome);
            System.out.printf("Preço: R$ %.2f%n", estoque[i].valor);
            System.out.printf("Quantidade: %d%n", estoque[i].quantidade);

            double total = estoque[i].valor * estoque[i].quantidade;
            System.out.printf("Valor total em estoque: R$ %.2f%n", total);

            System.out.println("------------------------------");
            return;
        }

    }
        System.out.println("\n❌ Produto não encontrado.");


    }



}

package service;

public class ProdutoService {
    private static final int TAMANHO_MAXIMO = 50;
    Produto[] estoque = new Produto[ProdutoService.TAMANHO_MAXIMO];
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
            if (estoque[i].getNome().equalsIgnoreCase(nomeProduto)){
                System.out.println("Já existe esse produto no estoque!");
                return;
            }
        }


        Produto produto = new Produto(nomeProduto, valor, quantidade, posicaoProduto + 1);
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
                    estoque[i].getID(),
                    estoque[i].getNome(),
                    estoque[i].getValor(),
                    estoque[i].getQuantidade()
            );

        }
    }

    public void removerProdutoPorId(int idProdutoRemover){
        int idEncontrado = -1;

        for(int i = 0; i < posicaoProduto; i++){
            if (estoque[i].getID() == idProdutoRemover){
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
            double valorProduto = estoque[i].getValorTotal();
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
            double valorTotal = estoque[i].getValorTotal();
            System.out.println("------------------------------");
            estoque[i].imprime();
            System.out.printf("Total: R$ %.2f%n", valorTotal);
        }

        System.out.println("------------------------------");

    }

    public void buscarPorNome(String buscarNome){

        for (int i = 0; i < posicaoProduto; i++){
            if (estoque[i].getNome().equalsIgnoreCase(buscarNome)){
                System.out.println("\n✅ Produto encontrado!");
                System.out.println("------------------------------");
                System.out.println("📦 DETALHES DO PRODUTO");
                System.out.println("------------------------------");

                estoque[i].imprime();

                double total = estoque[i].getValorTotal();
                System.out.printf("Valor total em estoque: R$ %.2f%n", total);

                System.out.println("------------------------------");
                return;
            }
        }
        System.out.println("\n❌ Produto não encontrado.");
    }


    public void buscaPorId(int buscarId){

    for (int i = 0; i < posicaoProduto; i++){

        if (estoque[i].getID() == buscarId){
            System.out.println("\n✅ Produto encontrado!");
            System.out.println("------------------------------");
            System.out.println("📦 DETALHES DO PRODUTO");
            System.out.println("------------------------------");

            estoque[i].imprime();

            double total = estoque[i].getValorTotal();
            System.out.printf("Valor total em estoque: R$ %.2f%n", total);

            System.out.println("------------------------------");
            return;
        }

    }
        System.out.println("\n❌ Produto não encontrado.");


    }



}

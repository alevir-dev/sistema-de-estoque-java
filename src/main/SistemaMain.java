package main;

import service.ProdutoService;

import java.util.Locale;
import java.util.Scanner;

public class SistemaMain {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        ProdutoService produtoService = new ProdutoService();


        produtoService.adicionarProdutos("Tablet", 1350, 15);
        produtoService.adicionarProdutos("Notebook", 3000, 15);
        produtoService.adicionarProdutos("Celular", 7500, 15);
        produtoService.adicionarProdutos("Microfone",  500, 15);
        produtoService.adicionarProdutos("Headset",  500, 15);



        sc.close();
    }
}

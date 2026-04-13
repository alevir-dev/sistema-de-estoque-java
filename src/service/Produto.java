package service;

import javax.swing.event.AncestorEvent;

public class Produto {
    private String nome;
    private double valor;
    private int quantidade;
    private int ID;


    public Produto(String nome, double valor, int quantidade, int ID){
       this.nome = nome;
       this.valor = valor;
       this.quantidade = quantidade;
       this.ID = ID;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getValor(){
        return this.valor;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double getValorTotal(){
        return this.valor * this.quantidade;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public int getID(){
        return ID;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void imprime(){
        System.out.printf("ID: %03d%n", this.ID);
        System.out.printf("Produto: %s%n", this.nome);
        System.out.printf("Preço: R$ %.2f%n", this.valor);
        System.out.printf("Quantidade: %d%n", this.quantidade);
    }






}



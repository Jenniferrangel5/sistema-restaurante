package com.restaurante.pedido;

import com.restaurante.cardapio.Lanche;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Pedido {
    private int numero;
    private String nomeCliente;
    private ArrayList<Lanche> itens = new ArrayList<>();

    //verificar depois adicionar item null
    public void adicionarItem(Lanche lanche){
        if (lanche == null){
            throw new IllegalArgumentException("O lanche não pode ser vazio!");
        }
        itens.add(lanche);
    }

    public double calcularTotal(){
        double total = 0;
        for (Lanche item : itens){
            total = total + item.getPreco();
        } return total;
    }

    public void setNomeCliente(String nomeCliente){
        if (nomeCliente == null || nomeCliente.trim().isEmpty()){
            throw new IllegalArgumentException("Preencha o nome!");
        }
        this.nomeCliente = nomeCliente;
    }

    public Pedido(int numero, String nomeCliente){
        this.numero = numero;
        setNomeCliente(nomeCliente);
    }

}

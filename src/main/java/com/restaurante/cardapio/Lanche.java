package com.restaurante.cardapio;

import lombok.Getter;

@Getter
//para os setters não, porque precisa lançar excessão

public class Lanche implements ItemCardapio {
    private String nome;
    private double preco;

    public Lanche(String nome, double preco){
        setNome(nome);
        setPreco(preco);
    }

    @Override
    public String getDescricao() {
        return nome;
    }

    //Os setter alteram os valores dos atributos

    public void setNome(String nome){
        if (nome == null || nome.isBlank()){
            throw new IllegalArgumentException("Preencha o nome!");
        }
        this.nome = nome;
    }

    public void setPreco(double preco){
        if(preco<0){
            throw new IllegalArgumentException("Valor não pode ser negativo!");
        }
        this.preco = preco;
    }
}

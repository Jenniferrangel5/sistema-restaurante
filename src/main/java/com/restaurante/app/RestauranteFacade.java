package com.restaurante.app;

import com.restaurante.cardapio.Lanche;
import com.restaurante.pedido.GerenciadorPedidos;
import com.restaurante.pedido.Pedido;

import java.util.Collection;

public class RestauranteFacade {
    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente){
        return gerenciador.criarPedido(nomeCliente);
    }

    public double calcularTotalDoDia(){
        return gerenciador.calcularTotalDoDia();
    }

    public Pedido buscarPedido (int numero){
        return gerenciador.buscarPedido(numero);
    }

    public Collection<Pedido> getPedidos(){
        return gerenciador.getPedidos();
    }

    public Lanche criarLanche (int opcao){
        return switch (opcao) {
            case 1 -> new Lanche("X-Burger", 16.00);
            case 2 -> new Lanche("X-Salada", 18.00);
            case 3 -> new Lanche("X-Bacon", 22.00);
            default -> throw new IllegalArgumentException("Opção inválida!");
        };
    }
}

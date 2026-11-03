package com.restaurante.app;

import com.restaurante.cardapio.Lanche;
import com.restaurante.cardapio.LancheFactory;
import com.restaurante.pedido.GerenciadorPedidos;
import com.restaurante.pedido.Pedido;

import java.util.Collection;
import java.util.HashSet;

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
            case 1 -> LancheFactory.xBurger();
            case 2 -> LancheFactory.xSalada();
            case 3 -> LancheFactory.xBacon();
            default -> throw new IllegalArgumentException("Opção inválida!");
        };
    }

    public void cancelarPedido (int numeroPedido){
        gerenciador.cancelarPedido(numeroPedido);
    }

    public HashSet<String> listarCombinacoes(){
        return gerenciador.listarCombinacoes();
    }

}

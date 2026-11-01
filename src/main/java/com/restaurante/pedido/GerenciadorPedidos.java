package com.restaurante.pedido;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class GerenciadorPedidos {
    private HashMap<Integer, Pedido> pedidos = new HashMap<>();
    private int contadorPedidos = 1;

    // cria pedido
    public Pedido criarPedido (String nomeCliente){
        Pedido novo = new Pedido(contadorPedidos, nomeCliente);
        pedidos.put(novo.getNumero(), novo);
        contadorPedidos++;
        return novo;
    }

    // busca pedido pelo número
    public Pedido buscarPedido (int numero){
        return pedidos.get(numero);
    }

    // retorna todos os pedidos
    // List.copyOf() permite consultar, mas não fazer alterações

    public Collection<Pedido> getPedidos(){
        return List.copyOf(pedidos.values());
    }

    // calcula total do dia
    public double calcularTotalDoDia(){
        double total = 0;
        for (Pedido p : pedidos.values()) {
            total += p.calcularTotal();
        } return total;
    }
}

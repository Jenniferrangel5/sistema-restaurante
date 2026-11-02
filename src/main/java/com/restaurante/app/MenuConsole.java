package com.restaurante.app;

import com.restaurante.cardapio.ItemCardapio;
import com.restaurante.cardapio.Lanche;
import com.restaurante.pedido.Pedido;

import java.util.Scanner;

public class MenuConsole {
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu(){
        System.out.println("""
        === RESTAURANTE ===
        1 - Registrar novo pedido
        2 - Listar pedidos do dia
        3 - Fechar restaurante
        0 - Sair
        """);
    }

    public void subMenuNovoPedido (){
        System.out.println("""
                
                1 - Adicionar outro lanche
                0 - Finalizar pedido
                """);

    }

    public int lerOpcaoLanche(){
        System.out.print("Escolha o lanche: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public int lerOpcao(){
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }

    public void exibirPedido (Pedido pedido){
        System.out.println("Pedido Nº: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());

        for (ItemCardapio lanche : pedido.getItens()) {
            System.out.printf("%s - R$%.2f\n", lanche.getDescricao(), lanche.getPreco());
        }
        System.out.printf("Total: R$%.2f\n", pedido.calcularTotal());

    }

    public void exibirFechamentoDoDia(double total){
        System.out.printf("Total do dia: R$%.2f\n", total);

    }

    public String lerNomeCliente(){
        System.out.print("Digite seu nome: ");
        String nomeCliente = sc.nextLine();
        return nomeCliente;
    }

}

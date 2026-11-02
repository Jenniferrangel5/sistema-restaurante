package com.restaurante.app;

import com.restaurante.cardapio.Lanche;
import com.restaurante.pedido.Pedido;

public class Main {
    static void main() {
        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistema = new RestauranteFacade();

        int opcao = -1;

        while (opcao!=0){
            menu.exibirMenu();
            opcao = menu.lerOpcao();

            switch (opcao) {
                //1 - Registrar novo pedido
                case 1 -> {
                    String nomeCliente = menu.lerNomeCliente();
                    Pedido pedido = sistema.criarPedido(nomeCliente);

                    int continuar;

                    do {

                        int opcaoLanche = menu.lerOpcaoLanche();
                        Lanche lanche = sistema.criarLanche(opcaoLanche);

                        pedido.adicionarItem(lanche);

                        menu.subMenuNovoPedido();

                        continuar = menu.lerOpcao();
                    } while (continuar == 1);
                }
            }
        }
    }
}

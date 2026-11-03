package com.restaurante.app;

import com.restaurante.cardapio.ComBaconExtra;
import com.restaurante.cardapio.ComCheddar;
import com.restaurante.cardapio.ItemCardapio;
import com.restaurante.cardapio.Lanche;
import com.restaurante.pedido.Pedido;

import java.util.HashSet;

public class Main {
    static void main() {
        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistema = new RestauranteFacade();

        int opcao = -1;

        while (opcao != 0) {
            menu.exibirMenu();
            opcao = menu.lerOpcao();

            switch (opcao) {

                // Registrar novo pedido
                case 1 -> {
                    String nomeCliente = menu.lerNomeCliente();
                    Pedido pedido = sistema.criarPedido(nomeCliente);

                    int continuar;

                    do {
                        int opcaoLanche = menu.lerOpcaoLanche();
                        Lanche lanche = sistema.criarLanche(opcaoLanche);

                        personalizarLanche(menu, lanche);
                        ItemCardapio item = adcionarExtras(menu, lanche);

                        pedido.adicionarItem(item);

                        continuar = menu.lerContinuarPedido();

                    } while (continuar == 1);

                    menu.exibirPedido(pedido);
                }

                // Modificar pedido
                case 2 -> {
                    int numeroPedido = menu.lerNumeroPedido();
                    Pedido pedido = sistema.buscarPedido(numeroPedido);

                    if (pedido == null) {
                        menu.msgPedidoNaoEncontrado();

                    } else {
                        menu.exibirPedido(pedido);
                        int opcaoModificar;

                        do {
                            opcaoModificar = menu.lerOpcaoModificarPedido();


                            switch (opcaoModificar) {

                                // Acrescentar item
                                case 1 -> {
                                    int opcaoLanche = menu.lerOpcaoLanche();
                                    Lanche lanche = sistema.criarLanche(opcaoLanche);

                                    personalizarLanche(menu, lanche);
                                    ItemCardapio item = adcionarExtras(menu, lanche);

                                    pedido.adicionarItem(item);
                                    menu.exibirPedido(pedido);

                                }

                                // Remover item
                                case 2 -> {
                                    menu.exibirItensNumerados(pedido);

                                    int numeroItem = menu.lerNumeroItem();

                                    try {
                                        pedido.removerItem(numeroItem);
                                        menu.exibirPedido(pedido);
                                    } catch (IllegalArgumentException e) {
                                        menu.exibirErro(e.getMessage());
                                    }
                                }

                                // Cancelar pedido
                                case 3 -> {
                                    sistema.cancelarPedido(numeroPedido);
                                    menu.msgPedidoCancelado();
                                    opcaoModificar = 0;
                                }

                                case 0 -> {
                                    // Voltar ao menu principal
                                }

                                default -> menu.msgOpcaoInvalida();
                            }
                        } while (opcaoModificar != 0);

                    }
                }

                // Listar pedidos do dia
                case 3 -> {
                    if (sistema.getPedidos().isEmpty()) {
                        menu.msgNenhumPedidoCadastrado();
                    } else {
                        for (Pedido pedido : sistema.getPedidos()) {
                            menu.exibirPedido(pedido);
                        }
                    }

                }

                // Fechar restaurante
                case 4 -> {
                    double total = sistema.calcularTotalDoDia();
                    HashSet<String> combinacoes = sistema.listarCombinacoes();

                    menu.exibirFechamentoDoDia(total);

                    menu.exibirCombinacoes(combinacoes);

                    opcao = 0;
                }
                case 0 -> {
                    // Sair do sistema
                }

                default -> menu.msgOpcaoInvalida();
            }
        }

        menu.fecharScanner();
    }

    static void personalizarLanche(MenuConsole menu, Lanche lanche) {
        int opcaoPersonalizacao = menu.lerOpcaoPersonalizacao();
        if (opcaoPersonalizacao == 1) {
            int opcaoIngrediente;

            do {
                opcaoIngrediente = menu.lerOpcaoIngrediente();

                switch (opcaoIngrediente) {
                    case 1 -> lanche.setQueijo(false);
                    case 2 -> lanche.setAlface(false);
                    case 3 -> lanche.setTomate(false);
                    case 4 -> lanche.setCebola(false);
                    case 0 -> {
                        // Finaliza personalização
                    }
                }

            } while (opcaoIngrediente != 0);
        }
    }

    static ItemCardapio adcionarExtras(MenuConsole menu, ItemCardapio item) {
        int opcao = menu.lerOpcaoAdicao();

        if (opcao == 1) {
            int opcaoAdcional;

            do {
                opcaoAdcional = menu.lerOpcaoAdicional();

                switch (opcaoAdcional) {
                    case 1 -> {
                        item = new ComCheddar(item);
                    }

                    case 2 -> {
                        item = new ComBaconExtra(item);
                    }

                    case 0 -> {
                        // Finaliza personalização
                    }
                }

            } while (opcaoAdcional != 0);
        }

        return item;
    }
}

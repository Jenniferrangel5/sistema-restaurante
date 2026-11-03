package com.restaurante.app;

import com.restaurante.cardapio.ItemCardapio;
import com.restaurante.pedido.Pedido;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuConsole {
    private final Scanner sc = new Scanner(System.in);

    public int lerOpcao() {
        while (true) {
            System.out.print("Escolha uma opção: ");

            try {
                int opcao = sc.nextInt();
                sc.nextLine();
                return opcao;
            } catch (InputMismatchException e) {
                System.out.println("Digite um número!");
                sc.nextLine();
            }
        }
    }

    public int lerNumeroPedido() {
        while (true) {
            System.out.print("Digite o número do pedido: ");
            try {
                int numeroPedido = sc.nextInt();
                sc.nextLine();
                return numeroPedido;
            } catch (InputMismatchException e) {
                System.out.println("Digite um número!");
                sc.nextLine();
            }
        }
    }

    public int lerNumeroItem() {
        while (true) {
            System.out.print("Digite o número do item que deseja remover: ");
            try {
                int itemRemocao = sc.nextInt();
                sc.nextLine();
                return itemRemocao;
            } catch (InputMismatchException e) {
                System.out.println("Digite um número!");
                sc.nextLine();
            }

        }
    }

    public String lerNomeCliente() {
        System.out.print("Digite seu nome: ");
        String nomeCliente = sc.nextLine();
        return nomeCliente;
    }

    // Menu principal
    public void exibirMenu() {
        System.out.println("""
           === RESTAURANTE ===
        1 - Registrar novo pedido
        2 - Modificar pedido
        3 - Listar pedidos do dia
        4 - Fechar restaurante
        0 - Sair
        """);
    }

    // Adicionar outro lanche
    public void perguntaAddNovoLanche() {
        System.out.println("""
        
        1 - Adicionar outro lanche
        0 - Finalizar pedido
        """);
    }

    public void perguntarRetirada() {
        System.out.println("""
                
                Deseja retirar algum ingrediente?
                1 - Sim
                2 - Não
                """);
    }

    public void exibirMenuRetirarItem() {
        System.out.println("""
                
                Qual item deseja retirar?
                1 - Queijo
                2 - Alface
                3 - Tomate
                4 - Cebola
                0 - Finalizar
                """);
    }

    public void perguntarAdicao() {
        System.out.println("""
                
                Deseja adicionar algum ingrediente?
                1 - Sim
                2 - Não
                """);
    }

    public void exibirMenuAddItem() {
        System.out.println("""
                
                Qual item deseja adicionar?
                1 - Cheddar ....... (R$ 4,00)
                2 - Bacon extra ... (R$ 6,00)
                0 - Finalizar
                """);
    }

    public void exibirCardapio() {
        System.out.println("""
            
                === CARDÁPIO ===
            1 - X-Burger ... R$16,00
            2 - X-Salada ... R$18,00
            3 - X-Bacon .... R$22,00
            """);
    }

    public void exibirMenuModificarPedido() {
        System.out.println("""
            Qual modificação deseja realizar?
            1 - Acrescentar item
            2 - Remover item
            3 - Cancelar pedido
            0 - Voltar ao menu principal
            """);
    }

    public int lerOpcaoLanche() {
        int opcaoLanche;

        do {
            exibirCardapio();
            opcaoLanche = lerOpcao();

            if (opcaoLanche < 1 || opcaoLanche > 3) {
                msgOpcaoInvalida();
            }

        } while (opcaoLanche < 1 || opcaoLanche > 3);

        return opcaoLanche;
    }

    public int lerContinuarPedido() {
        int continuar;

        do {
            perguntaAddNovoLanche();
            continuar = lerOpcao();

            if (continuar != 0 && continuar != 1) {
                msgOpcaoInvalida();
            }

        } while (continuar != 0 && continuar != 1);

        return continuar;
    }

    public int lerOpcaoPersonalizacao() {
        int opcaoPersonalizacao;

        do {
            perguntarRetirada();
            opcaoPersonalizacao = lerOpcao();

            if (opcaoPersonalizacao != 1 && opcaoPersonalizacao != 2) {
                msgOpcaoInvalida();
            }

        } while (opcaoPersonalizacao != 1 && opcaoPersonalizacao != 2);

        return opcaoPersonalizacao;
    }

    public int lerOpcaoIngrediente() {
        int opcaoIngrediente;

        do {
            exibirMenuRetirarItem();
            opcaoIngrediente = lerOpcao();

            if (opcaoIngrediente < 0 || opcaoIngrediente > 4) {
                msgOpcaoInvalida();
            }

        } while (opcaoIngrediente < 0 || opcaoIngrediente > 4);

        return opcaoIngrediente;
    }

    public int lerOpcaoAdicao() {
        int opcao;

        do {
            perguntarAdicao();
            opcao = lerOpcao();

            if (opcao != 1 && opcao != 2) {
                msgOpcaoInvalida();
            }

        } while (opcao != 1 && opcao != 2);

        return opcao;
    }

    public int lerOpcaoAdicional() {
        int opcaoAdicional;

        do {
            exibirMenuAddItem();
            opcaoAdicional = lerOpcao();

            if (opcaoAdicional < 0 || opcaoAdicional > 2) {
                msgOpcaoInvalida();
            }

        } while (opcaoAdicional < 0 || opcaoAdicional > 2);

        return opcaoAdicional;
    }

    public int lerOpcaoModificarPedido() {
        int opcao;

        do {
            exibirMenuModificarPedido();
            opcao = lerOpcao();

            if (opcao < 0 || opcao > 3) {
                msgOpcaoInvalida();
            }

        } while (opcao < 0 || opcao > 3);

        return opcao;
    }

    public void exibirPedido (Pedido pedido) {
        System.out.println("\nPedido Nº: " + pedido.getNumero());
        System.out.println("Cliente: " + pedido.getNomeCliente());

        for (ItemCardapio lanche : pedido.getItens()) {
            System.out.printf("%s - R$%.2f\n", lanche.getDescricao(), lanche.getPreco());
        }
        System.out.printf("Total: R$%.2f\n\n", pedido.calcularTotal());

    }

    public void exibirItensNumerados (Pedido pedido) {
        for (int i = 0; i < pedido.getItens().size(); i++){
            ItemCardapio item = pedido.getItens().get(i);

            System.out.printf("%d - %s - R$%.2f%n",
                    i + 1, item.getDescricao(), item.getPreco());
        }
    }

    public void exibirCombinacoes(HashSet<String> combinacoes) {
        System.out.println("Combinações diferentes: " + combinacoes.size());

        for (String combinacao : combinacoes) {
            System.out.println(combinacao);
        }
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.printf("Total do dia: R$%.2f\n", total);

    }

    public void msgOpcaoInvalida(){
        System.out.println("Opção inválida!");
    }

    public void msgPedidoNaoEncontrado(){
        System.out.println("Pedido não encontrado!");
    }

    public void msgPedidoCancelado(){
        System.out.println("Pedido cancelado!");
    }

    public void msgNenhumPedidoCadastrado(){
        System.out.println("Nenhum pedido cadastrado!");
    }

    public void exibirErro(String mensagem) {
        System.out.println(mensagem);
    }

    public void fecharScanner() {
        sc.close();
    }

}

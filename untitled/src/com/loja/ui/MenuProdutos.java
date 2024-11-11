package com.loja.ui;

import com.loja.gerenciador.GerenciadorProdutos;
import com.loja.modelo.Produto;

import java.util.Scanner;

public class MenuProdutos {
    private Scanner scanner = new Scanner(System.in);
    private GerenciadorProdutos gerenciador = new GerenciadorProdutos();

    public void exibirMenu() {
        int opcao = 0;

        while (opcao != 5) { // O loop agora continua até a opção 5 ser escolhida
            System.out.println("\n Sistema de Gerenciamento de Produtos ");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Deletar Produtos");
            System.out.println("4. Atualizar Produtos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt(); // Lê a opção escolhida
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    deletarProduto(); // Deletar produto
                    break;
                case 4:
                    atualizarProduto(); // Atualizar produto
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }



    private void cadastrarProduto() {
        System.out.println("\n Cadastro de Produto ");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Quantidade em Estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        Produto produto = new Produto(nome, preco, quantidade, categoria);

        gerenciador.criar(produto);

        System.out.println("Produto cadastrado com sucesso!");
    }


    private void listarProdutos() {
        System.out.println("\n Lista de Produtos ");
        for (Produto produto : gerenciador.listarTodos()) {
            System.out.println(produto);
        }
    }
    private void  deletarProduto(){
        System.out.println("\n Deletar Produto ");
        gerenciador.deletarProduto(Integer.parseInt(scanner.nextLine()));

    }
    private void atualizarProduto() {
        System.out.println("\n Atualizar Produto ");

        // Solicitar informações para o produto
        System.out.print("Informe o ID do produto que deseja atualizar: ");
        int idProduto = scanner.nextInt();
        scanner.nextLine();

    }
}

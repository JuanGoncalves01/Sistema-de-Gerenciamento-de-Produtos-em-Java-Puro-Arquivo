package com.loja.ui;

import com.loja.gerenciador.GerenciadorProdutos;
import com.loja.modelo.Produto;

import java.util.Scanner;

public class MenuProdutos {
    private Scanner scanner = new Scanner(System.in);
    private GerenciadorProdutos gerenciador = new GerenciadorProdutos();

    public void exibirMenu() {
        int opcao = 0;

        while (opcao != 3) {
            System.out.println("\n Sistema de Gerenciamento de Produtos ");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt(); // Lê a opção escolhida
            scanner.nextLine(); // Limpa

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    System.out.println("Saindo...");
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
}

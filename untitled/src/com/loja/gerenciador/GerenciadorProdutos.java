package com.loja.gerenciador;

import com.loja.modelo.Produto;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos  {
    private List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public void criar(Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
    }

    public Produto buscarPorId(int id) {
       for(Produto produto:produtos){
           if (produto.getId()==id){
               return produto;
           }
       }
       return null;
    }

    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    public boolean atualizarProduto() {
        Produto produto= null;

        Produto existente = buscarPorId( produto.getId());

        if (existente != null) {

            existente.setNome( produto.getNome());
            existente.setPreco( produto.getPreco());
            existente.setQuantidadeEstoque( produto.getQuantidadeEstoque());
            existente.setCategoria( produto.getCategoria());

            return true;
        }
        return false;
    }

    public boolean  deletarProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                return true;
            }
        }
        return false;
    }


}

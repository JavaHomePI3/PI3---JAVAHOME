package br.senac.sp.entidade.model;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Map<Produto, Integer> carrinho = new HashMap<>();
    private double precoTotal = 0;

    private void calculaPrecoTotal() {
        for (Map.Entry<Produto, Integer> produto : carrinho.entrySet()) {
            precoTotal += produto.getKey().getValorprod() * produto.getValue();
        }
    }

    public void adicionaProdutoAoCarrinho(Produto resultado, int quantidade) {
        if (!verificaSeTemProduto(resultado, quantidade)) {
            carrinho.put(resultado, quantidade);
        }
        calculaPrecoTotal();
    }

    private boolean verificaSeTemProduto(Produto resultado, int quantidade) {
        for (Map.Entry<Produto, Integer> produto : carrinho.entrySet()) {
            if (produto.getKey().equals(resultado)) {
                produto.setValue(produto.getValue() + quantidade);
                return true;
            }
        }
        return false;
    }

    public Map<Produto, Integer> getCarrinho() {
        return carrinho;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }
}

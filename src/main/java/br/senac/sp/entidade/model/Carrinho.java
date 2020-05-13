package br.senac.sp.entidade.model.carrinho;

import br.senac.sp.entidade.exception.VendasException;
import br.senac.sp.entidade.model.Produto;

import java.util.HashMap;
import java.util.Map;

public class Carrinho {
    private Map<Produto, Integer> carrinho = new HashMap<>();
    private double precoTotal = 0;

    private void calculaPrecoTotal() {
        precoTotal = 0;
        for (Map.Entry<Produto, Integer> produto : carrinho.entrySet()) {
            precoTotal += produto.getKey().getValorprod() * produto.getValue();
        }
    }

    public void adicionaProdutoAoCarrinho(Produto resultado, int quantidade) throws VendasException {
        if (!verificaSeTemProduto(resultado, quantidade)) {
            carrinho.put(resultado, quantidade);
        }
        calculaPrecoTotal();
    }

    private boolean verificaSeTemProduto(Produto resultado, int quantidade) throws VendasException {
        for (Map.Entry<Produto, Integer> produto : carrinho.entrySet()) {
            if (produto.getKey().equals(resultado)) {
                if (quantidade <= (produto.getKey().getQtdestoque() - produto.getValue()) - 1) {
                    produto.setValue(produto.getValue() + quantidade);
                    return true;
                } else {
                    throw new VendasException("Quantidade informada é maior do que a do estoque.");
                }
            }
        }
        return false;
    }

    public boolean verificaSeTemProduto(Produto resultado) {
        for (Map.Entry<Produto, Integer> produto : carrinho.entrySet()) {
            if (produto.getKey().equals(resultado)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeProduto(Produto p) {
        for (Map.Entry<Produto, Integer> produto : carrinho.entrySet()) {
            if (produto.getKey().equals(p)) {
                carrinho.remove(produto.getKey(), produto.getValue());
                precoTotal-= (produto.getKey().getValorprod() * produto.getValue());
                calculaPrecoTotal();
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

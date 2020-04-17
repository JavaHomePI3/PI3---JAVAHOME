package br.senac.sp.test;

import br.senac.sp.entidade.dao.VendaDao;
import br.senac.sp.entidade.exception.VendasException;
import br.senac.sp.entidade.model.Produto;
import br.senac.sp.entidade.model.Venda;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Teste {
    public static void main(String[]args){
        VendaDao dao = new VendaDao();
        Date date = new Date();
        List<Produto> itens = Arrays.asList(new Produto("teste",1200));
        Venda novaVenda = new Venda(5,1,itens);
        try {
            dao.inserir(novaVenda);
        } catch (VendasException e) {
            e.printStackTrace();
        }
    }
}

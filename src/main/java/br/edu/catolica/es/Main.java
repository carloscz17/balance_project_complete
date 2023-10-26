package br.edu.catolica.es;

import br.edu.catolica.es.filizola.Filizola;
import br.edu.catolica.es.toledo.Toledo;
import br.edu.catolica.es.urano.Urano;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Produto> listaProdutos = new ArrayList<>();

        var produto1 = new Produto(184, "P", "QUEIJO GRUYERE KG", 21.90);
        var produto2 = new Produto(288, "P", "QUEIJO PROVOLETE KG", 12.29);
        listaProdutos.add(produto1);
        listaProdutos.add(produto2);

        var urano = new Urano();
        urano.exportar(listaProdutos, "C:\\Users\\carlo\\Desktop\\balancas_java-main");

        var toledo = new Toledo();
        toledo.exportar(listaProdutos, "C:\\Users\\carlo\\Desktop\\balancas_java-main");

        var filizola = new Filizola();
        filizola.exportar(listaProdutos, "C:\\Users\\carlo\\Desktop\\balancas_java-main");

    }
}
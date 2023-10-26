package br.edu.catolica.es.filizola;

import br.edu.catolica.es.inter.IBalanca;
import br.edu.catolica.es.Produto;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Filizola implements IBalanca<Produto> {
    @Override
    public void exportar(@NotNull List<Produto> produtos, String diretorioSalvar) {
        try (FileWriter writer = new FileWriter(diretorioSalvar + "/PRODUTOS.txt")) {
            for (Produto produto : produtos) {
                //sequencias
                String codigo = String.format("%06d", Integer.parseInt(String.valueOf(produto.getCodigo())));
                String tipoProduto = produto.getTipo();
                String descricao = String.format("%-22s", produto.getDescricao());
                int valor = (int) (Float.parseFloat(String.valueOf(produto.getValor())) * 1000);
                String valorFormatado = String.format("%07d", valor);
                String validade = (produto.getValidade() != null ? produto.getValidade() : "000");

                writer.write(codigo + "*" + tipoProduto + descricao + valorFormatado + validade + "D" + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

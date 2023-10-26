package br.edu.catolica.es.toledo;

import br.edu.catolica.es.inter.IBalanca;
import br.edu.catolica.es.Produto;
import org.jetbrains.annotations.NotNull;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Toledo implements IBalanca<Produto> {
    @Override
    public void exportar(@NotNull List<Produto> produtos, String caminhoParaSalvarArquivo) {
        try (FileWriter writer = new FileWriter(caminhoParaSalvarArquivo + "/ITENSMGV.txt")) {
            for (Produto produto : produtos) {
                String codigo = String.format("%06d", Integer.parseInt(String.valueOf(produto.getCodigo())));
                String tipoProduto = produto.getTipo();
                String descricao = String.format("%-50s", produto.getDescricao());
                int valor = (int) (Float.parseFloat(String.valueOf(produto.getValor())) * 1000);
                String valorFormatado = String.format("%06d", valor);
                String validade = (produto.getValidade() != null ? produto.getValidade() : "000") + "0";

                String departamentosAssociados = "|01|";
                String codigoExtraInfo = "000000";
                String codigoImagem = "0000";
                String codigoNutricao = "000000";
                String dataExpiracao = "0";
                String dataImpressaoEmbalagem = "0";
                String codigoFornecedor = "0000";
                String lot = "000000000000";
                String ean_13 = "00000000000";
                String precoVersao = "0";
                String codigoDoSom = "0000";
                String codigoTaraDeterminado = "0000";
                String codigoFracionador = "0000";
                String campoExtra1 = "0000";
                String campoExtra2 = "0000";
                String codigoConsevacao = "0000";
                String fornecedorEan_13 = "000000000000";
                String glaciamentoPercentual = "000000";
                String sequenciaAssociacaoDepartamento = "|01|";
                String descricaoLinhaItem3 = " ".repeat(35);
                String descricaoLinhaItem4 = " ".repeat(35);
                String campoExtra3 = "000000";
                String campoExtra4 = "000000";
                String codigoMedia = "000000";

                //System.out.println(codigo + tipoProduto + valorFormatado + validade +
                //        descricao + departamentosAssociados + codigoExtraInfo + codigoImagem + codigoNutricao
                //        + dataExpiracao + dataImpressaoEmbalagem + codigoFornecedor + lot + ean_13 + precoVersao
                //        + codigoDoSom + codigoTaraDeterminado + codigoFracionador + campoExtra1 + campoExtra2 + codigoConsevacao
                //        + fornecedorEan_13 + glaciamentoPercentual + sequenciaAssociacaoDepartamento + descricaoLinhaItem3
                //        + descricaoLinhaItem4 + campoExtra3 + campoExtra4 + codigoMedia + "0000000|0000|0||");
                writer.write(codigo + "*" + tipoProduto + valorFormatado + validade +
                        descricao + departamentosAssociados + codigoExtraInfo + codigoImagem + codigoNutricao
                        + dataExpiracao + dataImpressaoEmbalagem + codigoFornecedor + lot + ean_13 + precoVersao
                        + codigoDoSom + codigoTaraDeterminado + codigoFracionador + campoExtra1 + campoExtra2 + codigoConsevacao
                        + fornecedorEan_13 + glaciamentoPercentual + sequenciaAssociacaoDepartamento + descricaoLinhaItem3
                        + descricaoLinhaItem4 + campoExtra3 + campoExtra4 + codigoMedia + "0000000|0000|0||"+ "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

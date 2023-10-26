package br.edu.catolica.es.inter;

import java.util.ArrayList;
import java.util.List;

public interface IBalanca<T> {
     void exportar(List<T> produtos, String diretorioSalvar);
}

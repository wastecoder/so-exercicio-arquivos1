package controller;

import java.io.IOException;

public interface ArquivoInterface {
    void lerArquivo(String caminho, String nome) throws IOException;
}

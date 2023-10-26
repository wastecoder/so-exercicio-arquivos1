package view;

import controller.ArquivoInterface;
import controller.ManipularArquivo;

import java.io.IOException;

public class Executar {
    public static void main(String[] args) {
        ArquivoInterface manipularArquivo = new ManipularArquivo();

        String caminho = "C:\\TEMP";
        String nome = "generic_food.csv";

        try {
            manipularArquivo.lerArquivo(caminho, nome);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

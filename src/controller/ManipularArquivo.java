package controller;

import java.io.*;

public class ManipularArquivo implements ArquivoInterface {

    @Override
    public void lerArquivo(String caminho, String nome) throws IOException {
        File arquivo = new File(caminho, nome);
        if (arquivoInexistente(arquivo)) {
            throw new IOException("Arquivo inexistente ou nao encontrado!");
        }

        FileInputStream fluxo = new FileInputStream(arquivo);
        InputStreamReader leitor = new InputStreamReader(fluxo);
        BufferedReader buffer = new BufferedReader(leitor);

        String linha = buffer.readLine();
        exibirLinha(linha);
        System.out.println();

        while (linha != null) {
            if (temFiltro(linha, "Fruits")) {
                exibirLinha(linha);
            }
            linha = buffer.readLine();
        }

        buffer.close();
        leitor.close();
        fluxo.close();
    }

    private boolean arquivoInexistente(File arquivo) {
        return !(arquivo.exists() && arquivo.isFile());
    }

    private void exibirLinha(String linha) {
        String[] colunasDaLinha = linha.split(",");
        formatarLinha(colunasDaLinha);
    }

    private void formatarLinha(String[] colunas) {
        System.out.printf("%-25s %-35s %-15s %n", colunas[0], colunas[1], colunas[3]);
    }

    private boolean temFiltro(String linha, String filtro) {
        String[] colunasDaLinha = linha.split(",");
        return colunasDaLinha[2].equals(filtro);
    }
}

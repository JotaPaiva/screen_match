package br.com.alura.screenmatch.modelo;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int anoDeLancamento;
    private String metascore;
    private String duracao;
    private String genero;
    private String paisDeOrigem;
    private String classificacao;

    public Titulo(TituloOMDB meuTituloOMDB) {

        this.nome = meuTituloOMDB.title();

        if (meuTituloOMDB.year().length() > 4){
            throw new ErroDeConversaoDeAnoException("Não foi possível converter o ano. O valor possui mais de 4 caracteres.");
        }

        this.anoDeLancamento = Integer.valueOf(meuTituloOMDB.year());
        this.metascore = meuTituloOMDB.metascore();
        this.duracao = meuTituloOMDB.runtime();
        this.genero = meuTituloOMDB.genre();
        this.paisDeOrigem = meuTituloOMDB.country();
        this.classificacao = meuTituloOMDB.rated();

    }

    public Titulo(String nome, int anoDeLancamento) {
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public String exibeFichaTecnica() {
        return "Título: " + this.nome + "\n" +
               "Ano de Lançamento: " + this.anoDeLancamento + "\n" +
               "Gênero: " + this.genero + "\n" +
               "Duração: " + this.duracao + "\n" +
               "País: " + this.paisDeOrigem + "\n" +
               "Classificação Indicativa: " + this.classificacao + "\n" +
               "Avaliação no Metascore: " + this.metascore;

    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return nome + " (" + anoDeLancamento + ")";
    }
}

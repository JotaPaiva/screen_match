package br.com.alura.screenmatch.modelo;

public class Serie extends Titulo {

    private int temporadas;
    private boolean ativa;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;
    private String produtora;

    public Serie (String nome, String produtora, int anoDeLancamento){
        super(nome, anoDeLancamento);
        this.setProdutora(produtora);
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    @Override
    public int getDuracaoEmMinutos() {
        return temporadas * (episodiosPorTemporada * minutosPorEpisodio);
    }

    @Override
    public void exibeFichaTecnica(){
        System.out.println("Nome da Série: " + super.getNome());
        super.exibeFichaTecnica();
    }

    @Override
    public String toString() {
        return "Série: " + super.getNome() + " (" + super.getAnoDeLancamento() + ") de " + this.getProdutora();
    }
}

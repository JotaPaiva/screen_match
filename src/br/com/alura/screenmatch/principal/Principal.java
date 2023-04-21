package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelo.Episodio;
import br.com.alura.screenmatch.modelo.Filme;
import br.com.alura.screenmatch.modelo.Serie;

import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {

        Filme filmeUm = new Filme("Poderoso Chefão", "Francis Ford Copolla", 1972);
        filmeUm.setDuracaoEmMinutos(180);

        filmeUm.exibeFichaTecnica();

        filmeUm.avalia(10);
        filmeUm.avalia(9);
        filmeUm.avalia(10);

        System.out.println("Média do Filme: " + filmeUm.pegaMedia());
        System.out.println("Total de Avaliações: " + filmeUm.getTotalDeAvaliacoes());

        Serie serieUm = new Serie("Game of Thrones", "HBO",2011);
        serieUm.exibeFichaTecnica();
        serieUm.setTemporadas(8);
        serieUm.setEpisodiosPorTemporada(10);
        serieUm.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar " + serieUm.getNome() + ": " + serieUm.getDuracaoEmMinutos() + " minutos.");

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filmeUm);
        calculadora.inclui(serieUm);
        System.out.println("Tempo total de exibição da sua lista: " + calculadora.getTempoTotal() + " minutos.");

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(filmeUm);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serieUm);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

    }

}

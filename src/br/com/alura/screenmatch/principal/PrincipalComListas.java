package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelo.Filme;
import br.com.alura.screenmatch.modelo.Serie;
import br.com.alura.screenmatch.modelo.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {

    public static void main(String[] args) {

        Filme filmeUm = new Filme("Godfather", "Francis Ford Copolla", 1972);
        filmeUm.setDuracaoEmMinutos(180);

        Filme filmeDois = new Filme("Avatar 2","James Cameron",2023);
        filmeDois.setDuracaoEmMinutos(200);

        Filme filmeTres = new Filme("Homem Aranha","Sam Raimi", 2002);
        filmeTres.setDuracaoEmMinutos(120);

        Serie serieUm = new Serie("Game of Thrones", "HBO",2011);

        Serie serieDois = new Serie("Breaking Bad", "AMC", 2008);

        Serie serieTres = new Serie("American Horror Story", "FX", 2011);

        List<Titulo> lista = new ArrayList<>();

        lista.add(filmeUm);
        lista.add(filmeDois);
        lista.add(filmeTres);
        lista.add(serieUm);
        lista.add(serieDois);
        lista.add(serieTres);

        System.out.println("\n========================================");
        System.out.println("ORDENANDO A LISTA POR ORDEM DE INSERÇÃO:");
        System.out.println("========================================");

        for (Titulo item:lista) {
            System.out.println("\n" + item.getNome() + " (" + item.getAnoDeLancamento() + ")");
            if (item instanceof Filme filme) {
                System.out.println("Diretor: " + filme.getDiretor());
            } else if (item instanceof Serie serie) {
                System.out.println("Produtora: " + serie.getProdutora());
            }
        }

        lista.sort(Comparator.comparing(Titulo::getNome));
        System.out.println("\n=======================================");
        System.out.println("ORDENANDO A LISTA POR ORDEM ALFABÉTICA:");
        System.out.println("=======================================");

        for (Titulo item:lista) {
            System.out.println("\n" + item.getNome() + " (" + item.getAnoDeLancamento() + ")");
            if (item instanceof Filme filme) {
                System.out.println("Diretor: " + filme.getDiretor());
            } else if (item instanceof Serie serie) {
                System.out.println("Produtora: " + serie.getProdutora());
            }
        }

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("\n==========================================");
        System.out.println("ORDENANDO A LISTA POR ORDEM DE LANÇAMENTO:");
        System.out.println("==========================================");

        for (Titulo item:lista) {
            System.out.println("\n" + item.getNome() + " (" + item.getAnoDeLancamento() + ")");
            if (item instanceof Filme filme) {
                System.out.println("Diretor: " + filme.getDiretor());
            } else if (item instanceof Serie serie) {
                System.out.println("Produtora: " + serie.getProdutora());
            }
        }

    }

}

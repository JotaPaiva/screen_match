package br.com.alura.screenmatch.modelo;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {

    private String diretor;

    public Filme(String nome, String diretor, int anoDeLancamento){
        super(nome, anoDeLancamento);
        this.setDiretor(diretor);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public void exibeFichaTecnica(){
        System.out.println("Nome do Filme: " + super.getNome());
        super.exibeFichaTecnica();
    }

    @Override
    public String toString() {
        return "Filme: " + super.getNome() + " (" + super.getAnoDeLancamento() + ") de " + this.getDiretor();
    }

}

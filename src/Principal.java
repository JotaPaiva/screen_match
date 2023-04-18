import br.com.alura.screenmatch.modelo.Filme;

public class Principal {

    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1972);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(10);
        meuFilme.avalia(9);
        meuFilme.avalia(10);

        System.out.println("Média do br.com.alura.screenmatch.modelo.Filme: " + meuFilme.pegaMedia());
        System.out.println("Total de Avaliações: " + meuFilme.getTotalDeAvaliacoes());

    }

}

package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelo.Titulo;
import br.com.alura.screenmatch.modelo.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);

        String busca = "";

        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

        while (!busca.equalsIgnoreCase("Sair")) {

            System.out.print("Qual filme você gostaria de buscar: ");
            busca = scanner.nextLine();

            if (busca.equalsIgnoreCase("Sair")){
                break;
            }

            String endereco = "https://omdbapi.com/?t=" + busca.replace(" ","+") + "&apikey=d0bf249";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();

                TituloOMDB meuTituloOMDB = gson.fromJson(response.body(),TituloOMDB.class);

                Titulo meuTitulo = new Titulo(meuTituloOMDB);

                System.out.println("\n" + meuTitulo.exibeFichaTecnica() + "\n");

                titulos.add(meuTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro.");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Houve um erro de argumento na busca, verifique.");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }

        }

        System.out.println(titulos);

        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println("O programa finalizou corretamente!");

    }

}

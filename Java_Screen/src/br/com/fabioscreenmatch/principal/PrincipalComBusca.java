package br.com.fabioscreenmatch.principal;

import br.com.fabioscreenmatch.excesao.ErroDeConversaoDeAnoExeption;
import br.com.fabioscreenmatch.modelos.Titulo;
import br.com.fabioscreenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um filme para a busca: ");
        var busca = leitura.nextLine();

        String endereco = "https://omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=eaadcb36";
        System.out.println(endereco);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);
            //try {
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("Titulo já convertido");
            System.out.println(meuTitulo);
        }catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro!");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro na busca, verifique o endereço!");
        } catch (ErroDeConversaoDeAnoExeption e) {
            System.out.println(e.getMessage());
        }

        System.out.println("O programa finalizou corretamente!!");

    }

}

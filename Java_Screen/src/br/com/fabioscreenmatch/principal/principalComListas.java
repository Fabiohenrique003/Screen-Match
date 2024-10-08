package br.com.fabioscreenmatch.principal;

import br.com.fabioscreenmatch.modelos.Filme;
import br.com.fabioscreenmatch.modelos.Serie;
import br.com.fabioscreenmatch.modelos.Titulo;

import java.util.*;

public class principalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(8);
        var avengers = new Filme("Avengers", 2015);
        avengers.avalia(9);
        Serie lost = new Serie("Lost", 2000);

        Filme f1 = meuFilme;

        List<Titulo> listaDeAssistidos = new LinkedList<>();
        listaDeAssistidos.add(avengers);
        listaDeAssistidos.add(meuFilme);
        listaDeAssistidos.add(outroFilme);
        listaDeAssistidos.add(lost);

        for (Titulo item: listaDeAssistidos) {
            System.out.println(item.getNome());
            if (item instanceof  Filme filme && filme.getClassificacao() > 2) {
                //Filme filme = (Filme) item;
                System.out.println("Classificação " + filme.getClassificacao());
            }

        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Magaiver");
        buscaPorArtista.add("Jhony");
        buscaPorArtista.add("Henrique");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Despois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("lista");
        Collections.sort(listaDeAssistidos);
        System.out.println(listaDeAssistidos);

        listaDeAssistidos.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano");
        System.out.println(listaDeAssistidos);

    }
}

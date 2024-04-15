package Streams;

import Streams.Creator.CriarPessoa;
import Streams.Creator.ICriarPessoa;
import Streams.Objects.Pessoa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        ICriarPessoa criarP = new CriarPessoa();
        List<Pessoa> pessoaList = new ArrayList<>();
        pessoaList.add(criarP.criarPessoa("Kauan", "Herbst", "Brasileiro", 19));
        pessoaList.add(criarP.criarPessoa("Kauan", "Sousa", "Brasileiro", 19));
        pessoaList.add(criarP.criarPessoa("Vivian", "Sousa", "Americano", 39));
        pessoaList.add(criarP.criarPessoa("Rogerio", "Pinto", "Brasileiro", 16));
        pessoaList.add(criarP.criarPessoa("Junior", "Freitas", "Indiano", 47));


        pessoaList.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasileiro"))
                .map(Pessoa::getNome)
                .forEach(nome -> System.out.println(nome));

        System.out.println("=-=-=-=-=-=-=-=-=-=-");

        pessoaList.stream().forEach(pessoa -> System.out.println(pessoa.getNome()));

        System.out.println("=-=-=-=-=-=-=-=-=-=-");

        pessoaList.stream()
                .limit(3)
                .forEach(pessoa -> System.out.println(pessoa.getSobrenome()));

        System.out.println("=-=-=-=-=-=-=-=-=-=-");

        pessoaList.stream()
                .sorted(Comparator.comparing(Pessoa::getIdade))
                .forEach(pessoa -> System.out.println(pessoa.getNome()));

        System.out.println("=-=-=-=-=-=-=-=-=-=-");

        long qntd = pessoaList.stream().filter(pessoa -> pessoa.getNome().startsWith("K"))
                .count();
        System.out.println(qntd);

        System.out.println("=-=-=-=-=-=-=-=-=-=-");

        Boolean allBrasileiro = pessoaList.stream().allMatch(pessoa -> pessoa.getNacionalidade().equals("Brasileiro"));
        System.out.println(allBrasileiro);

        System.out.println("=-=-=-=-=-=-=-=-=-=-");

        List<Pessoa> listaB = pessoaList.stream()
                .filter(pessoa -> pessoa.getNacionalidade().equals("Brasileiro"))
                .collect(Collectors.toList());
        listaB.forEach(pessoa -> System.out.println(pessoa.getNome()));
    }
}

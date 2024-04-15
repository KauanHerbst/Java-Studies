package Predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ExemploPredicate {
    public static void main(String[] args) {
        
//:Representa uma função que aceita um argumento do tipo T e retorna um valor booleano (verdadeiro ou falso). É comumente usada para filtrar os elementos do Stream com base em alguma condição.

    List<String> palavras = Arrays.asList("Pão", "Cachorro", "Chocolate", "Maça");

    Predicate<String> maisDeCincoLetras = palavra -> palavra.length() > 5;

    palavras.stream().filter(maisDeCincoLetras).forEach(System.out::println);
    
    }
}

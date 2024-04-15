package Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ExemploFunction {
    public static void main(String[] args) {


//: Representa uma função que aceita um argumento do tipo T e retorna um resultado do tipo R. É utilizada para transformar ou mapear os elementos do Stream em outros valores ou tipos.


        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        Function<Integer, Integer> dobrar = numero -> numero * 2; 

        List<Integer> numerosDobrados = numeros.stream().map(dobrar).toList();

        numerosDobrados.forEach(System.out::println);

    }
}

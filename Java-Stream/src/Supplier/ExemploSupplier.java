package Supplier;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ExemploSupplier {
    public static void main(String[] args) {

//: Representa uma operação que não aceita nenhum argumento e retorna um resultado do tipo T. É comumente usada para criar ou fornecer novos objetos de um determinado tipo

        Supplier<String> hello = () -> "Hello World"; // Supllier

        List<String> listHello = Stream.generate(hello).limit(5).toList();

        listHello.stream().forEach(System.out::println); // Reference Method

    }
}

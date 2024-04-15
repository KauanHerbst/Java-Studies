package com.herbst.desafio;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConversorCamelCase {
    public static List<String> converterCamelCase(String original) {
        if (original == null || original.isEmpty()) {
            return new ArrayList<>();
        }
        isPalavraValida(original);
        return matcherPalavra(original);
    }

    private static void isPalavraValida(String palavra) {
        if(!palavra.matches("^[a-zA-Z0-9]*$")){
            throw new IllegalArgumentException("Caracteres especiais não são permitidos, somente letras e números");
        }
        if (Character.isDigit(palavra.charAt(0))) {
            throw new IllegalArgumentException("Não deve começar com números ");
        }
    }

    private static List<String> matcherPalavra(String palavra){
        List<String> palavras = new ArrayList<>();
        Matcher matcher = Pattern.compile("(^[a-z]+|[A-Z][a-z]+|[A-Z]+|\\d+)").matcher(palavra);

        while (matcher.find()) {
            palavras.add(matcher.group().toLowerCase());
        }

        return palavras;
    }
}

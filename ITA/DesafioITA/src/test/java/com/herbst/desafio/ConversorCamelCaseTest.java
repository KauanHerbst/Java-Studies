package com.herbst.desafio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ConversorCamelCaseTest {
    @Test
    public void conversorCamelCaseUmaPalavra() {
        List<String> resultado = ConversorCamelCase.converterCamelCase("nome");
        Assertions.assertEquals(List.of("nome"), resultado);
    }

    @Test
    public void conversorCamelCasePalavraCapitalze(){
        List<String> resultado = ConversorCamelCase.converterCamelCase("Nome");
        Assertions.assertEquals(List.of("nome"), resultado);
    }

    @Test
    public void conversorCamelCasePalavraComposta(){
        List<String> resultado = ConversorCamelCase.converterCamelCase("nomeComposto");
        Assertions.assertEquals(List.of("nome", "composto"), resultado);
    }

    @Test
    public void  conversorCamelCaseAcronimo(){
        List<String> resultado = ConversorCamelCase.converterCamelCase("CPF");
        Assertions.assertEquals(List.of("cpf"), resultado);
    }

    @Test()
    public void  conversorCamelCaseIniciaComNumeros(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<String> resultado = ConversorCamelCase.converterCamelCase("10NUMERO");
            });
    }


    @Test()
    public void  conversorCamelCaseIniciaComCaracterEspecial(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<String> resultado = ConversorCamelCase.converterCamelCase("Especial#Escecial");
        });
    }
}

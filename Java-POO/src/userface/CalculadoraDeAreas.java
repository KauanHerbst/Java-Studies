package userface;

import Formulas.FormulaLosango;
import Formulas.FormulaQuadrado;
import Formulas.FormulaRetangulo;
import java.util.Scanner;

public class CalculadoraDeAreas {
    public static void main(String[] args) {
        FormulaLosango losango = new FormulaLosango();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o lado um: ");
        float ladoUm = scanner.nextFloat();
        System.out.println("Digite o lado dois: ");
        float ladoDois = scanner.nextFloat();

        float resultado = losango.calcularArea(ladoUm, ladoDois);
        System.out.println(resultado);

    }
}

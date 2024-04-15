package math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Bhaskara {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o A da equação: ");
        Double a = scan.nextDouble();
        System.out.println("Digite o B da equação: ");
        Double b = scan.nextDouble();
        System.out.println("Digite o C da equação: ");
        Double c = scan.nextDouble();

        Double delta = calcDelta(a, b, c);
        List<Double> resultados = calcBhaskara(delta, b, a);
        System.out.println(resultados);

    }

    public static Double calcDelta(Double a, Double b, Double c){
        return (b * b) - (4 * a * c);
    }

    public  static List<Double> calcBhaskara(Double delta, Double b, Double a){
        List<Double> listaX = new ArrayList<>();
        Double x1 = (b + Math.sqrt(delta)) / (2 * a);
        Double x2 = (b - Math.sqrt(delta)) / (2 * a);
        listaX.add(x1);
        listaX.add(x2);
        return listaX;
    }
}

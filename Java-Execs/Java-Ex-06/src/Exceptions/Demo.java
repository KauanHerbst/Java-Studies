package Exceptions;

public class Demo {
    public static void main(String[] args) {
        try {
            Double resultado = dividir(10d, null);
            System.out.println(resultado);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    public static Double dividir(Double value1, Double value2){
        return value1 / value2;
    }
}

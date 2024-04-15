package math;

import java.util.Scanner;

public class Tabuada2 {

    public static void main(String[] args) {
        String validar = "Sim";
        Integer number;
        Scanner scan = new Scanner(System.in);
        while(validar.equalsIgnoreCase("SIM")){
            System.out.println("Digite um numero para ver a sua tabuada: ");
            number = scan.nextInt();

            tabuar(number);

            System.out.println("Deseja ver outra tabuada?");
            validar = scan.next();

        }
        System.out.println("Finalizando programa");

    }

    public static void tabuar(Integer number){
        for(int i=1; i<=10; i++){
            System.out.println(number + "X" + i + " = " + i * number);
        }
    }

}

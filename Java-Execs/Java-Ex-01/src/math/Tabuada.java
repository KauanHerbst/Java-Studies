package math;

import java.util.Scanner;


/**
 * @author KauanHerbst
 * @version 1.0
 *
 */

public class Tabuada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um numero para a tabuada: ");
        Integer number = scan.nextInt();
        fazerTabuada(number);
    }

    /**
     * Metodo para realizar a tabuada!
     * @param number Numero para realizar a tabuada!
     *
     * */
    public static void fazerTabuada(Integer number){
        for(int i=1; i <=10; i++){
            System.out.println(i + "X" + number + " = " + number * i);
        }
    }
}

package exercicios;

import java.util.Scanner;

public class Exer413 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um char: ");
        String cha = scan.next();
        System.out.println("Digite um numero para as repetições: ");
        Integer number = scan.nextInt();

        for (int i=0; i<= number; i++){
            printN(cha, i);
        }
    }

    public static void printN(String cha, Integer number){
        for(int i=0; i<=number; i++){
            System.out.println(cha);
        }
    }
}

package Collections.Array;

import java.util.Scanner;

public class ExemploArray {
    public static void main(String[] args) {

//        int[] arrayInt = new int[10];
//        arrayInt = arrayUni(arrayInt);
//
//        for(int i : arrayInt){
//            System.out.printf("%d ", i);
//        }

        int[][] arrayIntBi = new int[3][3];
        arrayIntBi = arrayBi(arrayIntBi);

        for(int i=0; i < arrayIntBi.length; i++){
            System.out.println("");
            for(int j=0; j< arrayIntBi.length; j++){
                System.out.printf("[%d] ", arrayIntBi[i][j]);
            }
        }


    }

    public static int[] arrayUni(int[] array){
        Scanner scan = new Scanner(System.in);
        int[] newArray = new int[array.length];
        for(int i=0; i < array.length; i++){
            System.out.println("Digite o numero da posição: " + i);
            newArray[i] = scan.nextInt();
        }
        return newArray;
    }

    public static int[][] arrayBi(int[][] array){
        Scanner scan = new Scanner(System.in);
        int[][] newArray = new int[array.length][array.length];
        for(int i=0; i < array.length; i++){
            for(int j=0; j < array.length; j++){
                System.out.printf("Digite o numero da posição [%d][%d]: %n", i, j);
                newArray[i][j] = scan.nextInt();
            }
        }
        return newArray;
    }

}

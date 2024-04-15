package solutions;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String B = "";
        String[] C = A.split("");
        for(int i=A.length()-1; i!=-1; i--){
            B = B.concat(C[i]);
        }
        System.out.println(B);

    }
}

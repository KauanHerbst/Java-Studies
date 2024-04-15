package Generics;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>();
        listString.add("Kauan");
        listString.add("Herbst");
        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(19);
        listInteger.add(2023);

        imprimirList(listString);
        imprimirList(listInteger);

    }


    public static <T> void imprimirList(List<T> list){
        for (T t: list){
            System.out.println(t);
        }
    }


}

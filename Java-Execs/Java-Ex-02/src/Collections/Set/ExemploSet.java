package Collections.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
    public static void main(String[] args) {
        Set<String> setNomes = new HashSet<String>();
        Set<String> setRemoves = new HashSet<String>();
        setNomes.add("Azul");
        setNomes.add("Vermelho");
        setNomes.add("Yellow");
        setNomes.add("Red");
        setRemoves.add("Yellow");
        setRemoves.add("Red");

        System.out.println(setNomes);

//        setNomes.removeAll(setRemoves);
//        System.out.println(setNomes);

//        setNomes.remove("Azul");
//        System.out.println(setNomes);


        Set<String> treeSetNome = new TreeSet<>();
        treeSetNome.addAll(setNomes);
        System.out.println(treeSetNome);



    }
}

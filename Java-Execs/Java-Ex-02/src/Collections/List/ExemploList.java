package Collections.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {
        List<String> nomes = listaNomes("Kauan", "Felipe", "Amanda");
        System.out.println(nomes);
        nomes = ordenarLista(nomes);
        System.out.println(nomes);
    }

    public static List<String> listaNomes(String nome1, String nome2, String nome3){
        List<String> listaNomes = new ArrayList<String>();
        listaNomes.add(nome1);
        listaNomes.add(nome2);
        listaNomes.add(nome3);
        return listaNomes;
    }

    public static List<String> ordenarLista(List<String> listaDeNomes){
        Collections.sort(listaDeNomes);
        return listaDeNomes;
    }

}

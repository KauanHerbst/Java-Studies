package Collections.Queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class ExemploQueue {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();
        fila.add("Azul");
        fila.add("Vermelho");
        fila.add("Orange");
        fila.add("Marrom");

        System.out.println(fila);
        String elemento = fila.remove();
        System.out.println(elemento);
        System.out.println(fila);
        String elemento2 = fila.remove();
        System.out.println(elemento2);
        System.out.println(fila);

    }
}

package Collections.Queue;

import Collections.Queue.Objects.Animais;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class ExemploDeque {
    public static void main(String[] args) {
        Deque<Animais> filaAnimais = new ArrayDeque<>();
        Deque<Animais> filaAnimais2 = new ArrayDeque<>();
        Animais cachorro = new Animais("Cachorro", 1);
        Animais gato = new Animais("Gato", 2);
        Animais rato = new Animais("Rato", 3);
        Animais sapo = new Animais("Sapo", 4);

        filaAnimais.addFirst(cachorro);
        filaAnimais.addLast(gato);
        filaAnimais.addFirst(sapo);
        filaAnimais.addLast(rato);

        System.out.println(filaAnimais);

        filaAnimais2.addFirst(cachorro);
        filaAnimais2.add(gato);
        filaAnimais2.add(rato);
        filaAnimais2.add(sapo);

        System.out.println(filaAnimais2);

    }

}

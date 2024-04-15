package br.herbst.filaFIFO;

public class Demo {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        System.out.println("Vazio: " + queue.isEmpty());
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("primeiro: " + queue.front());
        System.out.println("Ultimo: " + queue.rear());
        System.out.println("Vazio: " + queue.isEmpty());
        System.out.println("Tamanho: " + queue.size());
        queue.dequeue();
        System.out.println("primeiro: " + queue.front());
        queue.dequeue();
        System.out.println("primeiro: " + queue.front());

    }
}

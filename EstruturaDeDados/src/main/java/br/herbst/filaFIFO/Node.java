package br.herbst.filaFIFO;

public class Node<T> {
    private T data;
    Node next;
    Node previus;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.previus = null;
    }

    public T getData() {
        return data;
    }
}

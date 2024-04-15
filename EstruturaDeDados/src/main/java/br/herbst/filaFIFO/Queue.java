package br.herbst.filaFIFO;

public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    public Queue() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(T data){
        Node<T> node = new Node<>(data);
        if(this.head == null){
            node.next = null;
            node.previus = null;
            this.head = node;
            this.tail = node;
        }else {
            Node last = this.tail;
            node.next = null;
            node.previus = last;
            last.next = node;
            this.tail = node;
        }
    }

    public int size(){
        int count = 0;
        Node current = this.head;
        if(current == null){
            return 0;
        }
        while (current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void dequeue(){
        Node first = this.head;
        if(first == null){
            System.out.println("Fila Vazia");
        }else {
            Node next = first.next;
            next.previus = null;
            this.head = next;
        }

    }
    public T front(){
        Node first = this.head;
        return (T) first.getData();
    }

    public T rear(){
        Node last = this.tail;
        return (T) last.getData();
    }

    public boolean isEmpty(){
        return this.head == null;
    }
}

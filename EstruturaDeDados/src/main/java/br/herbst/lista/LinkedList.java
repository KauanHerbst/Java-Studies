package br.herbst.lista;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);
        if(this.head == null){
            this.head = node;
            node.next = null;
            node.previus = null;
            this.tail = node;
        }else {
            Node last = this.tail;
            node.previus = last;
            node.next = null;
            last.next = node;
            this.tail = node;
        }
    }

    public void pop(){
        if(this.head == null){
            System.out.println("Lista vazia");
        }else {
            Node last = this.tail;
            this.tail = last.previus;
            this.tail.next = null;
        }
    }

    public int size(){
        Node node = this.head;
        if(node == null){
            return 0;
        }
        int count =0;
        while (node != null){
            count++;
            node = node.next;
        }
        return count;
    }

    public void insert(int index, T data){
        Node node = new Node<>(data);
        if(index == 0){
            Node first = this.head;
            first.previus = node;
            node.next = first;
            node.previus = null;
            this.head = node;
        } else {
            int idx = 1;
            Node current = this.head;
            while (current != null){
                if(index == idx){
                    Node next = current.next;
                    node.next = next;
                    node.previus = current;
                    current.next = node;
                    if(next != null){
                        next.previus = node;
                    }
                    break;
                }
                idx++;
                current = current.next;

            }
            if(current == null){
                System.out.println("Index fora dos limites da lista");
            }
        }

    }

    public void remove(int index){
        if(index == 0){
            Node first = this.head;
            Node next = first.next;
            next.previus = null;
            this.head = next;
        }else {
            int idx = 0;
            Node current = this.head;
            while (idx != index){
                current = current.next;
                idx++;
            }
            if(current == null){
                System.out.println("Index fora dos limites da lista");
            }else {
                Node next = current.next;
                Node previus = current.previus;

                previus.next = next;
                next.previus = previus;
            }
        }
    }

    public T elementAt(int index){
        int idx = 0;
        Node current = this.head;
        while (idx != index){
            idx++;
            current = current.next;
        }
        if(current == null){
            return null;
        }
        return (T) current.getData();
    }


    public void printList(){
        Node current = this.head;
        while (current != null){
            System.out.println(current.getData());
            current = current.next;
        }
    }
}

package br.herbst.pilha;

public class Stack<T> {

    private Node top;

    public Stack() {
        this.top = null;
    }

    public void push(T data){
        Node<T> node = new Node<>(data);

        if(this.top == null){
            this.top = node;
        }else {
           node.next = this.top;
           this.top = node;
        }
    }

    public void pop(){
        if(this.top == null){
            System.out.println("Pilha Vazia");
        }else{
            if(this.top.next != null){
                Node node = this.top.next;
                this.top = node;
                node.next = this.top.next;
            }else {
                this.top = null;
            }

        }
    }

    public T top(){
        if(this.top != null){
            return (T) this.top.getData();
        }
        return null;
    }

    public boolean isEmpty(){
        return this.top == null;
    }

    public int size(){
        int size = 0;
        if(this.top == null){
            return size;
        }
        Node current = this.top;
        while (current != null){
            size++;
            current = current.next;
        }
        return size;
    }
}

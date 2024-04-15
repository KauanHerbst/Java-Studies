package br.herbst.pilha;

public class Demo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(25);
        stack.push(10);
        stack.push(255);
        System.out.println("size: " + stack.size());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        System.out.println("is empty: " + stack.isEmpty());
        stack.pop();
        System.out.println(stack.top());
        stack.pop();
        System.out.println("is empty: " + stack.isEmpty());


    }
}

package br.herbst.lista;

public class Demo {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.push(10);
        linkedList.push(15);
        linkedList.push(255);
        linkedList.push(300);
        linkedList.printList();
        System.out.println("=-=-=-=-=-=-=");
        linkedList.pop();
        linkedList.pop();
        linkedList.printList();
        System.out.println("=-=-=-=-=-=-=");
        linkedList.push(8);
        linkedList.insert(1, 30);
        linkedList.printList();
        System.out.println("=-=-=-=-=-=-=");
        linkedList.remove(2);
        linkedList.printList();
        System.out.println("=-=-=-=-=-=-=");
        System.out.println(linkedList.elementAt(2));

    }
}

package DesingPatterns.Behavioral.Observer;

import DesingPatterns.Behavioral.Observer.Objects.*;

public class Demo {
    public static void main(String[] args) {
        IObserver client1 = new Client();
        IObserver client2 = new Client();
        IObserver client3 = new Client();
        ISubject store1 = new Store();
        IProduct book1 = new Book();
        book1.setName("Harry Potter");
        store1.registerObserver(client1);
        store1.registerObserver(client2);
        store1.registerObserver(client3);
        store1.notifyObserver(book1);

    }
}

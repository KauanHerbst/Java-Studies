package DesingPatterns.Creational.Singleton;



public class SingletonDemo {
    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance(10);
        Singleton singleton2 = Singleton.getInstance(20);
        Singleton singleton3 = Singleton.getInstance(30);

        System.out.println(singleton1.getValue());
        System.out.println(singleton2.getValue());
        System.out.println(singleton3.getValue());
    }
}

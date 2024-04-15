package Generics;

public class DemoGenericClass {
    public static void main(String[] args) {
        GenericClass<Integer, String> classGeneric = new GenericClass<>(10, "Kauan");
        System.out.println(classGeneric.getCodigo());
        System.out.println(classGeneric.getDate());
    }
}

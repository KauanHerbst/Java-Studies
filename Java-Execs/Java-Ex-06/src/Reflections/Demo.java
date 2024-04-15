package Reflections;

import java.lang.reflect.*;

public class Demo {
    public static void main(String[] args) {
        Class clasz = Produto.class;
        System.out.println("Classe: " + clasz);

        try {
            Constructor construc = clasz.getConstructor();
            System.out.println("Construtor: " + construc);

            Produto prod1 = (Produto) construc.newInstance();
            System.out.println("Instancia: " + prod1);
            Field[] fields = prod1.getClass().getDeclaredFields();
            for(Field field : fields){
                System.out.println("Field Declarada: " + field.getName());
            }

            Field[] fields_publics = prod1.getClass().getFields();
            for (Field field : fields_publics){
                System.out.println("Metodos publicos: " + field.getName());
            }

            Method[] methods = prod1.getClass().getDeclaredMethods();
            for(Method method : methods){
                System.out.println("Metodo declarado: " + method.getName());
                Parameter[] paramMethod = method.getParameters();
                for (Parameter parame : paramMethod){
                    System.out.println("Parametros do metodo: " + parame.getParameterizedType());
                }
            }



        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}

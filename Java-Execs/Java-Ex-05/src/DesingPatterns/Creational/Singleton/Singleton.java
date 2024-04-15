package DesingPatterns.Creational.Singleton;

public class Singleton {

    private static Singleton singleton;
    private Integer value;

    private Singleton(Integer value){
        this.value = value;
    }

    public static Singleton getInstance(Integer value){
        if(singleton == null){
            singleton = new Singleton(value);
            return singleton;
        }
        return singleton;
    }

    public Integer getValue() {
        return value;
    }
}

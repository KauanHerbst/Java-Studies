package DesingPatterns.Creational.FactoryMethod.Objects;

public class Aviao implements ITransporte{
    @Override
    public void entregar() {
        System.out.println("Realizar entrega com Avião");
    }
}

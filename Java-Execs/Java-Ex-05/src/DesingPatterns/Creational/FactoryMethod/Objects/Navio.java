package DesingPatterns.Creational.FactoryMethod.Objects;

public class Navio implements ITransporte{
    @Override
    public void entregar() {
        System.out.println("Realizar entrega com Navio");
    }
}

package DesingPatterns.Creational.FactoryMethod.Objects;

public class Caminhao implements ITransporte{
    @Override
    public void entregar() {
        System.out.println("Realizar entrega com Caminhão");
    }
}

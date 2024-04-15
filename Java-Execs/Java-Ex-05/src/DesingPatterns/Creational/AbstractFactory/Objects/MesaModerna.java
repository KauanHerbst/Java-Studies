package DesingPatterns.Creational.AbstractFactory.Objects;

public class MesaModerna implements IMesa{
    @Override
    public void colocarObjeto() {
        System.out.println("Colando um objeto em cima de uma mesa Moderna");
    }
}

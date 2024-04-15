package DesingPatterns.Creational.AbstractFactory.Objects;

public class MesaRustica implements IMesa{
    @Override
    public void colocarObjeto() {
        System.out.println("Colando um objeto em cima de uma mesa Rustica");
    }
}

package DesingPatterns.Behavioral.Observer.Objects;

public class Client implements IObserver{
    @Override
    public void update(IProduct product) {
        System.out.println("Product " + product.getName() + " in stock");
    }
}

package DesingPatterns.Behavioral.Observer.Objects;

public class Book implements IProduct{

    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }
}

package DesingPatterns.Behavioral.Observer.Objects;

public interface ISubject {
    void registerObserver(IObserver observer);
    void deleteObserver(IObserver observer);
    void notifyObserver(IProduct product);
}

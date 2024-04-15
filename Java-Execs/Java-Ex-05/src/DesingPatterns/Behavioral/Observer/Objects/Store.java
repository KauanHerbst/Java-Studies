package DesingPatterns.Behavioral.Observer.Objects;

import java.util.ArrayList;

public class Store implements ISubject{
    private ArrayList<IObserver> observers = new ArrayList<>();
    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(IObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(IProduct product) {
        for(IObserver ob : observers){
            ob.update(product);
        }
    }
}

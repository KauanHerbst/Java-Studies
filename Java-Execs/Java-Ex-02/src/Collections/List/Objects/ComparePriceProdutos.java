package Collections.List.Objects;

import java.util.Comparator;

public class ComparePriceProdutos implements Comparator<Produtos> {
    @Override
    public int compare(Produtos p1, Produtos p2) {
        if(p1.getPrice() > p2.getPrice()){
            return 1;
        } else if (p1.getPrice() < p2.getPrice()){
            return -1;
        }
        return 0;
    }
}

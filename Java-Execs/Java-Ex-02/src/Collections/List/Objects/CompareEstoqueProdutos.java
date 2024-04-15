package Collections.List.Objects;

import java.util.Comparator;

public class CompareEstoqueProdutos implements Comparator<Produtos> {

    @Override
    public int compare(Produtos p1, Produtos p2) {
        if(p1.getQuantidadeDisponivel() > p2.getQuantidadeDisponivel()){
            return 1;
        }
        if(p1.getQuantidadeDisponivel() < p2.getQuantidadeDisponivel()){
            return -1;
        }
        return 0;
    }
}

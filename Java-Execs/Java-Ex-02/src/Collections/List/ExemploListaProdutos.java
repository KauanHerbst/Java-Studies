package Collections.List;

import Collections.List.Objects.CompareEstoqueProdutos;
import Collections.List.Objects.ComparePriceProdutos;
import Collections.List.Objects.Produtos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploListaProdutos {
    public static void main(String[] args) {
        Produtos carro = new Produtos(1d, "Carro", 50d);
        Produtos moto = new Produtos(2d, "Moto", 300d);
        Produtos barco = new Produtos(3d, "Barco", 100d);

        barco.addEstoque(10);
        moto.addEstoque(3);
        carro.addEstoque(5);

        List<Produtos> listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(barco);
        listaDeProdutos.add(carro);
        listaDeProdutos.add(moto);

        System.out.println("--------SEM COMPARAÇÃO--------");
        System.out.println(listaDeProdutos);

        Collections.sort(listaDeProdutos);

        System.out.println("--------COM COMPARAÇÃO COMPARABLE--------");
        System.out.println(listaDeProdutos);

        System.out.println("--------COM COMPARAÇÃO COMPARETOR ESTOQUE--------");
        CompareEstoqueProdutos compareEstoqueProdutos = new CompareEstoqueProdutos();

        Collections.sort(listaDeProdutos, compareEstoqueProdutos);
        System.out.println(listaDeProdutos);

        System.out.println("--------COM COMPARAÇÃO COMPARETOR ESTOQUE--------");
        ComparePriceProdutos comparePriceProdutos = new ComparePriceProdutos();

        Collections.sort(listaDeProdutos, comparePriceProdutos);

        System.out.println(listaDeProdutos);

    }
}

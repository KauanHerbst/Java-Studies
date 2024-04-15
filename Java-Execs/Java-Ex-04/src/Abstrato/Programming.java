package Abstrato;

import Abstrato.Objects.Carro;
import Abstrato.Objects.Moto;

public class Programming {
    public static void main(String[] args) {
        Carro carro1 = new Carro("Corolla", 2023d, "4D25GF", "Kauan");
        Moto moto1 = new Moto("Biz", 2009d, "H2H741", "Junior");

        System.out.println("===========CARRO==============");

        carro1.abastecer(3d);
        System.out.println( carro1.getCombustivel());
        carro1.ligar();
        System.out.println( carro1.getCombustivel());
        carro1.ligar();
        System.out.println( carro1.getCombustivel());
        carro1.desligar();
        carro1.desligar();
        carro1.ligar();
        System.out.println( carro1.getCombustivel());
        carro1.trocarPneu();
        carro1.desligar();
        carro1.trocarPneu();
        System.out.println(carro1.getDono());

        System.out.println("");
        System.out.println("===========MOTO==============");

    }
}


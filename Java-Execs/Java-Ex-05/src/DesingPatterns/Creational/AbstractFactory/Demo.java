package DesingPatterns.Creational.AbstractFactory;

import DesingPatterns.Creational.AbstractFactory.Factorys.FactoryModerno;
import DesingPatterns.Creational.AbstractFactory.Factorys.FactoryRustico;
import DesingPatterns.Creational.AbstractFactory.Factorys.IFactory;
import DesingPatterns.Creational.AbstractFactory.Objects.ICadeira;
import DesingPatterns.Creational.AbstractFactory.Objects.IMesa;
import DesingPatterns.Creational.AbstractFactory.Objects.ISofa;

public class Demo {
    public static void main(String[] args) {
        IFactory fabrica1 = new FactoryModerno();
        ICadeira cadeiraMorderna1 = fabrica1.createCadeira();
        IMesa mesaModerna1 = fabrica1.createMesa();
        cadeiraMorderna1.sentar();
        mesaModerna1.colocarObjeto();
        IFactory fabrica2 = new FactoryRustico();
        ISofa sofaRustico1 = fabrica2.createSofa();
        IMesa mesaRustica1 = fabrica2.createMesa();
        sofaRustico1.sentar();
        mesaRustica1.colocarObjeto();
    }
}

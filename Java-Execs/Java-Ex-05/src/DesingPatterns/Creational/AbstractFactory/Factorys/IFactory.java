package DesingPatterns.Creational.AbstractFactory.Factorys;

import DesingPatterns.Creational.AbstractFactory.Objects.ICadeira;
import DesingPatterns.Creational.AbstractFactory.Objects.IMesa;
import DesingPatterns.Creational.AbstractFactory.Objects.ISofa;

public interface IFactory {
    ICadeira createCadeira();
    IMesa createMesa();
    ISofa createSofa();
}

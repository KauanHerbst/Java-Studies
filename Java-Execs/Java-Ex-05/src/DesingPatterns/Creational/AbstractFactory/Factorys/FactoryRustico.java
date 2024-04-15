package DesingPatterns.Creational.AbstractFactory.Factorys;

import DesingPatterns.Creational.AbstractFactory.Objects.*;

public class FactoryRustico implements IFactory{
    @Override
    public ICadeira createCadeira() {
        return new CadeiraRustica();
    }

    @Override
    public IMesa createMesa() {
        return new MesaRustica();
    }

    @Override
    public ISofa createSofa() {
        return new SofaRustico();
    }
}

package DesingPatterns.Creational.AbstractFactory.Factorys;

import DesingPatterns.Creational.AbstractFactory.Objects.*;

public class FactoryModerno implements IFactory{
    @Override
    public ICadeira createCadeira() {
        return new CadeiraModerna();
    }

    @Override
    public IMesa createMesa() {
        return new MesaModerna();
    }

    @Override
    public ISofa createSofa() {
        return new SofaModerno();
    }
}

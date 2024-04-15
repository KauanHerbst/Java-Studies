package DesingPatterns.Creational.FactoryMethod.Creators;

import DesingPatterns.Creational.FactoryMethod.Objects.Caminhao;
import DesingPatterns.Creational.FactoryMethod.Objects.ITransporte;

public class CreatorCaminhhao implements ICreator{
    @Override
    public ITransporte criarTransporte() {
        return new Caminhao();
    }
}

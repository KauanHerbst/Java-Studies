package DesingPatterns.Creational.FactoryMethod.Creators;

import DesingPatterns.Creational.FactoryMethod.Objects.Aviao;
import DesingPatterns.Creational.FactoryMethod.Objects.ITransporte;

public class CreatorAviao implements ICreator{
    @Override
    public ITransporte criarTransporte() {
        return new Aviao();
    }
}

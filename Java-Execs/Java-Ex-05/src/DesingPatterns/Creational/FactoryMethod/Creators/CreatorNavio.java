package DesingPatterns.Creational.FactoryMethod.Creators;

import DesingPatterns.Creational.FactoryMethod.Objects.ITransporte;
import DesingPatterns.Creational.FactoryMethod.Objects.Navio;

public class CreatorNavio implements ICreator{
    @Override
    public ITransporte criarTransporte() {
        return new Navio();
    }
}

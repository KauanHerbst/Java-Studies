package DesingPatterns.Creational.FactoryMethod.Creators;

import DesingPatterns.Creational.FactoryMethod.Objects.ITransporte;

public interface ICreator {
    ITransporte criarTransporte();
}

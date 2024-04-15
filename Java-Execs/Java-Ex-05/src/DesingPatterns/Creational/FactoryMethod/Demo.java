package DesingPatterns.Creational.FactoryMethod;

import DesingPatterns.Creational.FactoryMethod.Creators.CreatorCaminhhao;
import DesingPatterns.Creational.FactoryMethod.Creators.CreatorNavio;
import DesingPatterns.Creational.FactoryMethod.Creators.ICreator;
import DesingPatterns.Creational.FactoryMethod.Objects.ITransporte;

public class Demo {
    public static void main(String[] args) {
        ICreator transporte1 = new CreatorCaminhhao();
        ITransporte caminhao1 = transporte1.criarTransporte();
        ITransporte caminhao2 = transporte1.criarTransporte();
        ICreator transporte2 = new CreatorNavio();
        ITransporte navio1 = transporte2.criarTransporte();

        caminhao1.entregar();
        caminhao2.entregar();
        navio1.entregar();
    }
}

package DesingPatterns.Creational.Builder;

import DesingPatterns.Creational.Builder.Builders.BuilderCasa;
import DesingPatterns.Creational.Builder.Builders.BuilderPlantaCasa;
import DesingPatterns.Creational.Builder.Objects.Casa;
import DesingPatterns.Creational.Builder.Objects.PlantaCasa;

public class Demo {
    public static void main(String[] args) {
        Director director = Director.getInstance();
        BuilderCasa builderCasa = new BuilderCasa();
        BuilderPlantaCasa builderPlanta = new BuilderPlantaCasa();

        director.construirCasaGrande(builderCasa);
        Casa casa1 = builderCasa.getCasa();
        casa1.print();
        director.construirCasaGrande(builderPlanta);
        PlantaCasa plantaCasa1 = builderPlanta.getPlantaCasa();
        plantaCasa1.mostrarPlanta();

        System.out.println("=======================");

        director.construirCasaMedia(builderCasa);
        Casa casa2 = builderCasa.getCasa();
        casa2.print();
        director.construirCasaMedia(builderPlanta);
        PlantaCasa plantaCasa2 = builderPlanta.getPlantaCasa();
        plantaCasa2.mostrarPlanta();

        System.out.println("=======================");

        director.construirCasaPequena(builderCasa);
        Casa casa3 = builderCasa.getCasa();
        casa3.print();
        director.construirCasaPequena(builderPlanta);
        PlantaCasa plantaCasa3 = builderPlanta.getPlantaCasa();
        plantaCasa3.mostrarPlanta();
    }
}

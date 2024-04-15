package DesingPatterns.Creational.Builder;

import DesingPatterns.Creational.Builder.Builders.IBuilder;

public class Director {

    private static Director director;

    private Director(){}

    public static Director getInstance(){
        if(director == null){
            director = new Director();
            return director;
        }
        return director;
    }

    public void construirCasaGrande(IBuilder builder){
        builder.setTipoCasa("Grande");
        builder.setJanelas(5);
        builder.setPortas(2);
        builder.setBanheiros(3);
        builder.setGaragem(4);
        builder.setQuartos(10);
    }

    public void construirCasaMedia(IBuilder builder){
        builder.setTipoCasa("Média");
        builder.setJanelas(3);
        builder.setPortas(2);
        builder.setBanheiros(2);
        builder.setGaragem(1);
        builder.setQuartos(4);
    }

    public void construirCasaPequena(IBuilder builder){
        builder.setTipoCasa("Pequena");
        builder.setJanelas(2);
        builder.setPortas(1);
        builder.setBanheiros(1);
        builder.setGaragem(0);
        builder.setQuartos(2);
    }


}

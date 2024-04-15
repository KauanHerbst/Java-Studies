package DesingPatterns.Creational.Builder.Builders;

import DesingPatterns.Creational.Builder.Objects.PlantaCasa;

public class BuilderPlantaCasa implements IBuilder {
    private String tipo;
    private Integer janelas;
    private Integer portas;
    private Integer garagem;
    private Integer quartos;
    private Integer banheiros;

    @Override
    public void setTipoCasa(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void setJanelas(Integer value) {
        this.janelas = value;
    }

    @Override
    public void setPortas(Integer value) {
        this.portas = value;
    }

    @Override
    public void setGaragem(Integer value) {
        this.garagem = value;
    }

    @Override
    public void setQuartos(Integer value) {
        this.quartos = value;
    }

    @Override
    public void setBanheiros(Integer value) {
        this.banheiros = value;
    }

    public PlantaCasa getPlantaCasa(){
        return new PlantaCasa(tipo, janelas, portas, garagem, quartos, banheiros);
    }
}

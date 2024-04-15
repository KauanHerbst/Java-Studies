package DesingPatterns.Creational.Builder.Builders;

public interface IBuilder {
    void setTipoCasa(String tipo);
    void setJanelas(Integer value);
    void setPortas(Integer value);
    void setGaragem(Integer value);
    void setQuartos(Integer value);
    void setBanheiros(Integer value);
}

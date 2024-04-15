package Abstrato.Objects;

public abstract class Veiculo {
    protected String modelo;
    protected Double ano;
    protected String placa;
    protected Double combustivel = 0d;

    public Veiculo(String modelo, Double ano, String placa) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }

    public abstract void abastecer(Double volume);
    public abstract void ligar();
    public abstract void desligar();

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getAno() {
        return ano;
    }

    public void setAno(Double ano) {
        this.ano = ano;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Double combustivel) {
        this.combustivel = combustivel;
    }


}

package DesingPatterns.Creational.Builder.Objects;

public class PlantaCasa {
    private String tipo;
    private Integer janelas;
    private Integer portas;
    private Integer garagem;
    private Integer quartos;
    private Integer banheiros;

    public PlantaCasa(String tipo, Integer janelas, Integer portas, Integer garagem, Integer quartos, Integer banheiros) {
        this.tipo = tipo;
        this.janelas = janelas;
        this.portas = portas;
        this.garagem = garagem;
        this.quartos = quartos;
        this.banheiros = banheiros;
    }

    public void mostrarPlanta(){
        System.out.println("A planta da casa é do tipo: " + this.tipo);
        System.out.println("A planta tem um numero de janelas: " + this.janelas);
        System.out.println("A planta tem um numero de portas: " + this.portas);
        System.out.println("A planta tem um numero de garagem: " + this.garagem);
        System.out.println("A planta tem um numero de quartos: " + this.quartos);
        System.out.println("A planta tem um numero de banheiros: " + this.banheiros);
    }
}

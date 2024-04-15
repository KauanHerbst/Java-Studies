package DesingPatterns.Creational.Builder.Objects;

public class Casa {
    private String tipo;
    private Integer janelas;
    private Integer portas;
    private Integer garagem;
    private Integer quartos;
    private Integer banheiros;

    public Casa(String tipo, Integer janelas, Integer portas, Integer garagem, Integer quartos, Integer banheiros) {
        this.tipo = tipo;
        this.janelas = janelas;
        this.portas = portas;
        this.garagem = garagem;
        this.quartos = quartos;
        this.banheiros = banheiros;
    }

    public void print(){
        System.out.println("Tipo da Casa: " + this.tipo);
        System.out.println("Numero de janelas: " + this.janelas);
        System.out.println("Numero de portas: " + this.portas);
        System.out.println("Numero de garagem: " + this.garagem);
        System.out.println("Numero de quartos: " + this.quartos);
        System.out.println("Numero de banheiros: " + this.banheiros);
    }
}

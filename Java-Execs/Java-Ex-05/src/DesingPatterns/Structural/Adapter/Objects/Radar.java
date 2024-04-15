package DesingPatterns.Structural.Adapter.Objects;

public class Radar {

    public void radarVelocidade(Double velocidadeMi){
        String resultado = velocidadeMi > 40 ? "Acimda Da velocidade esperada" : "Abaixo da velocidade limite";
        System.out.println(resultado);
    }

}

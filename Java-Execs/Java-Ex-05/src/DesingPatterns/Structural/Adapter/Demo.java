package DesingPatterns.Structural.Adapter;

import DesingPatterns.Structural.Adapter.Objects.Adaptador;
import DesingPatterns.Structural.Adapter.Objects.Radar;

public class Demo {
    public static void main(String[] args) {
        Double velocidadeMedidaKM = 60d;
        Radar radar = new Radar();
        radar.radarVelocidade(velocidadeMedidaKM); //Sem adaptador de unidade
        Adaptador adaptador = new Adaptador();
        radar.radarVelocidade(adaptador.adaptar(velocidadeMedidaKM)); // com adaptador de unidade

    }

}

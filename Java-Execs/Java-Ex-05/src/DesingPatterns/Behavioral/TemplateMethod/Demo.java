package DesingPatterns.Behavioral.TemplateMethod;

import DesingPatterns.Behavioral.TemplateMethod.Objects.Bombeiro;
import DesingPatterns.Behavioral.TemplateMethod.Objects.Policial;
import DesingPatterns.Behavioral.TemplateMethod.Objects.Trabalhador;

public class Demo {
    public static void main(String[] args) {
        Trabalhador trabalhador1 = new Bombeiro();
        Trabalhador trabalhador2 = new Policial();
        trabalhador1.rotinaDeTrabalho();
        System.out.println("-=-=-=-=-=-=-=-=-");
        trabalhador2.rotinaDeTrabalho();

    }
}

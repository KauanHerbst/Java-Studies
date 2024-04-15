package DesingPatterns.Behavioral.TemplateMethod.Objects;

public class Bombeiro extends Trabalhador{

    @Override
    protected void irAoTrabalho() {
        System.out.println("Indo ao trabalho de carro....");
    }

    @Override
    protected void trabalhar() {
        System.out.println("Trabalhando como Bombeiro...");
    }
}

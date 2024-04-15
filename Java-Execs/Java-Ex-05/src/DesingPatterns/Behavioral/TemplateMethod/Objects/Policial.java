package DesingPatterns.Behavioral.TemplateMethod.Objects;

public class Policial extends Trabalhador{
    @Override
    protected void irAoTrabalho() {
        System.out.println("Indo ao trabalho de moto...");
    }

    @Override
    protected void trabalhar() {
        System.out.println("Trabalhando como Policial...");
    }
}

package DesingPatterns.Behavioral.TemplateMethod.Objects;

public abstract class Trabalhador {
    public void rotinaDeTrabalho(){
        acordar();
        irAoTrabalho();
        trabalhar();
        voltarParaCasa();
        dormir();
    }
    private void acordar(){
        System.out.println("Acordando...");
    }
    protected abstract void irAoTrabalho();
    protected abstract void trabalhar();

    private void voltarParaCasa(){
        System.out.println("Voltando para casa...");
    }

    private  void dormir(){
        System.out.println("Dormindo...");
    }


}

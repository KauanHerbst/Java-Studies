package Abstrato.Objects;

public class Carro extends Veiculo{

    private String dono;
    private Boolean estado = false;


    public Carro(String modelo, Double ano, String placa, String dono) {
        super(modelo, ano, placa);
        this.dono = dono;
    }

    @Override
    public void abastecer(Double volume) {
        this.combustivel += volume;
    }

    @Override
    public void ligar() {
        if(this.combustivel > 0){
            if(!this.estado){
                System.out.println(getClass().getSimpleName() + " de " + this.dono + " ligado com sucesso");
                this.estado = true;
                this.combustivel--;
            }else {
                System.out.println(getClass().getSimpleName() + " já está ligado");
            }
        }else {
            System.out.println(getClass().getSimpleName() + " sem combustivel");
            this.estado = false;
        }
    }

    @Override
    public void desligar() {
        if(this.estado){
            System.out.println(getClass().getSimpleName() + " de " + this.dono + " desligado com sucesso");
            this.estado = false;
        }else {
            System.out.println(getClass().getSimpleName() + " já desligado");
        }
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public void trocarPneu(){
        if(this.estado != false){
            System.out.println("O " + getClass().getSimpleName() + " precisa estar desligado para trocar os pneus");
        }else {
            System.out.println("Os quatros pneus foram trocados");
        }
    }
}

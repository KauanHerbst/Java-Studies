package Abstrato.Objects;

public class Moto extends Veiculo{

    private String dono;
    private Boolean estado = false;

    public Moto(String modelo, Double ano, String placa, String dono) {
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
            if(this.estado == true){
                System.out.println(getClass().getSimpleName() + " de " + this.dono + " ligada com sucesso");
                this.estado = true;
                this.combustivel--;
            }else {
                System.out.println(getClass().getSimpleName() + " já está ligada");
            }
        }else {
            System.out.println(getClass().getSimpleName() + " sem combustivel");
            this.estado = false;
        }

    }

    @Override
    public void desligar() {
        if(this.estado == true){
            System.out.println(getClass().getSimpleName() + " de " + this.dono + " desligada com sucesso");
            this.estado = false;
        }else {
            System.out.println(getClass().getSimpleName() + " já desligada");
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
            System.out.println("Os dois pneus foram trocados");
        }
    }

}

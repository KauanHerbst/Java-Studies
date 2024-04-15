package Collections.List.Objects;

public class Produtos implements Comparable<Produtos> {
    private Double code;
    private String nome;
    private Double price;
    private Integer quantidadeDisponivel=0;
    private Integer quantidadeVendida=0;

    public Produtos(Double code, String nome, Double price) {
        this.code = code;
        this.nome = nome;
        this.price = price;
    }

    public Double getCode() {
        return code;
    }

    public void setCode(Double code) {
        this.code = code;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public void addEstoque(Integer number){
        this.quantidadeDisponivel += number;
    }

    public void removeEstoque(Integer number){
        this.quantidadeDisponivel -= number;
    }

    public void realizarVenda(Integer numberVendas){
        this.quantidadeVendida += numberVendas;
    }

    @Override
    public int compareTo(Produtos produto) {
        if(this.getCode() < produto.getCode()){
            return 1;
        }
        if(this.getCode() > produto.getCode()){
            return -1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "code=" + code +
                ", nome='" + nome + '\'' +
                '}';
    }
}

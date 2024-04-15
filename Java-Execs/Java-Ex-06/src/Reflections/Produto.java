package Reflections;

public class Produto {
    private String nome;
    private Integer idade;

    public Long cep;

    public Produto(){}

    public String getNome() {
        return nome;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}

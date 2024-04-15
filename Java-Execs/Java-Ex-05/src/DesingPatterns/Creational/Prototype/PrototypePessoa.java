package DesingPatterns.Creational.Prototype;

public abstract class PrototypePessoa {
    protected String nome;
    protected Integer idade;

    public abstract PrototypePessoa clonar();

    public String getNome() {
        return nome;
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

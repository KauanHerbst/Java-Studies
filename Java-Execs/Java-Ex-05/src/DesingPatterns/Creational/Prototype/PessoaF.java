package DesingPatterns.Creational.Prototype;

public class PessoaF extends PrototypePessoa{
    private Long cpf;

    PessoaF(Long cpf){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    PessoaF(PessoaF pessoaF){
        this.nome = pessoaF.getNome();
        this.idade = pessoaF.getIdade();
        this.cpf = pessoaF.getCpf();
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    @Override
    public PrototypePessoa clonar() {
        return new PessoaF(this);
    }
}

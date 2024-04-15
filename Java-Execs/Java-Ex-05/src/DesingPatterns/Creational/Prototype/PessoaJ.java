package DesingPatterns.Creational.Prototype;

public class PessoaJ extends PrototypePessoa{
    protected Long cnpj;

    public PessoaJ(Long cnpj) {
        this.nome = nome;
        this.idade = idade;
        this.cnpj = cnpj;
    }

    public PessoaJ(PessoaJ pessoaJ){
        this.nome = pessoaJ.getNome();
        this.idade = pessoaJ.getIdade();
        this.cnpj = pessoaJ.getCnpj();
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public PrototypePessoa clonar() {
        return new PessoaJ(this);
    }
}

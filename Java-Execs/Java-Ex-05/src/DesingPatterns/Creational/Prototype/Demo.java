package DesingPatterns.Creational.Prototype;

public class Demo {
    public static void main(String[] args) {
        PessoaF pessoaf1 = new PessoaF(111000l);
        pessoaf1.setNome("João");
        pessoaf1.setIdade(20);
        PrototypePessoa prototypePessoa1 = pessoaf1.clonar();
        System.out.println(pessoaf1.getNome());
        System.out.println(prototypePessoa1.getNome());
        PessoaJ pessoaj1 = new PessoaJ(2020l);
        pessoaj1.setNome("Vivian");
        pessoaj1.setIdade(32);
        PrototypePessoa prototypePessoa2 = pessoaj1.clonar();
        System.out.println(pessoaj1.getNome());
        System.out.println(prototypePessoa2.getNome());
    }
}

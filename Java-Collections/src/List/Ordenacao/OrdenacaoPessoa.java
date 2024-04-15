package List.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoa {
    private List<Pessoa> listaPessoa;

    public OrdenacaoPessoa() {
        listaPessoa = new ArrayList<>();
    }


    public void adicionarPessoa(String nome, int idade, double Altura){
        listaPessoa.add(new Pessoa(nome, idade, Altura));
    }

    public List<Pessoa> ordenarPorIdade(){
        List<Pessoa> listaPorPessoa = new ArrayList(listaPessoa);  
        Collections.sort(listaPorPessoa);
        return listaPorPessoa;

    }

    public List<Pessoa> ordenarPorAltura(){
        List<Pessoa> listaPorAltura = new ArrayList<>(listaPessoa);
        Collections.sort(listaPorAltura, new CompararPorAltura());
        return listaPorAltura;
    }
    
    public void exibirPessoas(){
        System.out.println(listaPessoa);
    }

    public static void main(String[] args) {
        OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();

        ordenacaoPessoa.adicionarPessoa("Afafa", 40, 110);
        ordenacaoPessoa.adicionarPessoa("Kauan", 19, 170);
        ordenacaoPessoa.adicionarPessoa("Nauak", 91, 130);
        ordenacaoPessoa.adicionarPessoa("Fetin", 2, 60);
        ordenacaoPessoa.exibirPessoas();

        System.out.println(ordenacaoPessoa.ordenarPorIdade());
        System.out.println(ordenacaoPessoa.ordenarPorAltura());
    }
}

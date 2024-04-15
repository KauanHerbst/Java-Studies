package exercicios.um;

import java.util.ArrayList;
import java.util.List;
import exercicios.um.Objects.Pessoa;

public class exerc {
    public static void main(String[] args) {
        List<Pessoa> listaP = new ArrayList<>();

        Pessoa pessoa1 = new Pessoa("Isabela", 1, 'F');
        Pessoa pessoa2 = new Pessoa("Ronaldo", 2, 'M');
        Pessoa pessoa3 = new Pessoa("Vitor", 3, 'M');
        Pessoa pessoa4 = new Pessoa("Maria", 4, 'F');
        Pessoa pessoa5 = new Pessoa("Joana", 5, 'F');

        listaP.add(pessoa1);
        listaP.add(pessoa2);
        listaP.add(pessoa3);
        listaP.add(pessoa4);
        listaP.add(pessoa5);

        List<Pessoa> listaF = verificarSexy(listaP, 'F');
        List<Pessoa> listaM = verificarSexy(listaP, 'M');
        System.out.println(listaP);
        System.out.println(listaF);
        System.out.println(listaM);


    }
    public static List<Pessoa> verificarSexy(List<Pessoa> listPessoas, Character sexy){
        List<Pessoa> listaS = new ArrayList<>();
        for(Pessoa pessoa : listPessoas){
            if(pessoa.getSexy().equals(sexy)){
                listaS.add(pessoa);
            }else {
                continue;
            }
        }
        return listaS;
    }

}

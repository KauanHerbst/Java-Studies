package Set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidados {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidados() {
        convidadoSet = new HashSet<>();
    }

    public void adicionarConvidado(String nome, int convidadoCodigo){
        convidadoSet.add(new Convidado(nome, convidadoCodigo));
    }
    

    public void removerConvidadoPorCodigo(int convidadoCodigo){
        Convidado convidadoParaRemover = null;
        for(Convidado c : convidadoSet){
            if(c.getConvidadoCodigo() == convidadoCodigo){
                convidadoParaRemover = c;
                break;
            }
        }
        convidadoSet.remove(convidadoParaRemover);
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }

    public static void main(String[] args) {
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();

        conjuntoConvidados.adicionarConvidado("KAUAN", 7);
        conjuntoConvidados.adicionarConvidado("KAUAN", 9);
        conjuntoConvidados.adicionarConvidado("NAUAK", 192);

        conjuntoConvidados.exibirConvidados();

        System.out.println(conjuntoConvidados.contarConvidados());

        conjuntoConvidados.removerConvidadoPorCodigo(9);

        System.out.println(conjuntoConvidados.contarConvidados());

        conjuntoConvidados.exibirConvidados();

    }
}

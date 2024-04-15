package Set.Pesquisar;

import java.util.HashSet;
import java.util.Set;

public class AgendaContato {
    private Set<Contato> contatoSet;

    public AgendaContato() {
        contatoSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));

    }

    public void exibirContato(){
        System.out.println(contatoSet);
    }
    
    public Contato pesquisarPorNome(String nome){
        Contato nomePesquisado = null;
        for(Contato c : contatoSet){
            if(c.getNome() == nome){
                nomePesquisado = c;
                break;
            }
        }
        return nomePesquisado;
    }

    public void atualizarNumeroContato(String nome, int novoNumero){
        for(Contato c : contatoSet){
            if(c.getNome() == nome){
                c.setNumero(novoNumero);
                break;
            }
        }
    }

    public static void main(String[] args) {
        AgendaContato agendaContato = new AgendaContato();

        agendaContato.adicionarContato("KAUAN", 1234);
        agendaContato.adicionarContato("NAUAK", 1456);
        agendaContato.adicionarContato("FETIN", 2456);
        agendaContato.exibirContato();

        System.out.println(agendaContato.pesquisarPorNome("KAUAN"));
        agendaContato.atualizarNumeroContato("KAUAN", 4321);
        System.out.println(agendaContato.pesquisarPorNome("KAUAN"));

    }
}

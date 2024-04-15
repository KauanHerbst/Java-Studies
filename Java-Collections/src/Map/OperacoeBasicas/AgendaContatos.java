package Map.OperacoeBasicas;

import java.util.HashMap;
import java.util.Map;

public class AgendaContatos {
    private Map<String, Integer> agendaContatosMap;

    public AgendaContatos() {
        this.agendaContatosMap = new HashMap<>();
    }

    public void adicionarContato(String nome, int numero) {
        agendaContatosMap.put(nome, numero);
    }

    public void removerContato(String nome) {
        agendaContatosMap.remove(nome);
    }

    public void exibirContatos() {
        System.out.println(agendaContatosMap);
    }

    public Integer pesquisarPorNome(String nome) {
        return agendaContatosMap.get(nome);
    }

    public static void main(String[] args) {
        AgendaContatos agendaContatos = new AgendaContatos();

        agendaContatos.adicionarContato("Kauan", 7777);
        agendaContatos.adicionarContato("Vi", 1888);

        agendaContatos.exibirContatos();

        agendaContatos.removerContato("Kauan");

        System.out.println(agendaContatos.pesquisarPorNome("Vi"));

    }

}

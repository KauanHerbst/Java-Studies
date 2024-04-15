package Set.Pesquisar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaDeTarefa {
    private Set<Tarefa> tarefaSet;

    public ListaDeTarefa() {
        tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaSet.add(new Tarefa(descricao));
    }
    
    public void removerTarefa(String descricao){
        Tarefa tarefaParaRemover = null;
        for(Tarefa t : tarefaSet){
            if(t.getDescricao() == descricao){
                tarefaParaRemover = t;
                break;
            }
        }
        tarefaSet.remove(tarefaParaRemover);
    }

    public void exibirTarefa(){
        System.out.println(tarefaSet);
    }

    public int contarTarefa(){
        return tarefaSet.size();
    }

    public Set<Tarefa> obterTarefasConcluidas(){
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        for(Tarefa t : tarefaSet){
            if(t.isState() == true){
                tarefasConcluidas.add(t);
            }
        }
        return tarefasConcluidas;
    }

    public Set<Tarefa> obterTarefasPendentes(){
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        for(Tarefa t : tarefaSet){
            if(t.isState() == false){
                tarefasPendentes.add(t);
            }
        }
        return tarefasPendentes;
    }

    public void marcarTarefaConcluida(String descricao){
        for(Tarefa t : tarefaSet){
            if(t.getDescricao() == descricao){
                t.setState(true);
                break;
            }else {
                System.out.println("Tarefa não encontrada");
            }
        }
    }

    public void marcarTarefaPendente(String descricao){
        for(Tarefa t : tarefaSet){
            if(t.getDescricao() == descricao){
                t.setState(false);
                break;
            }
        }
    }

    public void removerTarefas(){
        Set<Tarefa> tarefasParaRemover = new HashSet(tarefaSet);
        tarefaSet.removeAll(tarefasParaRemover);
    }

    public static void main(String[] args) {
        ListaDeTarefa listaDeTarefa = new ListaDeTarefa();

        listaDeTarefa.adicionarTarefa("Cagar");
        listaDeTarefa.adicionarTarefa("Trocar o gás");
        listaDeTarefa.adicionarTarefa("Limpar o quarto");

        listaDeTarefa.exibirTarefa();

        listaDeTarefa.marcarTarefaConcluida("Cagar");
        listaDeTarefa.marcarTarefaConcluida("Limpar o quarto");

        listaDeTarefa.exibirTarefa();
        
        System.out.println(listaDeTarefa.contarTarefa());

        listaDeTarefa.obterTarefasConcluidas();
    }

}


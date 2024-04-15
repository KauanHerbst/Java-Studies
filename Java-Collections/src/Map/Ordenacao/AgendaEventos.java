package Map.Ordenacao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private Map<LocalDate, Evento> agendaEventosMap;

    public AgendaEventos() {
        this.agendaEventosMap = new HashMap<>();
    }
    
    public void adicionarEvento(LocalDate data, String nome, String atracao){
        agendaEventosMap.put(data, new Evento(nome, atracao));

    }

    public void exibirAgenda(){
       Map<LocalDate, Evento> eventoTreeMap = new TreeMap<>(agendaEventosMap);
        System.out.println(eventoTreeMap);
    }

    
}

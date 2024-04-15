package Set.Pesquisar;

public class Tarefa {
    private boolean state;
    private String descricao;

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.state = false;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Tarefa [state=" + state + ", descricao=" + descricao + "]";
    }
    

    
}

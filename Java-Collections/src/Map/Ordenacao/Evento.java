package Map.Ordenacao;

public class Evento {
    private String nome;
    private String atrcao;


    public Evento(String nome, String atrcao) {
        this.nome = nome;
        this.atrcao = atrcao;
    }


    public String getNome() {
        return nome;
    }


    public String getAtrcao() {
        return atrcao;
    }


    @Override
    public String toString() {
        return "Evento [nome=" + nome + ", atrcao=" + atrcao + "]";
    }

    
    
}

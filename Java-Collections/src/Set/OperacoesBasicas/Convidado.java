package Set.OperacoesBasicas;

public class Convidado {
    private String nome;
    private int convidadoCodigo;


    public Convidado(String nome, int convidadoCodigo) {
        this.nome = nome;
        this.convidadoCodigo = convidadoCodigo;
    }


    public String getNome() {
        return nome;
    }


    public int getConvidadoCodigo() {
        return convidadoCodigo;
    }


    @Override
    public String toString() {
        return "Convidado [nome= " + nome + ", convidadoCodigo= " + convidadoCodigo + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + convidadoCodigo;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Convidado other = (Convidado) obj;
        if (convidadoCodigo != other.convidadoCodigo)
            return false;
        return true;
    }

    
    
}

package br.herbst.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_ALUNOS")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
    @SequenceGenerator(name = "aluno_seq", sequenceName = "seq_alunos", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "idade", nullable = false)
    private Integer idade;
    @OneToOne(mappedBy = "aluno")
    private Matricula matricula;
    @ManyToMany(mappedBy = "alunos")
    private List<Mesa> mesas;

    public Aluno() {
        this.mesas = new ArrayList<Mesa>();
    }

    public List<Mesa> getMesa() {
        return this.mesas;
    }

    public void setMesa(List<Mesa> mesas) {
        this.mesas = mesas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }
}

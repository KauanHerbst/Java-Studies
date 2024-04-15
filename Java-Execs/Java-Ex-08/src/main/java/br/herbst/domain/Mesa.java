package br.herbst.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "TB_MESAS")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mesas_sq")
    @SequenceGenerator(name = "mesas_sq", sequenceName = "seq_mesas", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "number")
    private Integer number;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "TB_MESA_ALUNO", joinColumns = @JoinColumn(name = "mesa_id"), inverseJoinColumns = @JoinColumn(name = "aluno_id"))
    private List<Aluno> alunos;

    public Mesa() {
        this.alunos = new ArrayList<Aluno>();
    }

    public void addAlunoMesa(Aluno aluno){
        this.alunos.add(aluno);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}



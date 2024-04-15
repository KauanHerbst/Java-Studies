package br.herbst.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_MATRICULAS")
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_sq")
    @SequenceGenerator(name = "matricula_sq", sequenceName = "sq_matricula", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "Codigo", nullable = false, unique = true)
    private String codigo;
    @Column(name = "Status", nullable = false)
    private String status;
    @Column(name = "Data", nullable = false)
    private String data;
    @ManyToOne
    @JoinColumn(name = "id_curso_fk", foreignKey = @ForeignKey(name = "curso_matricula_fk"), referencedColumnName = "id", nullable = false)
    private Curso curso;
    @OneToOne()
    @JoinColumn(name = "id_aluno_fk", foreignKey = @ForeignKey(name = "aluno_matricula_fk"), referencedColumnName = "id", nullable = false)
    private Aluno aluno;

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

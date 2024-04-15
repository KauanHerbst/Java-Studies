package br.herbst.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TB_CURSOS")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_sq")
    @SequenceGenerator(name = "curso_sq", sequenceName = "sq_curso", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "Codigo", nullable = false, unique = true)
    private String codigo;
    @Column(name = "Nome", length = 100, nullable = false)
    private String nome;

    @OneToMany(mappedBy = "curso")
    private List<Matricula> matriculas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

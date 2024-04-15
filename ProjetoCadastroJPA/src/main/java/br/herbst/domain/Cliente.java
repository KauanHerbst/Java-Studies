package br.herbst.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_CLIENTES")
public class Cliente implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sq")
    @SequenceGenerator(name = "cliente_sq", sequenceName = "sq_clientes", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "idade", nullable = false)
    private Integer idade;
    @Column(name = "cpf", nullable = false, unique = true)
    private Long cpf;
    @Column(name = "estado", nullable = false)
    private String estado;

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

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}

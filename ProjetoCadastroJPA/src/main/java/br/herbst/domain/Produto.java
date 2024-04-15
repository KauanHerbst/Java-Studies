package br.herbst.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_PRODUTOS")
public class Produto implements BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_sq")
    @SequenceGenerator(name = "produto_sq", sequenceName = "sq_produtos", initialValue = 1, allocationSize = 1)
    private Long id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "estoque", nullable = false)
    private Integer estoque;
    @Column(name = "valor", nullable = false)
    private Double valor;

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

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}

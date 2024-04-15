package br.herbst.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tb_users")
public class User implements Serializable {
    public static final long serialVersionUID = 1l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "idade")
    private Integer idade;
    @Column(name = "estado")
    private String estado;

    @JsonIgnore()
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
    public User() {
    }


}

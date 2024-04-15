package exercicios.um.Objects;

import java.util.Objects;

public class Pessoa {
    private String name;
    private Integer code;
    private Character sexy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Character getSexy() {
        return sexy;
    }

    public void setSexy(Character sexy) {
        this.sexy = sexy;
    }

    public Pessoa(String name, Integer code, Character sexy) {
        this.name = name;
        this.code = code;
        this.sexy = sexy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(code, pessoa.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", sexy=" + sexy +
                '}';
    }
}

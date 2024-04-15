package Collections.Queue.Objects;

public class Animais implements Comparable<Animais> {
    private String name;
    private String especie;
    private Integer code;

    public Animais(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Animais{" +
                "name='" + name + '\'' +
                ", code=" + code +
                '}';
    }

    @Override
    public int compareTo(Animais a) {
        if(this.getCode() > a.getCode()){
            return 1;
        } else if(this.getCode() < a.getCode()){
            return -1;
        }
        return 0;
    }
}

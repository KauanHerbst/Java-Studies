package Generics;

public class GenericClass<T, E> {
    private T codigo;
    private E date;

    public GenericClass(T codigo, E date) {
        this.codigo = codigo;
        this.date = date;
    }

    public T  getCodigo(){
        return this.codigo;
    }
    public void setCodigo(T codigo){
        this.codigo = codigo;
    }

    public E getDate(){
        return this.date;
    }

    public void setDate(E date){
        this.date = date;
    }


}

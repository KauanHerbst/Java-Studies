package Exceptions;

import Exceptions.ExpExceptions.EstoqueInvalidoException;
import Exceptions.ExpExceptions.LimiteInvalidoException;

public class Demo2 {
    public static void main(String[] args) {
        Integer limite = 210;
        Integer produto = 6;
        try {
            realizarCompra(limite, produto);
        }catch (LimiteInvalidoException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (EstoqueInvalidoException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void realizarCompra(Integer limite, Integer produto) throws LimiteInvalidoException, EstoqueInvalidoException {
        if(produto > 5){
            if(limite > 20){
                System.out.println("Compra Realizada!");
            }else {
                LimiteInvalidoException erroLimite = new LimiteInvalidoException("Limite Insuficiente!");
                throw erroLimite;
            }
        }else {
            EstoqueInvalidoException erroEstoque = new EstoqueInvalidoException("Produto em falta no estoque!");
            throw erroEstoque;
        }
    }


}

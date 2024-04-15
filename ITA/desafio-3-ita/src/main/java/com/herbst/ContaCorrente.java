package com.herbst;

public class ContaCorrente {
    private String numero;
    private Double saldo;

    public ContaCorrente(String numeroConta){
        this.numero = numeroConta;
        this.saldo = 120d;
    }

    public void crediar(Double valor){
        saldo += valor;
    }

    public void debitar(Double valor){
        saldo -= valor;
    }

    public Double getSaldo(){
        return saldo;
    }

    public String getNumero(){
        return numero;
    }
}

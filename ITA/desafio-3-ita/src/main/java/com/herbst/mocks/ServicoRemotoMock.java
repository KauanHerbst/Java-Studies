package com.herbst.mocks;

import com.herbst.ContaCorrente;
import com.herbst.ServicoRemoto;

public class ServicoRemotoMock implements ServicoRemoto {
    private  ContaCorrente conta;

    public ServicoRemotoMock(String numeroConta){
        this.conta = new ContaCorrente(numeroConta);
    }
    @Override
    public ContaCorrente recuperarConta(String numeroConta) {
      if(this.conta.getNumero().equals(numeroConta)){
          return conta;
      }
        return null;
    }

    @Override
    public void persistirConta(ContaCorrente conta) {
        this.conta = conta;
    }
}

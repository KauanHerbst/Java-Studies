package com.herbst;

public interface ServicoRemoto {
    ContaCorrente recuperarConta(String numeroConta);

    void persistirConta(ContaCorrente conta);
}

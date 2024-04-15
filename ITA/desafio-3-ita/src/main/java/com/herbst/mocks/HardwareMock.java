package com.herbst.mocks;

import com.herbst.Hardware;
import com.herbst.exceptions.HardwareException;

public class HardwareMock implements Hardware {
    @Override
    public String pegarNumeroDaContaCartao(String numeroConta) {
        return numeroConta;
    }

    @Override
    public void entregarDinheiro() {

    }

    @Override
    public void receberEnvelope() {

    }

    public void simulandoErro(){
        throw new HardwareException("Não foi possível autenticar o usuário");
    }
}

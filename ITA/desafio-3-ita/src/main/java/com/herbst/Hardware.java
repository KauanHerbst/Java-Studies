package com.herbst;

import com.herbst.exceptions.HardwareException;

public interface Hardware {
    String pegarNumeroDaContaCartao(String numeroConta) throws HardwareException;
    void entregarDinheiro() throws HardwareException;
    void receberEnvelope() throws HardwareException;

    void simulandoErro() throws  HardwareException;
}

package com.herbst;

public class CaixaEletronico {
    private ServicoRemoto servicoRemoto;
    private Hardware hardware;

    private  ContaCorrente conta;
    public CaixaEletronico(ServicoRemoto servicoRemoto, Hardware hardware) {
        this.hardware = hardware;
        this.servicoRemoto = servicoRemoto;
    }

    public String logar(String numero) {
        String numeroConta = hardware.pegarNumeroDaContaCartao(numero);
        this.conta = servicoRemoto.recuperarConta(numeroConta);

        if (conta != null) {
            return "Usuário Autenticado";
        } else {
            return "Não foi possível autenticar o usuário";
        }
    }

    public String saldo(){
        return "O saldo é R$" + conta.getSaldo();
    }

    public String sacar(Double valor){
        if(conta.getSaldo() >= valor){
            conta.debitar(valor);
            servicoRemoto.persistirConta(conta);
            return "Retire seu dinheiro";
        } else {
            return "Saldo insuficiente";
        }
    }

    public String depositar(Double valor){
        conta.crediar(valor);
        servicoRemoto.persistirConta(conta);
        return "Depósito recebido com sucesso";
    }


}

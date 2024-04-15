import com.herbst.CaixaEletronico;
import com.herbst.ContaCorrente;
import com.herbst.Hardware;
import com.herbst.ServicoRemoto;
import com.herbst.exceptions.HardwareException;
import com.herbst.mocks.HardwareMock;
import com.herbst.mocks.ServicoRemotoMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CaixaEletronicoTest {

    @Test
    public void logarComSucesso(){
        String numeroConta = "123456";
        ServicoRemoto servicoRemotoMock = new ServicoRemotoMock(numeroConta);
        Hardware hardwareMock = new HardwareMock();

        CaixaEletronico caixaEletronico = new CaixaEletronico(servicoRemotoMock, hardwareMock);
        String mensagem = caixaEletronico.logar(numeroConta);

        Assertions.assertEquals("Usuário Autenticado", mensagem);

    }

    @Test
    public void logarmSemSucesso(){
        String numeroConta = "123456";
        ServicoRemoto servicoRemotoMock = new ServicoRemotoMock(numeroConta);
        Hardware hardwareMock = new HardwareMock();

        CaixaEletronico caixaEletronico = new CaixaEletronico(servicoRemotoMock, hardwareMock);
        Assertions.assertThrows(HardwareException.class, () -> {
            caixaEletronico.logar(numeroConta);
            hardwareMock.simulandoErro();
        });

    }

    @Test
    public void verSaldo(){
        String numeroConta = "123456";
        ServicoRemoto servicoRemotoMock = new ServicoRemotoMock(numeroConta);
        Hardware hardwareMock = new HardwareMock();

        CaixaEletronico caixaEletronico = new CaixaEletronico(servicoRemotoMock, hardwareMock);
        caixaEletronico.logar(numeroConta);
        String mensagem = caixaEletronico.saldo();
        Assertions.assertEquals("O saldo é R$120.0", mensagem);

    }

    @Test
    public void sacarComSucesso(){
        String numeroConta = "123456";
        ServicoRemoto servicoRemotoMock = new ServicoRemotoMock(numeroConta);
        Hardware hardwareMock = new HardwareMock();

        CaixaEletronico caixaEletronico = new CaixaEletronico(servicoRemotoMock, hardwareMock);
       caixaEletronico.logar(numeroConta);
       String mensagem = caixaEletronico.sacar(100d);
       Assertions.assertEquals("Retire seu dinheiro", mensagem);
    }

    @Test
    public void sacarSemSaldoSuficiente(){
        String numeroConta = "123456";
        ServicoRemoto servicoRemotoMock = new ServicoRemotoMock(numeroConta);
        Hardware hardwareMock = new HardwareMock();

        CaixaEletronico caixaEletronico = new CaixaEletronico(servicoRemotoMock, hardwareMock);
        caixaEletronico.logar(numeroConta);
        String mensagem = caixaEletronico.sacar(1000d);
        Assertions.assertEquals("Saldo insuficiente", mensagem);
    }

    @Test
    public void depositarValorComSucesso(){
        String numeroConta = "123456";
        ServicoRemoto servicoRemotoMock = new ServicoRemotoMock(numeroConta);
        Hardware hardwareMock = new HardwareMock();

        CaixaEletronico caixaEletronico = new CaixaEletronico(servicoRemotoMock, hardwareMock);
        caixaEletronico.logar(numeroConta);
        Double valorParaDeposito = 1000d;
        String mensagem = caixaEletronico.depositar(valorParaDeposito);
        Assertions.assertEquals("Depósito recebido com sucesso", mensagem);
    }

    @Test
    public void depositarValorSemSucesso(){
        String numeroConta = "123456";
        ServicoRemoto servicoRemotoMock = new ServicoRemotoMock(numeroConta);
        Hardware hardwareMock = new HardwareMock();

        CaixaEletronico caixaEletronico = new CaixaEletronico(servicoRemotoMock, hardwareMock);
        Assertions.assertThrows(HardwareException.class, () -> {
            caixaEletronico.logar(numeroConta);
            Double valorParaDeposito = 1000d;
            String mensagem = caixaEletronico.depositar(valorParaDeposito);
            hardwareMock.simulandoErro();
        });

    }
}

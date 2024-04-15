import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        // Lendo os dados de Entrada:
        Scanner scanner = new Scanner(System.in);
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha após a entrada do número da conta
        String nomeTitular = scanner.nextLine();
        double saldo = scanner.nextDouble();

        // TODO: Criar uma instância de "ContaBancaria" com os valores de Entrada.

        ContaBancaria conta = new ContaBancaria(numeroConta, nomeTitular, saldo);

        // TODO: Imprimir as informações da conta usando o objeto criado no TODO acima.

    }
}

class ContaBancaria {
    int numero;
    String titular;
    double saldo;

    public ContaBancaria(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;

        System.out.println("Informacoes:");
        System.out.println("Conta: " + this.numero);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: R$ " + this.saldo);

    }
}

class ContaPoupanca extends ContaBancaria {
    private double taxaJuros;

    public ContaPoupanca(int numero, String titular, double saldo, double taxaJuros) {
        super(numero, titular, saldo);
        this.taxaJuros = taxaJuros;
    }

}
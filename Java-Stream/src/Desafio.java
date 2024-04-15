import java.util.Scanner;

public class Desafio {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String entrada = scanner.nextLine();
    String[] partes = entrada.split(",");

    // Gerar uma transação com os dados fornecidos pelo usuário
    Transacao transacao = gerarTransacao(partes);

    // Imprimir a saída da transação
    transacao.imprimir();
  }

  // Gerar uma transação com os dados fornecidos pelo usuário
  public static Transacao gerarTransacao(String[] partes) {
    return new Transacao(
        partes[0],
        partes[1],
        partes[2],
        Double.parseDouble(partes[3]));
  }
}

class Transacao {
  private String data;
  private String hora;
  private String descricao;
  private double valor;

  public Transacao(String data, String hora, String descricao, double valor) {
    this.data = data;
    this.hora = hora;
    this.descricao = descricao;
    this.valor = valor;
  }

  // Imprimir a saída da transação
  public void imprimir() {
    System.out.println(this.descricao);
    System.out.println(this.data);
    System.out.println(this.hora);
    System.out.println(this.valor);
  }
}
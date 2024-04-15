package shopping;
/**
 * @author Kauan-Herbst
 * 
 * @version 1.0
 * 
 */

public class Vendedor {
    private int codigo;
    private String nome;
    private int idade;
    private int vendasRealizadas;

    
   
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getVendasRealizadas() {
        return vendasRealizadas;
    }
    public void setVendasRealizadas(int vendasRealizadas) {
        this.vendasRealizadas = vendasRealizadas;
    }

    public Vendedor(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }


    /**
     *  Metodo de venda de produtos!
     * 
     * 
     * @param produto Produto a ser veendido!
     * @param quantidadeProdutos Quantidade de produtos a ser vendidos!
     */

    public void realizarVenda(Produtos produto, int quantidadeProdutos){
        if( produto.venderProduto(quantidadeProdutos) == true) {
            System.out.println("Venda realizada com sucesso!");
            this.vendasRealizadas++;
        } else {
            System.out.println("Venda não realizada!");
        }
    }    

}

package shopping;
/** 
 * @author Kauan-Herbst
 * 
 * @version 1.0
 * 
*/

public class Cliente {
    
    private int codigo;
    private String nome;
    private int idade;
    private String endereco;
    private int produtosComprados;
    
    
    
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
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getProdutosComprados() {
        return produtosComprados;
    }
    public void setProdutosComprados(int produtosComprados) {
        this.produtosComprados = produtosComprados;
    }
    
    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    /**
     *  Metodo para realizar a compra de um produto!
     * 
     * 
     * @param produto Produto a ser vendido!
     * @param vendedor Vendedor que irá realizar a venda!
     * @param quantidadeProdutos Quantidade de produtos vendidos!
     * 
     * @see public void realizarVenda(Produtos produto, int quantidadeProdutos)
     * 
     * @version 1.0
     * 
     */
    public void comprarProduto(Produtos produto, Vendedor vendedor, int quantidadeProdutos){
        vendedor.realizarVenda(produto, quantidadeProdutos);
        this.produtosComprados = this.produtosComprados + quantidadeProdutos;
    }

}

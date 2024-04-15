package shopping;
/**
 * @author Kauan-Herbst
 * 
 * @version 1.0
 * 
 */

public class Produtos {

    private int codigo;
    private int quantidadeDisponivel;
    private String nome;
    private int valor;
    private int quantidadeVendida;
    

   
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

    public int getValor() {
        return this.valor;
    }

    public void setValor(int valor){
        this.valor = valor;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }
    public void setQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
    
    public Produtos(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    /**
     *  Metodo para verificar a venda de produtos a partir da quantidade de produtos a ser vendido e a quantidade disponivel em estoque!
     * 
     * 
     * @param quantidade Quantidade de produtos que será vendidos!
     *
     * 
     * @version 1.0
     */
    public boolean venderProduto(int quantidade){
        if(this.quantidadeDisponivel >= quantidade){
            this.quantidadeDisponivel = this.quantidadeDisponivel - quantidade;
            this.quantidadeVendida = this.quantidadeVendida + quantidade;
            return true;
        } else {
            System.out.println("Produto sem estoque!");
            return false;
        }
    }

}

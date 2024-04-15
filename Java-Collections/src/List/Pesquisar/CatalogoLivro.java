package List.Pesquisar;

import java.util.List;
import java.util.ArrayList;

public class CatalogoLivro {
    private List<Livro> livrosLista;

    public CatalogoLivro() {
        livrosLista = new ArrayList<>();
    }

    public void adicionarLivro(String nome, String autor, int anoDePublicacao){
        livrosLista.add(new Livro(nome, autor, anoDePublicacao));
    }
    
    public List<Livro> pesquisarPorAutor(String autor){
        List<Livro> listaPorAutor = new ArrayList<>();
        if(!livrosLista.isEmpty()){
            for(Livro l : livrosLista){
                if(l.getAutor().equalsIgnoreCase(autor)){
                    listaPorAutor.add(l);
                }
            }
        }
        return listaPorAutor;
    }

    public Livro pesquisarPorTitulo(String titulo){
        Livro LivroPorTitulo = null;
        if(!livrosLista.isEmpty()){
            for(Livro l : livrosLista){
                if(l.getNome().equalsIgnoreCase(titulo)){
                    LivroPorTitulo = l;
                }
            }
        }
        return LivroPorTitulo;
    }

    public List<Livro> pesquisarPorAno(int anoInicial, int anoFinal){
        List<Livro> listPorAno = new ArrayList<>();
        if(!livrosLista.isEmpty()){
            for(Livro l : livrosLista){
                if(l.getAnoDePublicacao() >= anoInicial && l.getAnoDePublicacao() <= anoFinal){
                    listPorAno.add(l);
                }
            }
        }
        return listPorAno;
    }

    public void exbirLivros(){
        System.out.println(livrosLista);
    }


    public static void main(String[] args) {
        CatalogoLivro catalogoLivro = new CatalogoLivro();

        catalogoLivro.adicionarLivro("O exterminio", "Cavalo de Assis", 1999);
        catalogoLivro.adicionarLivro("O pateta", "Monzart", 1875);
        catalogoLivro.adicionarLivro("O cagador", "Cavalo de Assis", 2005);


        catalogoLivro.exbirLivros();
        System.out.println(catalogoLivro.pesquisarPorAutor("Cavalo de Assis"));

        System.out.println(catalogoLivro.pesquisarPorAno(1999, 2010));

        System.out.println(catalogoLivro.pesquisarPorTitulo("O cagador"));
    }
}

package com.herbst.screens;

import com.herbst.domain.Produto;
import com.herbst.domain.creators.CreatorProduto;
import com.herbst.domain.creators.ICreatorProduto;
import com.herbst.service.MainService;
import com.sun.tools.javac.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ScreenProdutos extends JFrame{
    private JPanel PainelMain;
    private JLabel HeadeProdutos;
    private JLabel LbNome;
    private JTextField TxtNome;
    private JLabel LbEstoque;
    private JTextField TxtEstoque;
    private JLabel LbPreco;
    private JTextField TxtPreco;
    private JButton bntCadastar;
    private JTable TableDados;
    private JButton btnAtualizar;
    private JButton btnExcluir;
    private JButton btnLimpar;
    private JButton btnMenu;
    private DefaultTableModel tableModel = new DefaultTableModel();
    private ICreatorProduto iCreatorProduto = new CreatorProduto();

    public ScreenProdutos() {
        setTitle("Produtos");
        setContentPane(PainelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        initTable();
        buscarProdutosDB();
        bntCadastar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try {
                   if(isCamposValidos()){JOptionPane.showMessageDialog(null, "Campos Invalidos! Complete todos os campos");}
                   String nome = TxtNome.getText();
                   Integer estoque = Integer.parseInt(TxtEstoque.getText());
                   Double preco = Double.parseDouble(TxtPreco.getText());
                   Produto produto = iCreatorProduto.criarProduto(nome, estoque, preco);
                   MainService.cadastrarProduto(produto);
                   limparCampos();
                   JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
                   adicionarProdutoTabela(MainService.buscarProduto(nome));
               }catch (Exception ex){
                   JOptionPane.showMessageDialog(null, "Preencha os campos de acordo com os dados!");
               }
            }
        });
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ScreenSelect();
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        TableDados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = TableDados.getSelectedRow();
                TxtNome.setEditable(false);
                Produto produto = MainService.buscarProduto((String) TableDados.getValueAt(row, 1));
                TxtNome.setText(produto.getNome());
                TxtEstoque.setText(produto.getEstoque().toString());
                TxtPreco.setText(produto.getValor().toString());
            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = TableDados.getSelectedRow();
                if(row >= 0){
                    int option = JOptionPane.showConfirmDialog(null, "Deseja excluir o esse produto?", "Excluir Produto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(option == JOptionPane.YES_OPTION){
                        MainService.excluirProduto(TxtNome.getText());
                        JOptionPane.showMessageDialog(null, "Produto Excluido!");
                        tableModel.removeRow(row);
                    }
                    limparCampos();
                }else {
                    JOptionPane.showMessageDialog(null, "Selecione um Produto!");
                }
            }
        });
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = TableDados.getSelectedRow();
                if(row >= 0){
                    int option = JOptionPane.showConfirmDialog(null, "Deseja atualizar esse produto?", "Excluir Produto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(option == JOptionPane.YES_OPTION){
                        String nome = TxtNome.getText();
                        Integer estoque = Integer.parseInt(TxtEstoque.getText());
                        Double preco = Double.parseDouble(TxtPreco.getText());
                        MainService.atualizarProduto(iCreatorProduto.criarProduto(nome, estoque, preco), nome);
                        tableModel.removeRow(row);
                        adicionarProdutoTabela(MainService.buscarProduto(nome));
                        JOptionPane.showMessageDialog(null, "Produto Atualizado!");

                    }
                    limparCampos();
                }else {
                    JOptionPane.showMessageDialog(null, "Selecione um Produto!");
                }
            }
        });
    }

    public void limparCampos(){
        TxtNome.setText("");
        TxtEstoque.setText("");
        TxtPreco.setText("");
        TxtNome.setEditable(true);
    }

    public Boolean isCamposValidos(){
        if(TxtNome.getText().equals("") && TxtEstoque.getText().equals("") && TxtPreco.getText().equals("")){
            return true;
        }
        return false;
    }

    public void adicionarProdutoTabela(Produto produto){
        tableModel.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getEstoque(), produto.getValor()});
    }


    public void initTable(){
        tableModel.addColumn("Id");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Estoque");
        tableModel.addColumn("Preço");

        TableDados.setModel(tableModel);
    }

    public void buscarProdutosDB(){
        ArrayList<Produto> produtoArrayList = new ArrayList<>();
        produtoArrayList = MainService.retornarProdutos();
        produtoArrayList.forEach((Produto pro) -> {
            adicionarProdutoTabela(pro);
        });

    }
}

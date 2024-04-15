package com.herbst.screens;

import com.herbst.domain.Cliente;
import com.herbst.domain.creators.CreatorCliente;
import com.herbst.domain.creators.ICreatorCliente;
import com.herbst.service.MainService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ScreenClientes extends JFrame{
    private JPanel PainelMain;
    private JLabel HeadClientes;
    private JLabel LbNome;
    private  JTextField TxtNome;
    private JLabel LbIdade;
    private  JTextField TxtIdade;
    private JLabel LbCpf;
    private  JTextField TxtCpf;
    private JLabel LbEstado;
    private  JTextField TxtEstado;
    private JTable TableDados;
    private JButton btnCadastrar;
    private JButton btnExcluir;
    private JButton btnAtualizar;
    private JButton btnLimpar;
    private JButton btnMenu;
    private DefaultTableModel tableModel = new DefaultTableModel();

    private ICreatorCliente iCreatorCliente = new CreatorCliente();

    public ScreenClientes() {
        setTitle("Clientes");
        setContentPane(PainelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        initTable();
        buscasDadosTabela();
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isCamposValidos()){JOptionPane.showMessageDialog(null, "Campos Invalidos! Complete todos os campos");}
                try {
                    String nome = TxtNome.getText();
                    Integer idade = Integer.parseInt(TxtIdade.getText());
                    Long cpf = Long.parseLong(TxtCpf.getText());
                    String estado = TxtEstado.getText();
                    MainService.cadastrarCliente(iCreatorCliente.criarCliente(nome, idade, cpf, estado));
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
                    adicionarClienteTabela(MainService.buscarClienteCPF(cpf));
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Preencha os campos de acordo com os dados!");
                }
            }
        });
        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                voltarMenu();
            }
        });
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer row = TableDados.getSelectedRow();
                if(!(row >= 0)){
                    limparCampos();
                }

            }
        });

        TableDados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = TableDados.getSelectedRow();
                TxtCpf.setEditable(false);
                Long cpf = Long.parseLong(String.valueOf(TableDados.getValueAt(row, 3)));
                Cliente cliente = MainService.buscarClienteCPF(cpf);
                TxtNome.setText(cliente.getNome());
                TxtIdade.setText(cliente.getIdade().toString());
                TxtCpf.setText(cliente.getCpf().toString());
                TxtEstado.setText(cliente.getEstado());
            }
        });
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int row = TableDados.getSelectedRow();
               if(row >= 0){
                   int option = JOptionPane.showConfirmDialog(null, "Deseja Atualizar esse cliente?", "Atualizar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                   if (option == JOptionPane.YES_OPTION){
                       String nome = TxtNome.getText();
                       Integer idade = Integer.parseInt(TxtIdade.getText());
                       Long cpf = Long.parseLong(TxtCpf.getText());
                       String estado = TxtEstado.getText();
                       Cliente clienteNew = iCreatorCliente.criarCliente(nome, idade, cpf, estado);
                       MainService.atualizarCliente(clienteNew, cpf);
                       JOptionPane.showMessageDialog(null, "Cliente Atualizado");
                       tableModel.removeRow(row);
                       adicionarClienteTabela(MainService.buscarClienteCPF(cpf));
                   }
                   limparCampos();
               }else {
                   JOptionPane.showMessageDialog(null, "Selecione um cliente!");
               }

            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = TableDados.getSelectedRow();
                if(row >= 0){
                    int option = JOptionPane.showConfirmDialog(null, "Deseja Excluir esse cliente?", "Excluir Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if(option == JOptionPane.YES_OPTION){
                        Long cpf = Long.parseLong(TxtCpf.getText());
                        MainService.excluirClienteCPF(cpf);
                        tableModel.removeRow(row);
                    }
                    limparCampos();
                }else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente!");
                }

            }
        });
    }

    public Boolean isCamposValidos(){
        if(TxtNome.getText().equals("") && TxtIdade.getText().equals("") && TxtCpf.getText().equals("") && TxtEstado.getText().equals("")){
            return true;
        }
        return false;
    }

    public void limparCampos(){
        TxtNome.setText("");
        TxtIdade.setText("");
        TxtCpf.setText("");
        TxtEstado.setText("");
        TxtCpf.setEditable(true);

    }

    public void voltarMenu(){
        dispose();
        new ScreenSelect();
    }

    public void initTable(){
        tableModel.addColumn("Id");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Idade");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Estado");
        TableDados.setModel(tableModel);
       TableDados.setTableHeader(new JTableHeader(TableDados.getColumnModel()));
    }

    public void buscasDadosTabela(){
        ArrayList<Cliente> clienteArrayList = new ArrayList<Cliente>();
        clienteArrayList = MainService.retornarClientes();
        clienteArrayList.forEach((Cliente cliente) -> {
            adicionarClienteTabela(cliente);
        });
    }

    public void adicionarClienteTabela(Cliente cliente){
        tableModel.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getIdade(), cliente.getCpf(), cliente.getEstado()});
    }

}

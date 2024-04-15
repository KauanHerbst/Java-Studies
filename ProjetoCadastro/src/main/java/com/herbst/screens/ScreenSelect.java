package com.herbst.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenSelect extends JFrame{
    private JButton btnClientes;
    private JPanel PainelMain;
    private JButton btnProdutos;


    public ScreenSelect() {
        setTitle("Cadastro Clientes e Produtos");
        setContentPane(PainelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ScreenClientes screenClientes = new ScreenClientes();
            }
        });
        btnProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ScreenProdutos screenProdutos = new ScreenProdutos();
            }
        });
    }
}

package com.herbst.screens;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenLogin extends JFrame{
    private JLabel headLogin;
    private JLabel LbUsuario;
    private JLabel LbSenha;
    private JPasswordField TxtSenha;
    private JTextField TxtUsuario;
    private JButton btnLogar;
    private JPanel PanelMain;

    public ScreenLogin(){
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setContentPane(PanelMain);
        setResizable(false);
        btnLogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txtUsuario = TxtUsuario.getText();
                String txtSenha = String.valueOf(TxtSenha.getPassword());
                if(txtUsuario.equals("admin") && txtSenha.equals("admin")){
                    dispose();
                    ScreenSelect screenSelect = new ScreenSelect();
                    return;
                }
                JOptionPane.showMessageDialog(null, "Login ou Senha Incorreto! Tente Novamente!");
            }
        });
    }
}

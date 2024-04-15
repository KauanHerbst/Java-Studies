package br.herbst.screen.clientes;



import br.herbst.dao.IMainDao;
import br.herbst.dao.MainDao;
import br.herbst.domain.Cliente;
import br.herbst.domain.creators.CreatorCliente;
import br.herbst.domain.creators.ICreatorCliente;
import br.herbst.screen.select.ScreenSelect;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Locale;

public class ScreenClientes extends JFrame {
    private JPanel PainelMain;
    private JLabel HeadClientes;
    private JLabel LbNome;
    private JTextField TxtNome;
    private JLabel LbIdade;
    private JTextField TxtIdade;
    private JLabel LbCpf;
    private JTextField TxtCpf;
    private JLabel LbEstado;
    private JTextField TxtEstado;
    private JTable TableDados;
    private JButton btnCadastrar;
    private JButton btnExcluir;
    private JButton btnAtualizar;
    private JButton btnLimpar;
    private JButton btnMenu;
    private DefaultTableModel tableModel = new DefaultTableModel();

    private ICreatorCliente iCreatorCliente = new CreatorCliente();

    private IMainDao mainDao = new MainDao();

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
                if (isCamposValidos()) {
                    JOptionPane.showMessageDialog(null, "Campos Invalidos! Complete todos os campos");
                }
                try {
                    String nome = TxtNome.getText();
                    Integer idade = Integer.parseInt(TxtIdade.getText());
                    Long cpf = Long.parseLong(TxtCpf.getText());
                    String estado = TxtEstado.getText();
                    Cliente cliente = (Cliente) mainDao.cadastrar(iCreatorCliente.criarCliente(nome, idade, cpf, estado));
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Cliente Cadastrado!");
                    adicionarClienteTabela(cliente);
                } catch (NumberFormatException ex) {
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
                if (!(row >= 0)) {
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
                Cliente clientRow = construirClienteRow(row);
                Cliente cliente = (Cliente) mainDao.buscar(clientRow);
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
                if (row >= 0) {
                    int option = JOptionPane.showConfirmDialog(null, "Deseja Atualizar esse cliente?", "Atualizar Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        String nome = TxtNome.getText();
                        Integer idade = Integer.parseInt(TxtIdade.getText());
                        Long cpf = Long.parseLong(TxtCpf.getText());
                        String estado = TxtEstado.getText();
                        Cliente clienteNew = iCreatorCliente.criarCliente(nome, idade, cpf, estado);
                        clienteNew.setId(getId(row));
                        mainDao.atualizar(clienteNew);
                        JOptionPane.showMessageDialog(null, "Cliente Atualizado");
                        tableModel.removeRow(row);
                        adicionarClienteTabela((Cliente) mainDao.buscar(clienteNew));
                    }
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente!");
                }

            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = TableDados.getSelectedRow();
                if (row >= 0) {
                    int option = JOptionPane.showConfirmDialog(null, "Deseja Excluir esse cliente?", "Excluir Cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        Long cpf = Long.parseLong(TxtCpf.getText());
                        Cliente cliente = construirClienteRow(row);
                        mainDao.remover(cliente);
                        JOptionPane.showMessageDialog(null, "Cliente Excluido!");
                        tableModel.removeRow(row);
                    }
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um cliente!");
                }

            }
        });
    }

    public Boolean isCamposValidos() {
        if (TxtNome.getText().equals("") && TxtIdade.getText().equals("") && TxtCpf.getText().equals("") && TxtEstado.getText().equals("")) {
            return true;
        }
        return false;
    }

    public void limparCampos() {
        TxtNome.setText("");
        TxtIdade.setText("");
        TxtCpf.setText("");
        TxtEstado.setText("");
        TxtCpf.setEditable(true);

    }

    public Cliente construirClienteRow(int row) {
        Long clienteId = (Long) TableDados.getValueAt(row, 0);
        String clientNome = (String) TableDados.getValueAt(row, 1);
        Integer clienteIdade = (Integer) TableDados.getValueAt(row, 2);
        Long clienteCpf = (Long) TableDados.getValueAt(row, 3);
        String clienteEstado = (String) TableDados.getValueAt(row, 4);

        Cliente cliente = iCreatorCliente.criarCliente(clientNome, clienteIdade, clienteCpf, clienteEstado);
        cliente.setId(clienteId);
        return cliente;
    }

    public Long getId(int row) {
        return (Long) TableDados.getValueAt(row, 0);
    }

    public void voltarMenu() {
        dispose();
        new ScreenSelect();
    }

    public void initTable() {
        tableModel.addColumn("Id");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Idade");
        tableModel.addColumn("CPF");
        tableModel.addColumn("Estado");
        TableDados.setModel(tableModel);
        TableDados.setTableHeader(new JTableHeader(TableDados.getColumnModel()));
    }

    public void buscasDadosTabela() {
        List<Cliente> clienteArrayList = (List<Cliente>) mainDao.buscarTodos(new Cliente());
        clienteArrayList.forEach((Cliente cliente) -> {
            adicionarClienteTabela(cliente);
        });
    }

    public void adicionarClienteTabela(Cliente cliente) {
        tableModel.addRow(new Object[]{cliente.getId(), cliente.getNome(), cliente.getIdade(), cliente.getCpf(), cliente.getEstado()});
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        PainelMain = new JPanel();
        PainelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 12, new Insets(20, 20, 20, 20), -1, -1));
        PainelMain.setBackground(new Color(-14079703));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        PainelMain.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 11, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        LbNome = new JLabel();
        LbNome.setForeground(new Color(-1));
        LbNome.setText("Nome:");
        PainelMain.add(LbNome, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TxtNome = new JTextField();
        TxtNome.setBackground(new Color(-11579569));
        TxtNome.setForeground(new Color(-1));
        TxtNome.setText("");
        PainelMain.add(TxtNome, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        LbCpf = new JLabel();
        LbCpf.setForeground(new Color(-1));
        LbCpf.setText("CPF:");
        PainelMain.add(LbCpf, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TxtCpf = new JTextField();
        TxtCpf.setBackground(new Color(-11579569));
        TxtCpf.setForeground(new Color(-1));
        PainelMain.add(TxtCpf, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        btnCadastrar = new JButton();
        btnCadastrar.setBackground(new Color(-11579569));
        btnCadastrar.setForeground(new Color(-1));
        btnCadastrar.setText("Cadastrar");
        PainelMain.add(btnCadastrar, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnAtualizar = new JButton();
        btnAtualizar.setBackground(new Color(-11579569));
        btnAtualizar.setForeground(new Color(-1));
        btnAtualizar.setText("Atualizar");
        PainelMain.add(btnAtualizar, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        HeadClientes = new JLabel();
        Font HeadClientesFont = this.$$$getFont$$$(null, -1, 24, HeadClientes.getFont());
        if (HeadClientesFont != null) HeadClientes.setFont(HeadClientesFont);
        HeadClientes.setForeground(new Color(-1));
        HeadClientes.setText("Clientes");
        PainelMain.add(HeadClientes, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        PainelMain.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 12, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        TableDados = new JTable();
        TableDados.setBackground(new Color(-11579569));
        TableDados.setForeground(new Color(-1));
        scrollPane1.setViewportView(TableDados);
        LbIdade = new JLabel();
        LbIdade.setForeground(new Color(-1));
        LbIdade.setText("Idade:");
        PainelMain.add(LbIdade, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        LbEstado = new JLabel();
        LbEstado.setForeground(new Color(-1));
        LbEstado.setText("Estado:");
        PainelMain.add(LbEstado, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHEAST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TxtIdade = new JTextField();
        TxtIdade.setBackground(new Color(-11579569));
        TxtIdade.setForeground(new Color(-1));
        PainelMain.add(TxtIdade, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        TxtEstado = new JTextField();
        TxtEstado.setBackground(new Color(-11579569));
        TxtEstado.setForeground(new Color(-1));
        TxtEstado.setText("");
        PainelMain.add(TxtEstado, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        btnExcluir = new JButton();
        btnExcluir.setBackground(new Color(-11579569));
        btnExcluir.setForeground(new Color(-1));
        btnExcluir.setText("Excluir");
        PainelMain.add(btnExcluir, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnLimpar = new JButton();
        btnLimpar.setBackground(new Color(-11579569));
        btnLimpar.setForeground(new Color(-1));
        btnLimpar.setText("Limpar");
        PainelMain.add(btnLimpar, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnMenu = new JButton();
        btnMenu.setBackground(new Color(-11579569));
        btnMenu.setForeground(new Color(-1));
        btnMenu.setText("Voltar Menu");
        PainelMain.add(btnMenu, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return PainelMain;
    }
}

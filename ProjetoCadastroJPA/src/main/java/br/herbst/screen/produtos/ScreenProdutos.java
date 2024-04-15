package br.herbst.screen.produtos;



import br.herbst.dao.IMainDao;
import br.herbst.dao.MainDao;
import br.herbst.domain.Produto;
import br.herbst.domain.creators.CreatorProduto;
import br.herbst.domain.creators.ICreatorProduto;
import br.herbst.screen.select.ScreenSelect;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Locale;

public class ScreenProdutos extends JFrame {
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

    private IMainDao mainDao = new MainDao();

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
                    if (isCamposValidos()) {
                        JOptionPane.showMessageDialog(null, "Campos Invalidos! Complete todos os campos");
                    }
                    String nome = TxtNome.getText();
                    Integer estoque = Integer.parseInt(TxtEstoque.getText());
                    Double preco = Double.parseDouble(TxtPreco.getText());
                    Produto produto = iCreatorProduto.criarProduto(nome, estoque, preco);
                    produto = (Produto) mainDao.cadastrar(produto);
                    limparCampos();
                    JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
                    adicionarProdutoTabela(produto);
                } catch (Exception ex) {
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
                Produto produto = construirProdutoRow(row);
                TxtNome.setText(produto.getNome());
                TxtEstoque.setText(produto.getEstoque().toString());
                TxtPreco.setText(produto.getValor().toString());
            }
        });
        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = TableDados.getSelectedRow();
                if (row >= 0) {
                    int option = JOptionPane.showConfirmDialog(null, "Deseja excluir o esse produto?", "Excluir Produto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        Produto produto = construirProdutoRow(row);
                        mainDao.remover(produto);
                        JOptionPane.showMessageDialog(null, "Produto Excluido!");
                        tableModel.removeRow(row);
                    }
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Produto!");
                }
            }
        });
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = TableDados.getSelectedRow();
                if (row >= 0) {
                    int option = JOptionPane.showConfirmDialog(null, "Deseja atualizar esse produto?", "Excluir Produto", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (option == JOptionPane.YES_OPTION) {
                        String nome = TxtNome.getText();
                        Integer estoque = Integer.parseInt(TxtEstoque.getText());
                        Double preco = Double.parseDouble(TxtPreco.getText());
                        Produto produtoNew = iCreatorProduto.criarProduto(nome, estoque, preco);
                        produtoNew.setId(getId(row));
                        mainDao.atualizar(produtoNew);
                        JOptionPane.showMessageDialog(null, "Produto Atualizado!");
                        tableModel.removeRow(row);
                        adicionarProdutoTabela(produtoNew);

                    }
                    limparCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um Produto!");
                }
            }
        });
    }

    public Long getId(int row) {
        return (Long) TableDados.getValueAt(row, 0);
    }

    public void limparCampos() {
        TxtNome.setText("");
        TxtEstoque.setText("");
        TxtPreco.setText("");
        TxtNome.setEditable(true);
    }

    public Boolean isCamposValidos() {
        if (TxtNome.getText().equals("") && TxtEstoque.getText().equals("") && TxtPreco.getText().equals("")) {
            return true;
        }
        return false;
    }

    public void adicionarProdutoTabela(Produto produto) {
        tableModel.addRow(new Object[]{produto.getId(), produto.getNome(), produto.getEstoque(), produto.getValor()});
    }


    public void initTable() {
        tableModel.addColumn("Id");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Estoque");
        tableModel.addColumn("Preço");

        TableDados.setModel(tableModel);
    }

    public void buscarProdutosDB() {
        ArrayList<Produto> produtoArrayList = new ArrayList<>();
        //produtoArrayList = MainService.retornarProdutos();
        produtoArrayList.forEach((Produto pro) -> {
            adicionarProdutoTabela(pro);
        });

    }

    public Produto construirProdutoRow(int row) {
        Long produtoId = (Long) TableDados.getValueAt(row, 0);
        String produtoNome = (String) TableDados.getValueAt(row, 1);
        Integer produtoEstoque = (Integer) TableDados.getValueAt(row, 2);
        Double produtoValor = (Double) TableDados.getValueAt(row, 3);


        Produto produto = iCreatorProduto.criarProduto(produtoNome, produtoEstoque, produtoValor);
        produto.setId(produtoId);
        return produto;
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
        PainelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(5, 7, new Insets(20, 20, 20, 20), -1, -1));
        PainelMain.setBackground(new Color(-14079703));
        HeadeProdutos = new JLabel();
        Font HeadeProdutosFont = this.$$$getFont$$$(null, -1, 24, HeadeProdutos.getFont());
        if (HeadeProdutosFont != null) HeadeProdutos.setFont(HeadeProdutosFont);
        HeadeProdutos.setForeground(new Color(-1));
        HeadeProdutos.setText("Produtos");
        PainelMain.add(HeadeProdutos, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 7, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTH, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        PainelMain.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(1, 6, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        LbNome = new JLabel();
        LbNome.setBackground(new Color(-1));
        LbNome.setForeground(new Color(-1));
        LbNome.setText("Nome:");
        PainelMain.add(LbNome, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TxtNome = new JTextField();
        TxtNome.setBackground(new Color(-11579569));
        TxtNome.setForeground(new Color(-1));
        PainelMain.add(TxtNome, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        LbEstoque = new JLabel();
        LbEstoque.setBackground(new Color(-1));
        LbEstoque.setForeground(new Color(-1));
        LbEstoque.setText("Estoque:");
        PainelMain.add(LbEstoque, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TxtEstoque = new JTextField();
        TxtEstoque.setBackground(new Color(-11579569));
        TxtEstoque.setForeground(new Color(-1));
        TxtEstoque.setText("");
        PainelMain.add(TxtEstoque, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        LbPreco = new JLabel();
        LbPreco.setBackground(new Color(-1));
        LbPreco.setForeground(new Color(-1));
        LbPreco.setText("Preço:");
        PainelMain.add(LbPreco, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        TxtPreco = new JTextField();
        TxtPreco.setBackground(new Color(-11579569));
        TxtPreco.setForeground(new Color(-1));
        PainelMain.add(TxtPreco, new com.intellij.uiDesigner.core.GridConstraints(1, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_NORTHWEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        btnAtualizar = new JButton();
        btnAtualizar.setBackground(new Color(-11579569));
        btnAtualizar.setForeground(new Color(-1));
        btnAtualizar.setText("Atualizar");
        PainelMain.add(btnAtualizar, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        bntCadastar = new JButton();
        bntCadastar.setBackground(new Color(-11579569));
        bntCadastar.setForeground(new Color(-1));
        bntCadastar.setText("Cadastrar");
        PainelMain.add(bntCadastar, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnExcluir = new JButton();
        btnExcluir.setBackground(new Color(-11579569));
        btnExcluir.setForeground(new Color(-1));
        btnExcluir.setText("Excluir");
        PainelMain.add(btnExcluir, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnLimpar = new JButton();
        btnLimpar.setBackground(new Color(-11579569));
        btnLimpar.setForeground(new Color(-1));
        btnLimpar.setText("Limpar");
        PainelMain.add(btnLimpar, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnMenu = new JButton();
        btnMenu.setBackground(new Color(-11579569));
        btnMenu.setForeground(new Color(-1));
        btnMenu.setText("Voltar Menu");
        PainelMain.add(btnMenu, new com.intellij.uiDesigner.core.GridConstraints(2, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        PainelMain.add(scrollPane1, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 6, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        TableDados = new JTable();
        TableDados.setBackground(new Color(-11579569));
        TableDados.setForeground(new Color(-1));
        scrollPane1.setViewportView(TableDados);
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

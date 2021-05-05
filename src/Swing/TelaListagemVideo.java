package Swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Video;


public class TelaListagemVideo  extends JFrame{
    private JFrame frmListar;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton button;

    public TelaListagemVideo() {
        initialize();
    }
    private void initialize() {
        frmListar = new JFrame();
        frmListar.setTitle("Listar");
        frmListar.setBounds(100, 100, 505, 323);
        frmListar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frmListar.getContentPane().setLayout(null);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(44, 33, 409, 116);
        frmListar.getContentPane().add(scrollPane);

        table = new JTable();

        table.setGridColor(Color.BLACK);
        table.setRequestFocusEnabled(false);
        table.setFocusable(false);
        table.setBackground(Color.YELLOW);
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(true);
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        scrollPane.setViewportView(table);
        table.setBorder(new LineBorder(new Color(0, 0, 0)));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"", "", ""}
        ));
        table.setShowGrid(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        button = new JButton("Listar videos");
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(new Font("Tahoma", Font.PLAIN, 12));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Link");
                    model.addColumn("Nome");

                    List<Video> list = Fachada.listarVideos();
                    for (Video v : list)
                        for (Assunto a : v.getAssuntos())
                            model.addRow(new Object[]{v.getlink(), v.getNome()});

                    table.setModel(model);
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(frmListar, erro.getMessage());
                }
            }
        });
        button.setBounds(44, 172, 200, 23);
        frmListar.getContentPane().add(button);
        frmListar.setVisible(true);
    }
}
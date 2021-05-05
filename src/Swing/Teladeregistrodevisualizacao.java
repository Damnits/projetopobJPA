package Swing;

import fachada.Fachada;
import modelo.Assunto;
import modelo.Video;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Teladeregistrodevisualizacao extends JFrame {


    private JPanel contentPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel lblTextos;
    private JButton btnRegistrar;
    private JLabel lblmsg;

    public Teladeregistrodevisualizacao() {
        initialize();
    }

    private void initialize() {

        setTitle("Registrar Visualização");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0,0,400,300);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
//---------------------------LINK----------------------
        lblTextos = new JLabel("Link Video");
        lblTextos.setBounds(10,14,100,14);
        contentPanel.add(lblTextos);

        textField1 = new JTextField();
        textField1.setBounds(150,11,200,20);
        contentPanel.add(textField1);
        textField1.setColumns(10);
//----------------------------EMAIL--------------------
        lblTextos = new JLabel("Email");
        lblTextos.setBounds(10,44,100,14);
        contentPanel.add(lblTextos);

        textField2 = new JTextField();
        textField2.setBounds(150,41,200,20);
        contentPanel.add(textField2);
        textField2.setColumns(10);
//-----------------------------NOTA---------------------------
        lblTextos = new JLabel("Nota");
        lblTextos.setBounds(10, 74,150,14);
        contentPanel.add(lblTextos);

        textField3 = new JTextField();
        textField3.setBounds(150, 71,200,20);
        contentPanel.add(textField3);
        textField3.setColumns(10);
        //----------------------BOTÃO-----------------------
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty()){
                        lblmsg.setText("Algum campo está vazio");
                    }
                    else{
                        String link = textField1.getText();
                        String email = textField2.getText();
                        String nota = textField3.getText();
                        int nota1 = Integer.parseInt(nota);
                        Fachada.registrarVisualizacao(link, email, nota1);
                        lblmsg.setText("Visualização Registrada");
                        textField1.setText("");
                        textField1.requestFocus();
                        textField2.setText("");
                        textField2.requestFocus();
                        textField3.setText("");
                        textField3.requestFocus();
                    }


                }
                catch (Exception erro){
                    lblmsg.setText(erro.getMessage());
                }
            }
        });
        btnRegistrar.setBounds(150,100,200,20);
        contentPanel.add(btnRegistrar);

        lblmsg = new JLabel("");
        lblmsg.setBounds(10,130,200,20);
        contentPanel.add(lblmsg);
    }
}

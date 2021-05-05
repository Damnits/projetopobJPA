package Swing;

import fachada.Fachada;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastrarVideo extends JFrame {

    private JPanel contentPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel lblTextos;
    private JButton btnCadastrar;
    private JLabel lblmsg;
    public TelaCadastrarVideo(){
        setTitle("Cadastrar Video");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0,0,400,300);

        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);
//---------------------------CADASTRO----------------------
        lblTextos = new JLabel("Link Cadastro");
        lblTextos.setBounds(10,14,100,14);
        contentPanel.add(lblTextos);

        textField1 = new JTextField();
        textField1.setBounds(150,11,200,20);
        contentPanel.add(textField1);
        textField1.setColumns(10);
//----------------------------VIDEO--------------------
        lblTextos = new JLabel("Nome do vídeo");
        lblTextos.setBounds(10,44,100,14);
        contentPanel.add(lblTextos);

        textField2 = new JTextField();
        textField2.setBounds(150,41,200,20);
        contentPanel.add(textField2);
        textField2.setColumns(10);
//-----------------------------ASSUNTO---------------------------
        lblTextos = new JLabel("Nome do assunto");
        lblTextos.setBounds(10, 74,150,14);
        contentPanel.add(lblTextos);

        textField3 = new JTextField();
        textField3.setBounds(150, 71,200,20);
        contentPanel.add(textField3);
        textField3.setColumns(10);
        //----------------------BOTÃO-----------------------
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    if (textField1.getText().isEmpty() || textField2.getText().isEmpty()){
                        lblmsg.setText("Campo Video ou link vazio");
                    }
                    else{
                        String link = textField1.getText();
                        String video = textField2.getText();
                        String assunto = textField3.getText();
                        Fachada.cadastrarVideo(link, video, assunto);
                        lblmsg.setText("Link Cadastrado");
                        textField1.setText("");
                        textField1.requestFocus();
                        textField2.setText("");
                        textField2.requestFocus();
                        textField3.setText("");
                        textField3.requestFocus();
                    }


                }
                catch (Exception msg){
                    lblmsg.setText(msg.getMessage());
                }
            }
        });
        btnCadastrar.setBounds(150,100,200,20);
        contentPanel.add(btnCadastrar);

        lblmsg = new JLabel("");
        lblmsg.setBounds(10,130,200,20);
        contentPanel.add(lblmsg);
    }
}

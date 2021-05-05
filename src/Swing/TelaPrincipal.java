package Swing;

import Swing.Teladeregistrodevisualizacao;
import fachada.Fachada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaPrincipal  {
    private JFrame frame;
    private JLabel label;

    //BOTÕES
    private JButton btnCadastrarVideo;
    private JButton btnCadastrarVisualizacao;
    private JButton btnListarVideo;
    private JButton btnListarVisualizacao;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaPrincipal window = new TelaPrincipal();
                    window.frame.setLocationRelativeTo(null);
                    window.frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public TelaPrincipal(){
        initialize();
    }


    private void initialize() {
        frame = new JFrame();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent arg0) {
                frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                Fachada.inicializar();

                frame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void windowClosing(WindowEvent e) {
                Fachada.finalizar();
                JOptionPane.showMessageDialog(frame, "banco fechado !");
            }
        });
        frame.setResizable(false);
        frame.setTitle("Link");

        frame.setBounds(0,0,300,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //-----------MENU----------------------
        btnCadastrarVideo = new JButton("Cadastrar vídeo");
        btnCadastrarVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    TelaCadastrarVideo cv = new TelaCadastrarVideo();
                    cv.setLocationRelativeTo(null);
                    cv.setVisible(true);
                }
                catch (Exception a){
                    System.out.println("Deu ruim"+ a);

                }

            }
        });
        btnCadastrarVideo.setBounds(40,60,200,20);
        frame.add(btnCadastrarVideo);
        btnCadastrarVisualizacao = new JButton("Cadastrar Visualizacão");
        btnCadastrarVisualizacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Teladeregistrodevisualizacao trv = new Teladeregistrodevisualizacao();
                    trv.setLocationRelativeTo(null);
                    trv.setVisible(true);
                }
                catch (Exception a){
                    System.out.println("Deu ruim"+ a);

                }

            }
        });
        btnCadastrarVisualizacao.setBounds(40,100,200,20);
        frame.add(btnCadastrarVisualizacao);


        btnListarVideo = new JButton("Listar video");
        btnListarVideo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    TelaListagemVideo lv = new TelaListagemVideo();
                    lv.setLocationRelativeTo(null);
                    lv.setVisible(true);

                }
                catch (Exception a){
                    System.out.println("Deu ruim"+ a);

                }

            }
        });
        btnListarVideo.setBounds(40,140,200,20);
        frame.add(btnListarVideo);



        btnListarVisualizacao = new JButton("Listar visualizacao");
        btnListarVisualizacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    TelaListagemVisualizacao tlv = new TelaListagemVisualizacao();
                    tlv.setLocationRelativeTo(null);
                    tlv.setVisible(true);

                }
                catch (Exception a){
                    System.out.println("Deu ruim"+ a);

                }

            }
        });
        btnListarVisualizacao.setBounds(40,180,200,20);
        frame.add(btnListarVisualizacao);
    }
}

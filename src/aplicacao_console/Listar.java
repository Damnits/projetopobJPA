package aplicacao_console;

import fachada.Fachada;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Listar {
    public Listar(){
        Fachada.inicializar();
        try {
            System.out.println("Listando");
            for(Video v :Fachada.listarVideos()){
                System.out.println(v);
            }
            for(Visualizacao vi :Fachada.listarVisualizacao() ) {
                System.out.println(vi);
            }
            System.out.println("Listado");
            Fachada.listarUsuario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Fachada.finalizar();
    }

    public static void main(String[] args) {
        new Listar();
    }
}

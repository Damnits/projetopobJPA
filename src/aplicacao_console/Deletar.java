package aplicacao_console;

import daojpa.DAO;
import fachada.Fachada;

public class Deletar {
    public Deletar(){
        Fachada.inicializar();
        try {
            System.out.println("Deletando");

            Fachada.apagarVisualizacao(4);
            Fachada.apagarVisualizacao(5);

            System.out.println();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Fachada.finalizar();
        System.out.println("fim do programa");
    }

    public static void main(String[] args) {
        new Deletar();
    }
}
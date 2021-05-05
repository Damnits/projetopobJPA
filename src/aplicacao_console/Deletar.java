package aplicacao_console;

import fachada.Fachada;

public class Deletar {
    public Deletar(){
        Fachada.inicializar();
        try {
            System.out.println("Deletando");

            Fachada.apagarVisualizacao(1);
            Fachada.apagarVisualizacao(2);
            Fachada.apagarVisualizacao(3);

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
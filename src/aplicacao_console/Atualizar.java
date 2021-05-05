package aplicacao_console;

import fachada.Fachada;

public class Atualizar {
    public Atualizar(){

        Fachada.inicializar();

        try {
            System.out.println("Alterando");
            Fachada.alterarTituloVideo("*", "Titulo alterado");
            Fachada.alterarAssunto("**", "Assunto alterado");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Fachada.finalizar();

        System.out.println("fim do programa");
    }

    public static void main(String[] args) {
        new Atualizar();
    }
}
package aplicacao_console;

import fachada.Fachada;
import modelo.Video;

public class Cadastrar {
	public Cadastrar() {
	try{
		System.out.println("Cadastrando");
		Fachada.inicializar();
		/*	Video  */

		Fachada.cadastrarVideo("youtube.com/resenha","videos engraçados","engraçado");
		Fachada.cadastrarVideo("youtube.com/lol","Campeonato Cblol","lol");
		Fachada.cadastrarVideo("youtube.com/fausto","Aprendendo Java","java");


		/*	Visualizações 	*/

		Fachada.registrarVisualizacao("youtube.com/resenha","Test3@ifpb.com", 1);
		Fachada.registrarVisualizacao("youtube.com/lol","pablo@ifpb.com",5);
		Fachada.registrarVisualizacao("youtube.com/fausto","hidekazuo@ifpb.com",3);

	} catch (Exception e) 	{
		System.out.println(e.getMessage());
	} finally {
		Fachada.finalizar();
	}
		System.out.println("fim do programa");
}
	public static void main(String[] args) {
		
		new Cadastrar();
	}

}

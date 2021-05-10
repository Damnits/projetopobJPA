package fachada;

import daojpa.*;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

import java.util.List;

public class Fachada {
	private static DAOVideo daovideo = new DAOVideo();
	private static DAOAssunto daoassunto = new DAOAssunto();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();
	private static DAOUsuario daousuario = new DAOUsuario();

	public static void inicializar() {
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}	
	public static Video cadastrarVideo(String link, String nome, String palavra) throws Exception {
		DAO.begin();
		Video v = daovideo.read(link);
		if(v != null) {
			DAO.rollback();
			throw new Exception("Link cadastrado: " + link);
		}
		v = new Video(link, nome);
		Assunto a = daoassunto.read(palavra);
		if(a == null) {
			a = new Assunto(palavra);
		}
		a.adicionar(v);
		v.adicionar(a);
		daovideo.create(v);
		daoassunto.update(a);
		DAO.commit();
		return v;
	}
	
	public static void adicionarAssunto(Video link, String palavra) throws Exception{
		DAO.begin();
		Video v = daovideo.read(link);
		if(v == null) {
			DAO.rollback();
			throw new Exception("Link inexistente: " + link);
		}
		Assunto a = daoassunto.read(palavra);
		if(a != null) {
			DAO.rollback();
			throw new Exception("Assunto j� existente");
		}
		a = new Assunto(palavra);
		a.adicionar(link);
		daoassunto.create(a);
		DAO.commit();
	}
	public static Visualizacao registrarVisualizacao(String link, String email, int nota)throws Exception{
		DAO.begin();
		Video video = daovideo.read(link);
		if (video == null){
			DAO.rollback();
			throw new Exception("Video não encontrado!");
		}
		Usuario usuario = daousuario.read(email);
		if(usuario==null) {
			usuario = new Usuario(email);
			daousuario.create(usuario);
		}
		Visualizacao v = new Visualizacao(nota, usuario, video);
		usuario.adicionar(v);
		video.adicionar(v);
		video.atualizarMedia();
		daousuario.update(usuario);
		daovideo.update(video);
		daovisualizacao.create(v);
		DAO.commit();
		return v;
	}

	public static void apagarVisualizacao(int id)throws Exception{
		DAO.begin();
		Visualizacao vis = daovisualizacao.read(id);
		if(vis==null){
			DAO.rollback();
			throw new Exception("Id não existente");
		}
		daovisualizacao.delete(vis);
		DAO.commit();
	}

	public Visualizacao localizarVisualizacao(int id)throws Exception{
		Visualizacao v = daovisualizacao.read(id);
		if(v == null){
			throw new Exception("Visualização não encontrada!");
		}
		return v;
	}
	public static List<Video> consultarVideosPorAssunto(String palavra){
		if (palavra.isEmpty())
			return daovideo.readAll();
		else
			return daovideo.consultarVideosPorAssunto(palavra);

	}
	public static List<Video> consultarVideoPorUsuario(String email){
		if (email.isEmpty())
			return daovideo.readAll();
		else
			return daovideo.consultarVideosPorUsuario(email);
	}
	public static List<Usuario> consultarUsuariosPorVideo(String link){
		if(link.isEmpty())
			return daousuario.readAll();
		else
			return daousuario.consultarUsuarioVideo(link);
	}
	public static List<Visualizacao> listarVisualizacao(){
		return daovisualizacao.readAll();
	}
	public static List<Video> listarVideos(){return daovideo.readAll();}
	public static List<Usuario> listarUsuario(){return daousuario.readAll();}
	public static int maiorId(String usuario){
		List<Visualizacao> visualizacoes = daovisualizacao.readAll();
		int maior = 0;
		if(visualizacoes.isEmpty()){
			return maior;
		}
		for(Visualizacao v : visualizacoes){
			if(v.getId()>maior);
				maior = v.getId();
		}
		return maior;
	}
	public static void alterarTituloVideo(String titulo, String novotitulo) throws Exception{
		DAO.begin();
		Video v = daovideo.read(titulo);
		if (v==null) {
			DAO.rollback();
			throw new Exception("Alterar titulo do Video - video inexistente:" + titulo);
		}
		v.setNome(novotitulo);
		daovideo.update(v);
		DAO.commit();
	}

	public static void alterarAssunto(String assunto, String novoassunto) throws Exception{
		DAO.begin();
		if (daoassunto.read(novoassunto)!=null){
			DAO.rollback();
			throw new Exception("Assunto novo já existente");
		}
		Assunto a = daoassunto.read(assunto);
		if (a==null) {
			DAO.rollback();
			throw new Exception("Alterar Assunto do Video - Assunto inexistente:" + assunto);
		}
		a.setPalavra(novoassunto);
		daoassunto.update(a);
		DAO.commit();
	}

}

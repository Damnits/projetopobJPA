package modelo;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Video {
	@Id
	private String link;
	@Column
	private String nome;
	@Column
	private double media;
	@ManyToMany
	private List<Assunto> assuntos = new ArrayList<>();
	@OneToMany
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	public List<Visualizacao> getVisualizacoes() {
		return visualizacoes;
	}

	public Video(){}
	public Video(String link, String nome) {
		this.link = link;
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public void adicionar(Visualizacao vis) {
		visualizacoes.clear();
		visualizacoes.add(vis);
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getlink() {
		return link;
	}
	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	@Override
	public String toString() {
		String texto = "Video [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "media="+ getMedia();
		
		texto+=", assuntos=";
		for(Assunto a : assuntos) {
			texto += a;
		}
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		return texto;
	}



}

package modelo;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Video20181370044")
@Cacheable(false)
public class Video {
	@Id
	@Column
	private String link;
	@Column
	private String nome;
	@Column
	private double media;
	@Version
	private int versao;
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Assunto> assuntos = new ArrayList<>();
	@OneToMany(mappedBy = "video",
					cascade = {CascadeType.ALL},
					orphanRemoval = true,
					fetch = FetchType.EAGER)
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
	public void atualizarMedia() {
		if(this.getVisualizacoes().isEmpty()){
			this.setMedia(0);
		}
		else{
			int soma = 0;
			for(Visualizacao v : this.getVisualizacoes()){
				soma += v.getnota();
			}
			this.setMedia(soma/this.visualizacoes.size());
		}

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

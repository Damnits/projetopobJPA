package modelo;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Assunto {
	@Id
	@Column
	private String palavra;
	@ManyToMany
	private List<Video> videos = new ArrayList<>();

	public Assunto(){}
	public Assunto(String palavra){
		this.palavra = palavra;
	}

	public String getPalavra() {
		return palavra;
	}

	public void adicionar(Video v) {
		videos.add(v);
	}

	@Override
	public String toString() {
		String texto = "Assunto :" + palavra;
		return texto;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
}


package modelo;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Assunto20181370044")

@Cacheable(false)
public class Assunto {
	@Id
	private String palavra;
	@ManyToMany(mappedBy="assuntos",
			cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private List<Video> videos = new ArrayList<>();
	@Version
	private int versao;
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


package modelo;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Usuario20181370044")
@Cacheable(false)
public class Usuario {
	@Id
	private String email;
	@Version
	private int versao;
	@OneToMany(mappedBy = "usuario",
					cascade = {CascadeType.MERGE, CascadeType.PERSIST},
					orphanRemoval = true,
					fetch = FetchType.EAGER)
	private List<Visualizacao> visualizacoes = new ArrayList<>();
	public Usuario(){}
	public Usuario(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}

	@Override
	public String toString() {
		String texto =  email;
		
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		return texto;
	}
}


package modelo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Usuario {
	@Id
	private String email;
	@OneToMany
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


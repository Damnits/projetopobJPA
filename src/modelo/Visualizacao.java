package modelo;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
@Entity
public class Visualizacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "DATE")
	private String datahora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private int nota;
	@Transient
	private int idade;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Video video;

	public Visualizacao(){}
	public Visualizacao( int nota, Usuario usuario, Video video) {
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}

	public int getId() {
		return id;
	}

	public String getdatahora() {
		return datahora;
	}

	public Usuario getusuario() {
		return this.usuario;
	}

	public String getvideo() {
		return this.video.getlink();
	}

	public int getnota() {
		return this.nota;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


	@Override
	public String toString() {
		return "Visualizacao [id=" + id +
				", datahora=" + datahora +
				", nota=" + nota +
				"\n usuario=" + usuario.getEmail()+ ", video=" + video.getNome() + "]";
	}

}

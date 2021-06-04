package modelo;
import daojpa.TriggerListener;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "Visualizacao20181370044")
@EntityListeners(TriggerListener.class)
@Cacheable(false)
public class Visualizacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "DATE")
	private LocalDateTime datahora = LocalDateTime.now();
	private int nota;
	@Transient
	private int idade;
	@Version
	private int versao;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	private Usuario usuario;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
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

	public LocalDateTime getdatahora() {
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
				", idade"+ idade +
				"\n usuario=" + usuario.getEmail()+ ", video=" + video.getNome() + "]";
	}

}

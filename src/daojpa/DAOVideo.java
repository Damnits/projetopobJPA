package daojpa;

import java.util.List;
import modelo.Video;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class DAOVideo extends DAO<Video> {
	public Video read (Object chave) {
		try {
			String link = (String) chave;
			TypedQuery<Video> q = manager.createQuery("select p from Video p where p.link =: l", Video.class);
			q.setParameter("l", link);
			return q.getSingleResult();
		}catch (NoResultException e){
			return null;
		}
	}
	public List<Video> consultarVideosPorAssunto(String palavra){
		try {
			TypedQuery<Video> q = manager.createQuery("select p from Video p join p.assuntos a where a.palavra =: pa", Video.class);
			q.setParameter("pa", palavra);
			return q.getResultList();
		}catch(NoResultException e){
			return null;
		}
	}
	public List<Video> consultarVideosPorUsuario(String email){
		try {
			TypedQuery<Video> q = manager.createQuery("select p from Video p join p.visualizacoes vi join vi.usuario us where us.email =: e", Video.class);
			q.setParameter("e", email);
			return q.getResultList();
		}catch (NoResultException e){
			return null;
		}
	}
}

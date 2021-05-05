package daojpa;

import modelo.Usuario;



import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class DAOUsuario extends DAO<Usuario> {
    public Usuario read (Object chave){
    	try {
    		String email = (String) chave;
    		TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u where u.email =: e", Usuario.class);
    		q.setParameter("e", email);
    		return q.getSingleResult();
    	}catch(NoResultException e) {
    		return null;
    	}
    }
    
    public List<Usuario> consultarUsuarioVideo(String link){
    	try {
			TypedQuery<Usuario> q = manager.createQuery("select u from Usuario u join u.visualizacoes v join v.video vi where vi.link =: l", Usuario.class);
			q.setParameter("l", link);
			return q.getResultList();
    	}catch(NoResultException e ){
    		return null;
		}
    }

}


package daojpa;

import modelo.Usuario;
import modelo.Visualizacao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOVisualizacao extends DAO<Visualizacao> {
    public Visualizacao read (Object chave) {
        try {
            int visua = (int) chave;
            TypedQuery<Visualizacao> q = manager.createQuery("select p from Visualizacao p where p.id =: v", Visualizacao.class);
            q.setParameter("v",visua);
            return q.getSingleResult();
        }catch(NoResultException e ){
            return null;
        }
    }
    public List<Visualizacao> consultarVisualizacaoUsuario(String email){
        try{
            TypedQuery<Visualizacao>  q = manager.createQuery("select p from Visualizacao p join p.usuario u where u.email =: e", Visualizacao.class);
            q.setParameter("e", email);
            return q.getResultList();
        }catch(NoResultException e){
            return null;
        }
    }



}

package uy.com.cb.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import uy.com.cb.sga.domain.Usuario;

@Stateless 
public class UsuarioDaoImpl implements UsuarioDao{
    
    @PersistenceContext(unitName="SgaPU")
    EntityManager em;

    @Override
    public List<Usuario> findAllUsuarios() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    
    @Override
    public Usuario findUsuarioByUsername(Usuario usuario) {
        Query query = em.createQuery("from Usuario u where u.username =: username");
        query.setParameter("username", usuario.getUsername());
        return (Usuario) query.getSingleResult();
    }
    

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }
}

package usuario;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Maycon Spirlandelli
 */
@Stateless
public class UsuarioDAO {

   // Injected database connection:
    @PersistenceContext    
    private EntityManager em;
 
    public void gravar(Usuario usuario) {
        em.persist(usuario);
    }
    public void excluir(Usuario usuario) {        
        System.out.println("delecao ANTES");
        TypedQuery<Usuario> query = em.createQuery(
            "DELETE FROM Usuario u WHERE u.id = :p", Usuario.class);
        int deletedCount = query.setParameter("p", usuario.getId()).executeUpdate();
        System.out.println("delecao DEPOIS: " + deletedCount);
    }
    public void alterar(Usuario usuario) {
        //
    }
    
 
    // Retrieves all the guests:
    public List<Usuario> obterTodosUsuarios() {
        TypedQuery<Usuario> query = em.createQuery(
            "SELECT u FROM Usuario u ORDER BY u.id", Usuario.class);
        return query.getResultList();
    }
}

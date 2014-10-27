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

    public void cadastrar(Usuario usuario) {
        em.persist(usuario);
    }

    public void excluir(int idUsuario) {
        System.out.println("delecao ANTES");
        TypedQuery<Usuario> query = em.createQuery(
                "DELETE FROM Usuario u WHERE u.id = :p", Usuario.class);
        //int deletedCount = query.setParameter("p", usuario.getId()).executeUpdate();
        int deletedCount = query.setParameter("p", idUsuario).executeUpdate();
        System.out.println("delecao DEPOIS: " + deletedCount);
    }

    public void alterar(Usuario usuario) {
//        TypedQuery<Usuario> query = em.createQuery(
//            "UPDATE Usuario u SET u.nome = :p, u.cpf = :w, u.mac = :z WHERE u.id = :y", Usuario.class);
//       query.setParameter("p", usuario.getNome());
//        query.setParameter("w", usuario.getCpf());
//        query.setParameter("z", usuario.getMac());
//        query.setParameter("y", usuario.getId());
//        int updateCount = query.executeUpdate();

        TypedQuery<Usuario> query = em.createQuery(
                "UPDATE Usuario u SET u.nome = '" + usuario.getNome() + "', u.cpf = '" + usuario.getCpf() + "', u.mac = '" + usuario.getMac() + "' WHERE u.id = " + usuario.getId(), Usuario.class);

        int updateCount = query.executeUpdate();

        System.out.println("update DEPOIS: " + updateCount);
    }

    public Usuario obterUsuarioPorId(Integer id) {
        Usuario usuario = em.find(Usuario.class, id);
        if (usuario != null) {
            System.out.println("usuario nao nulo.");
        }
        return usuario;
    }

    public List<Usuario> obterTodosUsuarios() {
        TypedQuery<Usuario> query = em.createQuery(
                "SELECT u FROM Usuario u ORDER BY u.id", Usuario.class);
        return query.getResultList();
    }
}

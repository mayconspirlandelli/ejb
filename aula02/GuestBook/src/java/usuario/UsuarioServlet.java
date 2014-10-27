package usuario;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Maycon Spirlandelli
 */
@WebServlet(name = "UsuarioServlet", urlPatterns = {"/usuario"})
public class UsuarioServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB
    UsuarioDAO usuarioDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("get");
        String acao = request.getParameter("acao");

        System.out.println("ação: " + acao);

        if (acao != null && !acao.isEmpty()) {
            if (acao.equalsIgnoreCase("cadastrar")) {
                System.out.println("cadastrar");
                cadastrar(request, response);
            } else if (acao.equalsIgnoreCase("atualizar")) {
                System.out.println("atualizar");
                alterar(request, response);
            } else if (acao.equalsIgnoreCase("salvarAlteracao")) {
                System.out.println("salvarAlteracao");
                salvarAlteracao(request, response);
            } else if (acao.equalsIgnoreCase("excluir")) {
                System.out.println("excluir");
                excluir(request, response);
            } else if (acao.equalsIgnoreCase("listar")) {
                System.out.println("listar");
                listar(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("post");
        doGet(request, response);
    }

    private Usuario obterUsuarioDaRequisicao(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String mac = request.getParameter("mac");
        String id = request.getParameter("id");

        Usuario usuario = null;
        if (validarDados(nome, cpf, mac)) {
            usuario = new Usuario(nome, cpf, mac);
        }
        return usuario;
    }

    private Usuario obterUsuarioPorId(String id) {
        Usuario usuario = null;
        if (id != null && !id.isEmpty()) {
            usuario = usuarioDAO.obterUsuarioPorId(Integer.parseInt(id));
        }
        return usuario;
    }

    private boolean validarDados(String nome, String cpf, String mac) {
        if ((nome != null && !nome.isEmpty()) && (cpf != null && !cpf.isEmpty()) && (mac != null && !mac.isEmpty())) {
            return true;
        }
        return false;
    }

    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("usuarios", usuarioDAO.obterTodosUsuarios());
        request.getRequestDispatcher("/usuario.jsp").forward(request, response);
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = obterUsuarioDaRequisicao(request);
        if (usuario != null) {
            usuarioDAO.cadastrar(usuario);
            listar(request, response);
        }
    }

    private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Usuario usuario = obterUsuarioPorId(id);
        if (usuario != null) {
            request.setAttribute("teste", usuario);
            request.getRequestDispatcher("/usuarioAlterar.jsp").forward(request, response);
        }
    }

    private void salvarAlteracao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = obterUsuarioDaRequisicao(request);
        usuario.setId(Long.parseLong(request.getParameter("id")));
        usuarioDAO.alterar(usuario);
        listar(request, response);
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null && !id.isEmpty()) {
            usuarioDAO.excluir(Integer.parseInt(id));
        }
        listar(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

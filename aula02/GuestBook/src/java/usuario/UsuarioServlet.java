package usuario;

import guest.Guest;
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

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        System.out.println("ação: " + acao);

        if (acao != null && !acao.isEmpty()) {
            Usuario usuario = obterDados(request, response);
            if (usuario != null) {
                efetivarAcao(acao, usuario);
            }
        }
        System.out.println("guest");
        request.setAttribute("usuarios", usuarioDAO.obterTodosUsuarios());
        request.getRequestDispatcher("/usuario.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //http://javafree.uol.com.br/artigo/886161/CRUD-com-Servlet-30-e-MYSQL.html
        //http://www.guj.com.br/java/122698-alterar-excluir-no-jsp
        //String cmd = request.getParameter("cmd");  
        //   if(cmd.equalsIgnoreCase("cadastrar")){  
//        String nome = request.getParameter("nome");
//        String cpf = request.getParameter("cpf");
//        String mac = request.getParameter("mac");
       
        
        
//        String acao = request.getParameter("acao");
//        System.out.println("ação: " + acao);
//
//        if (acao != null && !acao.isEmpty()) {
//            Usuario usuario = obterDados(request, response);
//            if (usuario != null) {
//                efetivarAcao(acao, usuario);
//            }
//        }
        
        

//            if (acao.equalsIgnoreCase("cadastrar")) {
//
//                System.out.println("cadastrar");
//
//                usuarioDAO.gravar(new Usuario(nome, cpf, mac));
//
//            } else if (acao.equalsIgnoreCase("atualizar")) {
//                usuarioDAO.gravar(new Usuario(nome, cpf, mac));
//                System.out.println("atualizar");
//
//            } else if (acao.equalsIgnoreCase("excluir")) {
//                usuarioDAO.gravar(new Usuario(nome, cpf, mac));
//                System.out.println("excluir");
//            }
        System.out.println("post");
        doGet(request, response);
    }

    private void efetivarAcao(String acao, Usuario usuario) {

        if (acao != null && !acao.isEmpty()) {
            if (acao.equalsIgnoreCase("cadastrar")) {
                System.out.println("cadastrar");
                usuarioDAO.gravar(usuario);
            } else if (acao.equalsIgnoreCase("atualizar")) {
                usuarioDAO.alterar(usuario);
                System.out.println("atualizar");
            } else if (acao.equalsIgnoreCase("excluir")) {                
                usuarioDAO.excluir(usuario);
                System.out.println("excluir");
            }
        }
    }

    private Usuario obterDados(HttpServletRequest request, HttpServletResponse response) {
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String mac = request.getParameter("mac");

        Usuario usuario = null;
        if (validarDados(nome, cpf, mac)) {
            usuario = new Usuario(nome, cpf, mac);
        }
        return usuario;
    }

    private boolean validarDados(String nome, String cpf, String mac) {
        if ((nome != null && !nome.isEmpty()) && (cpf != null && !cpf.isEmpty()) && (mac != null && !mac.isEmpty())) {
            return true;
        }
        return false;
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

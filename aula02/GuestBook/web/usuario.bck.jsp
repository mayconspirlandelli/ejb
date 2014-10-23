<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,usuario.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Cadastro de Usuários</title>
    </head>
    <body>
        <form method="POST" action="usuario">
            Nome: <input type="text" name="nome" />
            CPF: <input type="text" name="cpf" />
            MAC: <input type="text" name="mac" />
            <input type="submit" value="Add" />
        </form>
        <hr><ol> <%
            @SuppressWarnings(  "unchecked")
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {%>
            <li> <%= usuario%> </li> <%
                    }
                }%>
        </ol><hr>

        <table>
            <tr>
                <td>
                    Nome
                </td>
                <td>
                    CPF
                </td>
                <td>
                    MAC
                </td>
            </tr>
            <tr>
                <%
            @SuppressWarnings("unchecked")
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null) {
                for (Usuario usuario : usuarios) {%>
            <li> <%= usuario%> </li> <%
                    }
                }%>
            </tr>                
        </table>


        <iframe src="http://www.objectdb.com/pw.html?jee-netbeans"
                frameborder="0" scrolling="no" width="100%" height="30"> </iframe>
    </body>
</html>
<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,usuario.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Cadastro de Usuários</title>
    </head>
    <body>
        <form method="POST" action="usuario?acao=cadastrar">
            <h3>Cadastro de Usuário - Exercício Lista 02 GuestBook</h3>
            <table style="border: 1px solid black">
                <tr>
                    <td>
                        Nome:<input type="text" name="nome" />
                    </td>
                    <td>
                        CPF:<input type="text" name="cpf" />
                    </td>
                    <td>
                        MAC:<input type="text" name="mac" />
                    </td>
                    <td>
                        <input type="image" title="Cadastrar"  id="btnCadastar" alt="Cadastrar" src="images/ic_description_black_48dp.png" height="32px" width="32px" />                        
                        <a href="usuario?acao=listar"><img src="images/ic_view_list_black_48dp.png" height="32px" width="32px" alt="Listar" title="Listar"/></a>
                    </td>
                </tr>
            </table>
            <br />
            <table style="border: 1px solid black">
                <tr>
                    <td>
                        ID
                    </td>
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
                        @SuppressWarnings(  "unchecked")
                        List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                        if (usuarios != null) {
                            for (Usuario usuario : usuarios) {%>
                <tr>
                    <td> <%= usuario.getId()%>  </td>
                    <td> <%= usuario.getNome()%> </td>
                    <td> <%= usuario.getCpf()%> </td>
                    <td> <%= usuario.getMac()%> </td>
                    <td><a href="usuario?acao=atualizar&id=<%= usuario.getId()%>"><img src="images/ic_autorenew_black_48dp.png" height="32px" width="32px" alt="Alterar"/></a></td>                    
                    <td><a href="usuario?acao=excluir&id=<%= usuario.getId()%>"><img src="images/ic_delete_black_48dp.png" height="32px" width="32px" alt="Excluir"/></a></td>
                </tr>  <%
                        }
                    }%>
                </tr>                
            </table>
        </form>        
    </body>
</html>
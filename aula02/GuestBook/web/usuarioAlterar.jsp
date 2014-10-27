<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,usuario.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Cadastro de Usuários</title>
    </head>
    <body>
        <form method="POST" action="usuario?acao=salvarAlteracao">
            <h3>Cadastro de Usuário - Exercício Lista 02 GuestBook</h3>

            <%
                Usuario usuario = (Usuario) request.getAttribute("teste");
            %>

            <table>
                <tr>
                    <td>Id:</td>
                    <td>
                        <input type="text" id="id" name="id" value="<%=usuario.getId()%>" />
                    </td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td>
                        <input type="text" id="nome" name="nome" value="<%=usuario.getNome()%>" />
                    </td>
                </tr>
                <tr>
                    <td>CPF:</td>
                    <td>
                        <input type="text" id="cpf" name="cpf" value="<%=usuario.getCpf()%>" />
                    </td>
                </tr>
                <tr>
                    <td>MAC:</td>
                    <td>
                        <input type="text" id="mac" name="mac" value="<%=usuario.getMac()%>" />
                    </td>
                </tr>
                <tr>
                    <td> <input type="image" value="" name="acao" title="Salvar" src="images/ic_description_black_48dp.png" height="32px" width="32px" />  </td>                    
                </tr>
            </table>           
        </form>
    </body>
</html>
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
            <table>
                <tr>
                    <td>
                        Nome:<input type="text" name="nome" />
                    </td>
                </tr>
                <tr>
                    <td>
                        CPF:<input type="text" name="cpf" />
                    </td>
                </tr>
                <tr>
                    <td>
                        MAC:<input type="text" name="mac" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="image" title="Cadastrar"  id="btnCadastar" alt="Cadastrar" src="images/ic_description_black_48dp.png" height="32px" width="32px" />
<!--                        <input type="submit" value="Cadastrar" id="btnCadastar" title="" src="images/ic_description_black_48dp.png" />-->
                        <a href="usuario?acao=listar"><img src="images/ic_view_list_black_48dp.png" height="32px" width="32px" alt="Listar"/></a>
                    </td>
                </tr>
            </table>

            <table>
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


<!--                    <td><a href="usuario?acao=atualizar"></a> </td>-->
                    
                    <td><a href="usuario?acao=atualizar"><img src="images/ic_autorenew_black_48dp.png" height="32px" width="32px" alt="Alterar"/></a></td>
                    <td><a href="usuario?acao=excluir"><img src="images/ic_delete_black_48dp.png" height="32px" width="32px" alt="Excluir"/></a></td>
                    
<!--                    <td><a href="usuario?acao=excluir" >Apagar</a> </td>-->
                    
                </tr>  <%
                        }
                    }%>
                </tr>                
            </table>
        </form>

        <!--    <iframe src="http://www.objectdb.com/pw.html?jee-netbeans"
                    frameborder="0" scrolling="no" width="100%" height="30"> </iframe>-->
    </body>
</html>
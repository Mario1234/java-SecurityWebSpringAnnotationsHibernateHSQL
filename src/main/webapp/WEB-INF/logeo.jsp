<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Login</title>
</head>
<body>
	<p>LOGIN</p>
    <form:form id="idFormularioLogin" modelAttribute="formularioLogin" action="/procesaLogeo" method="post">
        <table align="center">
            <tr>
                <td>
                    <form:label path="nombreUsuario">Usuario: </form:label>
                </td>
                <td>
                    <form:input path="nombreUsuario" name="nNombreUsuario" id="idNombreUsuario" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="contrasenia">Contraseñia:</form:label>
                </td>
                <td>
                    <form:password path="contrasenia" name="nContrasenia" id="idContrasenia" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <form:button id="idBotonLogin" name="nBotonLogin">Login</form:button>
                </td>
            </tr>
            <tr></tr>
        </table>
    </form:form>
    <table align="center">
        <tr>
            <td style="font-style: italic; color: red;">${mensaje}</td>
        </tr>
    </table>
</body>
</html>
<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="menu.jsp" %>

	<%
	
	Usuario u = (Usuario) request.getAttribute("usu");
	
	%>

	<form action="usucontroller.do" method="post">
	
		ID: <input type="number" name="id" value="<%= u.getID()%>"/>
		<br><br>
		Nome: <input type="text" name="nome" value="<%= u.getNome()%>"/>
		<br><br>
		Login: <input type="text" name="login" value="<%= u.getLogin()%>"/>
		<br><br>
		Senha: <input type="text" name="senha" value="<%= u.getSenha()%>"/>
		<br><br><br>
		<input type="submit" value="salvar">
	
	
	
	</form>

</body>
</html>
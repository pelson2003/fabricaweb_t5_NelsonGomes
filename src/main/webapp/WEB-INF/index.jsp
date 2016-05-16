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
Bem vindo ao sistema de Cadastro
Sr. 
<% Usuario usuario = (Usuario)request.getSession().getAttribute("usuAutenticado"); 
out.println(usuario.getNome().toUpperCase());
%>




<!-- <br><br> -->
<!-- <a href="usucontroller.do?acao=lis"> Prosseguir </a> -->

</body>
</html>
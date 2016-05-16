<%@page
	import="br.com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>

<script type="text/javascript">
	function confirmaExclusao(id) {

		if (window.confirm("Tem Certeza que deseja excluir?"))
			location.href = "usucontroller.do?acao=exc&id=" + id;

	}
</script>


</head>
<body>


	<!-- <table border="1"> -->

	<!-- <tr><th>id</th> <th>nome</th> <th>login</th> <th>senha</th> </tr> -->

	<%@include file="menu.jsp" %>	

	<br>
	<br>

	<%
		List<Usuario> lista = (List<Usuario>) request.getAttribute("lista");
	%>

	<table border="1">
		<tr>
			<th>id</th>
			<th>nome</th>
			<th>login</th>
			<th>senha</th>
			<th>acao</th>
		</tr>



		<%
			for (Usuario u : lista) {
		%>

		<tr>
			<td><%=u.getID()%></td>
			<td><%=u.getNome()%></td>
			<td><%=u.getLogin()%></td>
			<td><%=u.getSenha()%></td>

			<!-- 			Sem java script -->
			<%-- 			<td> <a href="usucontroller.do?acao=exc&id=<%=u.getID()%>"> Exluir </a> </td> --%>

			<td><a href="javascript:confirmaExclusao(<%=u.getID()%>)">
					Exluir </a> | <a href="usucontroller.do?acao=cad"> Novo </a> | <a
				href="usucontroller.do?acao=alt&id=<%=u.getID()%>"> Alterar </a></td>



			<%
				}
			%>
		
	</table>

	<br>
	<br>

	

<!-- 	<a href="autenticador.do"> LogOut </a> -->







</body>
</html>
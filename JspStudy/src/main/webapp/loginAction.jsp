<%@page import="user.UserDAO" %>
<%@page import="user.UserDTO" %>
<%@page import="java.io.PrintWriter" %>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%
	request.setCharacterEncoding("EUC-KR");
	UserDTO NewUser = new UserDTO();
	if(request.getParameter("userID") != ""){
		NewUser.setUserID(request.getParameter("userID"));
	}
	if(request.getParameter("userPassword") != ""){
		NewUser.setUserPassword(request.getParameter("userPassword"));
	}
	if(NewUser.getUserID() == null || NewUser.getUserPassword() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�Է��� �� �� �� �ִ�.')");
		script.println("location.href ='login.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	UserDAO userDAO = new UserDAO();
	boolean result = userDAO.loginSign(NewUser.getUserID(), NewUser.getUserPassword());
	if(result){
		PrintWriter script = response.getWriter();
		session.setAttribute("userID", NewUser.getUserID());
		script.println("<script>");
		script.println("alert('�α��� ����!')");
		script.println("location.href ='UseDb.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	else{
		PrintWriter script2 = response.getWriter();
		script2.println("<script>");
		script2.println("alert('ȸ������ ���� ���� id�ų� ��й�ȣ�� �߸��ƽ��ϴ�.')");
		script2.println("location.href ='login.jsp'");
		script2.println("</script>");
		script2.close();
		
	}
	%>
</body>
</html>
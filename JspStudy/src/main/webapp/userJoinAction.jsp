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
	if(request.getParameter("userId") != ""){
		NewUser.setUserID(request.getParameter("userId"));
	}
	if(request.getParameter("userPassword") != ""){
		NewUser.setUserPassword(request.getParameter("userPassword"));
	}
	if(NewUser.getUserID() == null || NewUser.getUserPassword() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�Է��� �� �� �� �ִ�.')");
		script.println("location.href ='insertUser.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	
	//id�� ��й�ȣ�� ��� �ִ� ���
	UserDAO userDAO = new UserDAO();
	int result = userDAO.join(NewUser.getUserID(),NewUser.getUserPassword());
	if(result == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�� �ƽ��ϴ�!')");
		script.println("location.href ='insertUser.jsp'");
		script.println("</script>");
		script.close();
		return;
	}



%>

</body>
</html>
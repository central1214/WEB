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
	if(request.getParameter("email") != ""){
		NewUser.setEmail(request.getParameter("email"));
	}
	if(request.getParameter("nickName") != ""){
		NewUser.setNickName(request.getParameter("nickName"));
	}
	
	if(NewUser.getUserID() == null 
			|| NewUser.getUserPassword() == null
			|| NewUser.getNickName() == null
			|| NewUser.getEmail() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('��� �׸��� �Է��� �ּ���.')");
		script.println("location.href ='signUp.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	
	//id�� ��й�ȣ�� ��� �ִ� ���
	UserDAO userDAO = new UserDAO();
	if(userDAO.searchID(request.getParameter("userID"))){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('�ߺ��� ID�Դϴ�.')");
		script.println("location.href ='signUp.jsp'");
		script.println("</script>");
		script.close();
		return;
	};
	int result = userDAO.join(NewUser.getUserID(),NewUser.getUserPassword(),NewUser.getEmail(),NewUser.getNickName());
	if(result == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('ȸ�� ���� �Ϸ�!')");
		script.println("location.href ='login.jsp'");
		script.println("</script>");
		script.close();
		return;
	}



%>

</body>
</html>
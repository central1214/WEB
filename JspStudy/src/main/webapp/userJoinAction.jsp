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
	if(request.getParameter("email") != ""){
		NewUser.setEmail(request.getParameter("email"));
	}
	if(request.getParameter("userPassword") != ""){
		NewUser.setNickName(request.getParameter("nick"));
	}
	
	if(NewUser.getUserID() == null 
			|| NewUser.getUserPassword() == null
			|| NewUser.getNickName() == null
			|| NewUser.getEmail() == null){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('모든 항목을 입력해 주세요.')");
		script.println("location.href ='insertUser.jsp'");
		script.println("</script>");
		script.close();
		return;
	}
	
	//id와 비밀번호가 모두 있는 경우
	UserDAO userDAO = new UserDAO();
	int result = userDAO.join(NewUser.getUserID(),NewUser.getUserPassword(),NewUser.getEmail(),NewUser.getNickName());
	if(result == 1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('잘 됐습니다!')");
		script.println("location.href ='insertUser.jsp'");
		script.println("</script>");
		script.close();
		return;
	}



%>

</body>
</html>
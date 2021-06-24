<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int userID = 0;
	if(session.getAttribute("userLogin") != null)
		userID = (int) session.getAttribute("userLogin");
	
	if(userID == 0) {
		String redirectURL = "http://localhost:8080/pages/login/login.jsp";
	    response.sendRedirect(redirectURL);
	}
%>

<%@include file='../../../common/company/cadastro-empresa/cadastro-empresa.jsp'%>
<%@include file='../../../footer/footer.jsp'%>
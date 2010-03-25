<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="home.list.web.GoServlet"%><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
</head>
<body>
<%
	String itf = (String) request.getAttribute(GoServlet.itf);
	String l = (String) request.getAttribute(GoServlet.list);
	
	if (itf == null){
		request.getRequestDispatcher("/go").forward(request, response);
	}
	
	if ( itf.equals(GoServlet.list_usr) ){
		%>
		
		Your lists : <br/>
		  
		<%		
		out.println(l);
	} else if ( itf.equals(GoServlet.list_element) ){
		%>
		
		Elements of this list :
		  
		<%
		out.println(l);
	} else {
		request.getRequestDispatcher("/go").forward(request, response);
	}
%>
</body>
</html>
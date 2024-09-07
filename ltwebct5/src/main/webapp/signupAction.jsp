<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vn.iotstar.configs.DBConnectSQLServer"%>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("UTF-8");
String name = request.getParameter("name");
String email = request.getParameter("email");
String password = request.getParameter("password");
String phone = request.getParameter("phone");
String address = "";
String city = "";
String state = "";
String country = "";
try {
	Connection conn = DBConnectSQLServer.getConnection();

	String q1 = "insert into userTableYoutube VALUES (?,?,?,?,?,?,?,?)";
	PreparedStatement st = conn.prepareStatement(q1);
	st.setString(1,name);
	st.setString(2,email);
	st.setString(3,phone);
	st.setString(4,password);
	st.setString(5,address);
	st.setString(6,city);
	st.setString(7,state);
	st.setString(8,country);
	st.executeUpdate();
    response.sendRedirect("signup.jsp?msg=done");
	
	conn.close();
} catch (Exception e) {
	  response.sendRedirect("signup.jsp?msg=invalid");
}
%>
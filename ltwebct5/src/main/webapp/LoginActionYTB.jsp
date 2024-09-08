<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vn.iotstar.configs.DBConnectSQLServer"%>
<%@ page import="java.sql.*"%>
<%
request.setCharacterEncoding("UTF-8");
int kt = 0;
String email = request.getParameter("email");
String password = request.getParameter("password");
try {
	Connection conn = DBConnectSQLServer.getConnection();

	String q1 = "select * from userTableYoutube where email=? and password = ?";
	PreparedStatement st = conn.prepareStatement(q1);

	st.setString(1,email);
	st.setString(2,password);
	

     ResultSet rs = st.executeQuery(); 
     
    while(rs.next())
	{
      kt=1;
      response.sendRedirect("homeYTB.jsp?msg=valid");
	}
    if(kt==0)
      response.sendRedirect("LoginYTB.jsp?msg=invalid");
	conn.close();
} catch (Exception e) {
	 response.sendRedirect("LoginYTB.jsp?msg=invalid");
}
%>
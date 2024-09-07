<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vn.iotstar.configs.DBConnectSQLServer"%>
<%@ page import="java.sql.*"%>

<%
   try{
	   Connection conn=DBConnectSQLServer.getConnection();
	   Statement st = conn.createStatement();
	   String q1 = "create table product (id int,name varchar(100),category varchar(200),price int,active varchar(100))";
	//   String q1 = "create table userTableYoutube(name varchar(100),email varchar(100)primary key,phone bigint,password varchar(100),state varchar(100),country varchar(100))";
	   System.out.println(q1);
	   st.execute(q1);
	   System.out.println(st);
	   conn.close();
   }catch(Exception e){
	   System.out.println(e);
   }
%>
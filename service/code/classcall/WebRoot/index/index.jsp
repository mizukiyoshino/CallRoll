<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="java.sql.*"%>
<%@ page import="com.mysql.jdbc.Driver"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
</head>

<body>
	This is my JSP page. —— 圣骑士Wind
	<br>



	<%
		String driverName = "com.mysql.jdbc.Driver";
		String userName = "root";
		String userPasswd = "123456";
		String dbName = "studentsitedb";
		String tableName = "person_wpresource";
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="
				+ userName + "&password=" + userPasswd;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM " + tableName;
		ResultSet rs = statement.executeQuery(sql);
	%>
	<br>
	<br>

	<%
		while (rs.next()) {
	%>
	<tr>
		<td>
			<%
				out.print(rs.getString(1));
			%>
		</td>
		<td>
			<%
				out.print(rs.getString(2));
			%>
		</td>
		<td>
			<%
				out.print(rs.getString(3));
			%>
		</td>
		<td>
			<%
				out.print(rs.getString(4));
			%>
		</td>
	</tr>
	<%
		}
	%>
	<%
		rs.close();
		statement.close();
		connection.close();
	%>


</body>
</html>
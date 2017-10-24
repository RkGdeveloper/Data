<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Items</title>
</head>
<body>

<h1>All Data</h1> <span> | </span> <a href="../index.obj">Home Page</a>


<c:forEach items="${eList}" var="list">
<c:out value="---------------------------"></c:out><br/>
<c:out value="${list.employeeId}"><br/></c:out><br/>
<c:out value="${list.firstName}"><br/></c:out><br/>
<c:out value="${list.lastName}"><br/></c:out><br/>
<c:out value="${list.designation}"><br/></c:out><br/>
<c:out value="${list.salary}"><br/></c:out><br/>

Action ::: <a href="edit.obj?employeeId=${list.employeeId}">EDIT</a> <span>|</span>
			<a href="delete.obj?employeeId=${list.employeeId}">DELETE</a>
				
<br/>

<c:out value="---------------------------"></c:out><br/>
</c:forEach>
</body>
</html>
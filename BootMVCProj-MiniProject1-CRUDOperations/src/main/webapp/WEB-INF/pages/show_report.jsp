<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty empList}">
	<h1 style="color: red; text-align: center">Employees Report</h1>
	
		<table align="center" border="1" bgcolor="yellow">
			<tr bgcolor="cyan">
				<th>Empno</th>
				<th>Ename</th>
				<th>Salary</th>
				<th>Job</th>
				<th>Deptno</th>
				<th>Operations</th>
			</tr>
			<c:forEach var="emp" items="${empList}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.sal}</td>
					<td>${emp.job}</td>
					<td>${emp.deptno}</td>
					<td>
						<!-- Edit Link --> <a href="edit?no=${emp.empno}"> <img
							src="images/edit.jpg" width="30px" height="40px" alt="Edit">
					</a> &nbsp;&nbsp; <!-- Delete Link --> <a
						onclick="return confirm('Are you Sure to Delete?');"
						href="delete?no=${emp.empno}"> <img src="images/deleteemp.jpg"
							width="30px" height="40px" alt="Delete">
					</a>
				</tr>
			</c:forEach>

		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color: red; text-align: center">No Data Found</h1>
	</c:otherwise>
</c:choose>
<br>
<br>
<h1 style="color: green; text-align: center">${resultMsg}</h1>

<br>
<br>
<center>
	<a href="register"><img src="images/addemp.jpg" width="90"
		height="120" alt="AddEmp"></a>
</center>
<br>
<br>
<center>
	<a href="./"><img src="images/home.png" width="90" height="120"
		alt="Home"></a>
</center>

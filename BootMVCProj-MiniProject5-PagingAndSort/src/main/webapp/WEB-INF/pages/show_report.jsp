<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: red; text-align: center">Employees Report</h1>

<c:choose>
    <c:when test="${not empty empData}">
        <table align="center" border="1" bgcolor="yellow">
            <tr bgcolor="cyan">
                <th>Empno</th>
                <th>Ename</th>
                <th>Salary</th>
                <th>Job</th>
                <th>Deptno</th>
            </tr>
            <c:forEach var="emp" items="${empData.content}">
                <tr>
                    <td>${emp.empno}</td>
                    <td>${emp.ename}</td>
                    <td>${emp.sal}</td>
                    <td>${emp.job}</td>
                    <td>${emp.deptno}</td>
                </tr>
            </c:forEach>
        </table>

        <br>

        <!-- Pagination Links -->
        <div style="text-align:center;">
            <c:if test="${empData.hasPrevious()}">
                <a href="?page=0&size=3" style="margin: 5px;">First</a>
                <a href="?page=${empData.number-1}&size=3" style="margin: 5px;">Previous</a>
            </c:if>

            <c:forEach var="i" begin="0" end="${empData.totalPages - 1}">
                <c:if test="${i == empData.number}">
                    <span style="margin: 5px; font-weight: bold;">[${i+1}]</span>
                </c:if>
                <c:if test="${i != empData.number}">
                    <a href="?page=${i}&size=3" style="margin: 5px;">${i+1}</a>
                </c:if>
            </c:forEach>

            <c:if test="${empData.hasNext()}">
                <a href="?page=${empData.number+1}&size=3" style="margin: 5px;">Next</a>
                <a href="?page=${empData.totalPages-1}&size=3" style="margin: 5px;">Last</a>
            </c:if>
        </div>

    </c:when>
    <c:otherwise>
        <h1 style="color: red; text-align: center">No Data Found</h1>
    </c:otherwise>
</c:choose>

<br>
<h1 style="color: green; text-align: center">${resultMsg}</h1>
<br>
<br>
<center>
    <a href="register"><img src="images/addemp.jpg" width="90" height="120" alt="AddEmp"></a>
</center>
<br>
<br>
<center>
    <a href="./"><img src="images/home.png" width="90" height="120" alt="Home"></a>
</center>

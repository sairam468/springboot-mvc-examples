<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<h1 style="color: red; text-align: center">Employees Report</h1>

<h2 style="color: blue; text-align: center">Search data Dynamically</h2>

<frm:form action="search" modelAttribute="emp">

    <table align="center" bgcolor="pink">
        <tr>
            <td>Employee Name</td>
            <td>
                <frm:input path="ename" />
            </td>
        </tr>
        <tr>
            <td>Emp Job</td>
            <td>
                <frm:input path="job" />
            </td>
        </tr>
        <tr>
            <td>Emp Dept no</td>
            <td>
                <frm:select path="deptno">
                    <frm:option value="">--Select Dept--</frm:option>
                    <frm:option value="10">10</frm:option>
                    <frm:option value="20">20</frm:option>
                    <frm:option value="30">30</frm:option>
                </frm:select>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Search With Data" /></td>
            <td><input type="reset" value="Cancel" /></td>
        </tr>
    </table>
</frm:form>

<c:choose>
    <c:when test="${!empty empList}">
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
                        <!-- Edit Link -->
                        <a href="edit?no=${emp.empno}">
                            <img src="images/edit.jpg" width="30px" height="40px" alt="Edit">
                        </a> 
                        &nbsp;&nbsp; 
                        <!-- Delete Link -->
                        <a onclick="return confirm('Are you Sure to Delete?');" href="delete?no=${emp.empno}">
                            <img src="images/deleteemp.jpg" width="30px" height="40px" alt="Delete">
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
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

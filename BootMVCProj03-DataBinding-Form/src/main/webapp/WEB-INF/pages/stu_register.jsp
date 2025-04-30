<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1 style="color: red; text-align: center">Student Registration Page</h1>
<br><br>

<form action="register" method="post">
    <table align="center" bgcolor="cyan">
        <tr>
            <td>Student Number:</td>
            <td><input type="text" name="sno" required></td>
        </tr>
        <tr>
            <td>Student Name:</td>
            <td><input type="text" name="sname" required></td>
        </tr>
        <tr>
            <td>Student Address:</td>
            <td><input type="text" name="sadd" required></td>
        </tr>
        <tr>
            <td>Student Average:</td>
            <td><input type="text" name="avg" required></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Register">
            </td>
        </tr>
    </table>
</form>

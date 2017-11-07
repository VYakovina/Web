<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP</title>
    <style>
        .error{
            color:#ff0000;}
    </style>
</head>
<body>
<sf:form action="/login" method="post" modelAttribute="loginUser">
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Login Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>User Name</td>
                <td><sf:input  path="uname" placeholder="Логин"/>
                    <sf:errors path="uname" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name ="upass" placeholder="Пароль"required autocomplete="off"/></td>
            </tr>
            <tr>
                <td><input type="submit"  value="Login" /></td>
                <td><input type="reset" value="Reset" />
                </td>
            </tr>
            <tr>
                <td colspan="2">Yet Not Registered!! <a href="register">Register Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</sf:form>
</body>
</html>
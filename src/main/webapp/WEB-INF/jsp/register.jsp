<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
    <style>
        .error{
            color:#ff0000;}
    </style>
</head>
<body>
<sf:form action="/reg" method="post" modelAttribute="registrationUser">
    <center>
        <table border="1" width="30%" cellpadding="5">
            <thead>
            <tr>
                <th colspan="2">Enter Information Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Name</td>
                <td><input type="text" name ="fname" placeholder="Имя пользователя" required autocomplete="off"/></td>
            </tr>
            <td>User Name</td>
            <td><sf:input path="username" placeholder="Логин"/>
                <sf:errors path="username" cssClass="error" /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name ="password" placeholder="Пароль"required autocomplete="off"/></td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><input type="email" name ="email" placeholder="Электронный адрес" required autocomplete="off"/></td>
            </tr>
            <tr>
                <td><input type="submit"  value="Submit" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Already registered!! <a href="log">Login Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</sf:form>
</body>
</html>
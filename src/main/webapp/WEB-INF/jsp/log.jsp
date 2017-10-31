
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
<form method="post" action="/login">
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
                <td><input type="text" name = "uname" placeholder="Логин"required autocomplete="off"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="upass" placeholder="Пароль"required autocomplete="off"/></td>
            </tr>
            <tr>
                <td><input type="submit"  value="Login" /></td>
                <td><input type="reset" value="Reset" /></td>
            </tr>
            <tr>
                <td colspan="2">Yet Not Registered!! <a href="register">Register Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>
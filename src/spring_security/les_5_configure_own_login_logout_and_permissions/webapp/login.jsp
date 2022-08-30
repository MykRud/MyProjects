<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Login page</title>
    </head>
    <body>
        <h1>Login</h1>
        ${SPRING_SECURITY_LAST_EXCEPTION.message}
        <form action="login" method="POST">
            <table>
                <tr>
                    <td>User:</td>
                    <td><input name="username" type="text" /></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input name="password" type="password" /></td>
                </tr>
                <tr>
                    <td><input type="submit" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
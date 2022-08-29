<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<html>
    <head>
        <title>Index</title>
    </head>
    <body>
        <h2>Index</h2>
        <form action="addStudent">
            <input type="text" name="id" /> <br />
            <input type="text" name="name" /> <br />
            <input type="text" name="age" /> <br />
            <input type="submit" /> <br />
        </form>

        <form action="getStudent">
            <input type="text" name="id" /> <br />
            <input type="submit" /> <br />
        </form>
    </body>
</html>
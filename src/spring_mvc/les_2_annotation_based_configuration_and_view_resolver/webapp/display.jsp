<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display result</title>
</head>
<body>
    Result: ${result}
    <br />
    Another way to fetch result: <%= request.getAttribute("result") %>
</body>
</html>
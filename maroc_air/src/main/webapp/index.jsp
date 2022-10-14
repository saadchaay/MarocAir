<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
        <link href="../dist/output.css" rel="stylesheet">
        <script src="https://cdn.tailwindcss.com"></script>
    </head>
<%--        <h1><%= "Hello World!" %>--%>
<%--        </h1>--%>
<%--        <br/>--%>
<%--        <a href="authentication">auth</a>--%>
    <body>
        <jsp:include page="views/auth.jsp" />
    </body>

</html>
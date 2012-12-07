<%-- 
    Document   : newjsp
    Created on : Dec 6, 2012, 11:09:57 PM
    Author     : harker777
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <c:forEach items="${list}" var="item" varStatus="num">
                <tr>
                    <td>
                        <c:out value="${item.id}"> </c:out>
                    </td>
                    <td>
                        <c:out value="${item.name}"> </c:out>
                    </td>
                    <td>
                        <c:out value="${item.lattitude}"> </c:out>
                    </td>
                    <td>
                        <c:out value="${num.index}"> </c:out>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>

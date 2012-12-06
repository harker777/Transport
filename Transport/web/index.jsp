<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : main
    Created on : 1 груд 2010, 11:37:23
    Author     : Family
-->
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
          xmlns:c="http://java.sun.com/jsp/jstl/core"
          version="2.0">

    <jsp:directive.page contentType="text/html;charset=Utf-8"/>

    <html>
        <head>
            <title>Welcome</title>
        </head>
        <body>
            <h3>Welcome</h3>
            ${list}
            <c:out value="${list} Hello!" />
        </body>
    </html>

</jsp:root>
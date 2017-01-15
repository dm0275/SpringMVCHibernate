<%--
  Created by IntelliJ IDEA.
  User: dmancilla
  Date: 12/20/2016
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String server =  "http://" + request.getServerName() + ":" + request.getServerPort() + "/getAllCountries";
  %>
  Server host name is: <b><%=server%></b>
  <c:redirect url= "<%=server%>"/>
  </body>
</html>

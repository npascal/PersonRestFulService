<%--
  Created by IntelliJ IDEA.
  User: hamisu
  Date: 12/1/15
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <p>${message}</p>
  <table align="center">
    <tr>
      <td style="text-decoration: blink">
        <a href="/myprj/ajax">
          A simple page using Spring 3 restful service, ajax and AngularJS</a>
      </td>
    </tr>
    <tr>
      <td>
        <a href="http://listyourself.net/index.jsp">Tomcat Default page</a>
      </td>
    </tr>
  </table>

  </body>
</html>

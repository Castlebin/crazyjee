<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ page import="org.springframework.web.context.*" %>
<%@ page import="org.springframework.web.context.support.*" %>
<%@ page import="ch07.se05.bean.Person" %>
<!DOCTYPE html>
<html>
<body>
<%
    WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(application);
    Person p1 = ctx.getBean("p", Person.class);
    Person p2 = ctx.getBean("p", Person.class);

    out.println((p1 == p2) + "<br>");
    out.println(p1);
%>
</body>
</html>

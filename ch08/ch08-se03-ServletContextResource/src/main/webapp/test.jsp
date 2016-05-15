<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@page import="org.dom4j.Document" %>
<%@page import="org.dom4j.Element" %>
<%@ page import="org.dom4j.io.SAXReader" %>
<%@ page import="org.springframework.web.context.support.ServletContextResource" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<body>
<%
    ServletContextResource resource = new ServletContextResource(application, "WEB-INF/book.xml");
    System.out.println(resource.getFilename());
    System.out.println(resource.getDescription());

    // 使用SAX进行dom解析
    SAXReader reader = new SAXReader();
    Document document = reader.read(resource.getFile());
    // 获取根元素
    Element element = document.getRootElement();
    List LBooks = element.elements();
    for (Iterator it = LBooks.iterator(); it.hasNext();) {
        Element book = (Element)it.next();
        List LBook = book.elements();
        for (Iterator it2 = LBook.iterator(); it2.hasNext();) {
            Element eee = (Element)it2.next();
            out.println(eee.getText()+"<br/>");
        }
    }
%>
</body>
</html>
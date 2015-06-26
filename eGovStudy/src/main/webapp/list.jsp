
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<h3> UserInfo Table List</h3>
<table border="1">
  <tr> <td>ID</td> <td>NAME</td><td>Email</td></tr>
  
  <c:forEach var="user" items="${users}">
     <tr> 
         <td> ${user.userid}</td>
         <td> ${user.username }</td>
         <td> ${user.email }</td>
     </tr>
   </c:forEach>
</table>








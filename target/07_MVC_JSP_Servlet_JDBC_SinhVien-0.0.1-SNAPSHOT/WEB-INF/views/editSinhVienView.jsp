<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit SinhVien</title>
   </head>
   <body>
       <h3>Edit SinhVien</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty sinhvien}">
         <form method="POST" action="${pageContext.request.contextPath}/editSinhVien">
            <input type="hidden" name="id" value="${sinhvien.id}" />
            <table border="0">
               <tr>
                  <td>ID</td>
                  <td style="color:red;">${sinhvien.id}</td>
               </tr>
               <tr>
                  <td>Ho ten</td>
                  <td><input type="text" name="hoten" value="${sinhvien.hoten}" /></td>
               </tr>
               <tr>
                  <td>Dia Chi</td>
                  <td><input type="text" name="diachi" value="${sinhvien.diachi}" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/sinhvienList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>
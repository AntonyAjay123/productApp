<%@ page isELIgnored="false" %><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
<h2>Helllooo</h2>
Student First:${student.firstName}<br><br>
Student last:${student.lastName}<br><br>
Student country:${student.country}<br><br>
Fave Programming Language : ${student.faveLang}<br><br>
Operating systems :
<ul>
<c:forEach var="temp" items="${student.os}">
<li>temp</li>
</c:forEach>
</ul>
  </body>
</html>\
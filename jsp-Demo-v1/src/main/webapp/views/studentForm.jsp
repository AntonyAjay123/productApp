<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body>
  <form:form action = "processform" modelAttribute="student">
      First Name <form:input path="firstName"/><br><br>
      Last Name <form:input path="lastName"/><br><br>
      Country <form:select path="country">
     <!-- <form:option value="India" label="India"/>
      <form:option value="France" label="France"/>
      <form:option value="USA" label="USA"/>-->
      <form:options items="${student.getCountryOptions()}"/>
      </form:select>
      <br><br>
            Favourite Programming Language:
            Java <form:radiobutton path="faveLang" value="Java"/>
            Python <form:radiobutton path="faveLang" value="Python"/>
            JavaScript <form:radiobutton path="faveLang" value="JavaScript"/>
      <br><br>
      Operating Systems:
          Mac <form:checkbox path="os" value="mac os"/>
          Windows<form:checkbox path="os" value="windows os"/>
          Linux<form:checkbox path="os" value="linux os"/>
          <button type="submit" name="button">Submit</button>
    </form:form>
  </body>
</html>
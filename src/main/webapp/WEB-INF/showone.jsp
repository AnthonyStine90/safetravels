<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<c:url value="/resources/css/sketchy.css" />" rel="stylesheet">
    <title>Safe Travel</title>
  </head>
  <body>
    <div class="container">
      <div class="card text-white bg-secondary mb-3" style="max-width: 20rem">
        <div class="card-header">Expense Details</div>
        <div class="card-body">
          <p class="card-text">Expense Name: ${expense.name}</p>
          <p class="card-text">Expense Description: ${expense.description}</p>
          <p class="card-text">Vendor: ${expense.description}</p>
          <p class="card-text">Amount Spend: $${expense.amount}</p>
        </div>
      </div>
    </div>
  </body>
</html>

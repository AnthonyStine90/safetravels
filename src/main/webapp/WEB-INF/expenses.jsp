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
      <h1>Safe Travels</h1>
      <table class="table table-hover">
        <thead class="table-dark">
          <tr>
            <th scope="col">Expenses</th>
            <th scope="col">Vendor</th>
            <th scope="col">Amount</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="expense" items="${expenses}">
          <tr class="table-secondary">
            <td><a href="/expenses/${expense.id}">${expense.name}</a></td>
            <td>${expense.vendor}</td>
            <td>$${expense.amount}</td>
            <td><a href="/expenses/edit/${expense.id}">Edit</a></td>
            <td>
              <form action="/delete/${expense.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <button type="submit" class="btn btn-danger">Delete</button>
              </form>
            </td>
          </tr>
          </c:forEach>
        </tbody>
      </table>

      <div class="container">
        <h1>Add an Expense</h1>
        <div class="container">
          <form:form
            action="/newexpense"
            method="post"
            modelAttribute="expense"
          >
            <div class="form-group">
              <form:label path="name" class="form-label mt-4"
                >Expense Name:</form:label
              >
              <form:errors path="name"/>
              <form:input path="name" class="form-control"></form:input>
            </div>
            <div class="form-group">
              <form:label path="vendor" class="form-label mt-4"
                >Vendor:</form:label
              >
              <form:errors path="vendor"/>
              <form:input path="vendor" class="form-control"></form:input>
            </div>
            <div class="form-group">
              <form:label path="amount" class="form-label mt-4" 
                >Amount:</form:label
              >
              <form:errors path="amount"/>
              <form:input path="amount" class="form-control"></form:input>
            </div>
            <div class="form-group">
              <form:label path="description" class="form-label mt-4"
                >Description:</form:label
              >
              <form:errors path="description"/>
              <form:textarea
                path="description"
                class="form-control"
              ></form:textarea>
            </div>
            <div class="container d-flex justify-content-end">
              <button class="btn btn-secondary mt-4" type="submit">
                Submit
              </button>
            </div>
          </form:form>
        </div>
      </div>
    </div>
  </body>
</html>

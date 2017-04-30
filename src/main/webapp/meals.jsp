<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table {
            mso-cellspacing: 5px;
        }
        tr.green {

            color: green;
        }
        tr.red {
            color: red;
        }
    </style>
</head>
<body>
<h2><a href="meals?action=create">Add meal</a></h2>
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
<c:forEach items="${mealList}" var="meal">
    <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.MealWithExceed"/>
    <tr class="${meal.exceed? 'red' : 'green'}">
        <%--<td> ${meal.dateTime.toLocalDate()} ${row.dateTime.toLocalTime()}</td>--%>
       <td><%=TimeUtil.toString(meal.getDateTime())%></td>
        <td> ${meal.description}</td>
        <td> ${meal.calories}</td>
        <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
        <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>

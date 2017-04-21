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
<table border="1" cellpadding="8" cellspacing="0">
    <tr>
        <th>Date</th>
        <th>Description</th>
        <th>Calories</th>
        <%--<th></th>--%>
        <%--<th></th>--%>
    </tr>
<c:forEach  var="row" items="${meals}" varStatus="rowCounter">
    <tr class="${row.exceed ? 'red' : 'green'}">
        <td> ${row.dateTime.toLocalDate()} ${row.dateTime.toLocalTime()}</td>
        <td> ${row.description}</td>
        <td> ${row.calories}</td>
        <%--<td><a href="meals?action=update&id=${meal.id}">Update</a></td>--%>
        <%--<td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>--%>
    </tr>
</c:forEach>
</table>
</body>
</html>

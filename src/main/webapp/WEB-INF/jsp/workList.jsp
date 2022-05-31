<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Person List</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}static/style.css"/>
    </head>
    <body>
        <h1>Work List</h1>
        <br/><br/>
        <div>
            <table border="1">
                <tr>
                    <th>Name</th>
                </tr>
                <c:forEach  items="${works}" var ="work">
                    <tr>
                        <td>${work.title}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>

</html>

<html>
<head>
    <title>Ticket #c:out value="${ticketId}"</title>
    <h2>Ticket Id<#c:out value="${ticketId}"/</h2>
    <p>Customer Name: <c:out value="${ticket.getCustomerName()}"</p>
    <p><c:out value="${ticket.getBody()}"</p>

    %>
    <a href="ticket">Return ticket</a>
</head>
<body>

</body>
</html>

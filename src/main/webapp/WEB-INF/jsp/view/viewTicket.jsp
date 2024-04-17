<html>
<head>
    <title>Blog #<c:out value="${blogId}"/></title>
</head>
<body>
<h2>Tickets</h2>
<h3>Tickets #<c:out value="${ticketId}"/>: <c:out value="${ticket.title}"/></h3>
<p>Customer name: <c:out value="${customerName}"/></p>
<p><c:out value="${ticket.body}"/></p>
<c:if test="${ticket.hasAttachment()}">
    <a href="<c:url value='/blog' >
            <c:param name='action' value='download' />
            <c:param name='ticketId' value='${ticketId}' />
            <c:param name='image' value='${ticket}'/>
        </c:url>"><c:out value="${ticket}"/></a>
</c:if>
<br><a href="ticket">Return to ticket list</a>

</body>
</html>


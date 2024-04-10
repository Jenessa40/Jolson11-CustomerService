<html>
<head>
    <title>Tickets</title>
</head>
<body>
    <h2>Tickets</h2>
    <a href="<c:url value="/ticket">
        <c:param name="action" value="createTicket" />>
    <c:url>">Create Ticket</a>
        <c:choose>
            <c:when test="${ticketDatabase.size() == 0}">
                <p>There is no ticket</p>
            </c:when>
            <c:otherwise>
                <c:forEach var="ticket" items="${blogDatabase}">
                    TicketId: <c:out value="ticket.key"/>
                    <a href="<c:url value='/ticket'/>
                        <c:param name="action" value="view"/>
                        <c:param name="tickerID" value="${ticket.key}"/>
                    </c:url>"><c:out value="${ticket.value.Id}"/></a>
                </c:forEach>
            </c:otherwise>
        </c:choose

</body>
</html>

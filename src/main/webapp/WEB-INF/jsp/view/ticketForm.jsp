<html>
<head>
    <title>Create a Ticker</title>
</head>
<body>
    <h2>Create a Ticket</h2>
    <form method="ticket" action="Ticket" enctype="multipart/form-data">
        <input type="hidden" name="action" value="create">
        Subject:<br>
        <input type="text" name="Customer Subject"><br><br>
        Customer Name:<br>
        <input type="text" name="Customer name"><br><br>
        Body: <br>
        <textarea name="body" rows="25" cols="100"></textarea><br><br>
        <input type="file" name="file1"><br><br>");
        <input type="submit" value="Submit">
    </form>
</body>
</html>

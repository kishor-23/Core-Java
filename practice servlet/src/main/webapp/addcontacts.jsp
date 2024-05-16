<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.chainsys.Contact" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Contact List</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="container">
    <h2>Add Contact</h2>
    <form action="PhonebookServlet" method="post">
        <input type="hidden" name="action" value="add">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="phone">Phone Number:</label>
        <input type="text" id="phone" name="phone" pattern="[0-9]{10}"
         required><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <input type="submit" value="Add Contact">
    </form>
     </div>
   
  

</body>
</html>

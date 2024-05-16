<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.Contact" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Phone book</title>
    <link rel='stylesheet' type='text/css' href='style.css'>
</head>
<body>
<h1>Phone book</h1><br>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th >Action</th>
    </tr>
    <% 
        ArrayList<Contact> contacts = (ArrayList<Contact>) request.getAttribute("contacts");
        if (contacts != null) {
            for (Contact c : contacts) { 
    %>
    <tr >
        <td><%= c.getName() %></td>
        <td><%= c.getEmail() %></td>
        <td><%= c.getPhoneNumber() %></td>
        <td style="  display: flex;
    flex-direction: row;">
            <form action="PhonebookServlet" method="post" >
             <input type="hidden" name="action" value="delete">
                <input type="hidden" name="deleteid" value="<%= contacts.indexOf(c) %>">
                <button type="submit">Delete</button>
            </form>
           
        
       
             <form action="PhonebookServlet" method="post" >
             <input type="hidden" name="action" value="updatedetails">
                <input type="hidden" name="updateid" value="<%= contacts.indexOf(c) %>">
                <button type="submit">Edit</button>
            </form>
            </td>
           
        
    </tr>
    <% 
            }
        }
    %>
</table>


<a href='http://localhost:8080/practice_servlet/'  class="button">Add Contact</a>
</body>
</html>

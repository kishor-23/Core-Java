package com.chainsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PhonebookServlet
 */
@WebServlet("/PhonebookServlet")
public class PhonebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Contact> contacts = new ArrayList<>(
			Arrays.asList(new Contact("mani", "1234567890", "mani@example.com"),
					new Contact("manoj", "9876543210", "manoj@example.com"),
					new Contact("Alice", "4561237890", "alice@example.com")));

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhonebookServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private synchronized void addContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get form data
		String name = request.getParameter("name");
		String phoneNumber = request.getParameter("phone");
		String email = request.getParameter("email");

		// Create a new contact object
		Contact contact = new Contact(name, phoneNumber, email);

		// Add the contact to the ArrayList
		contacts.add(contact);
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("viewcontact.jsp").forward(request, response);
//		out.print("<html><head>");
//		out.print("<link rel='stylesheet' type='text/css' href='style.css'>");
//		out.print("</head><body>");
//		out.print("<h1> phone book </h1><br>");
//		out.print("<table border='1'>");
//		out.print("<tr><th>Name</th><th>Email</th><th>Phone</th></tr>");
//		for (Contact c : contacts) {
//			out.print("<tr>");
//			out.print("<td>" + c.getName() + "</td>");
//			out.print("<td>" + c.getEmail() + "</td>");
//			out.print("<td>" + c.getPhoneNumber() + "</td>");
//			out.print("</tr>");
//		}
//
//		out.print("</table>");
//	out.print("<a href='http://localhost:8080/practice_servlet/'>Add Contact</a>");
//		out.print("</body></html>");

	}
	private synchronized void deleteContact(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("deleteid"));
		contacts.remove(id);
		request.setAttribute("contacts", contacts);
		request.getRequestDispatcher("viewcontact.jsp").forward(request, response);

	}
	private synchronized void updateContactdetails(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("updateid"));
	    Contact contact = contacts.get(id);
	    request.setAttribute("id", id);
	    request.setAttribute("contact", contact); // Corrected attribute key
	    request.getRequestDispatcher("editcontact.jsp").forward(request, response);
	}

	private synchronized void updateContacts(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    int id = Integer.parseInt(request.getParameter("updateid"));
	    String name = request.getParameter("name");
	    String phoneNumber = request.getParameter("phone");
	    String email = request.getParameter("email");
	    
	    // Update the existing contact in the list
	    Contact contactToUpdate = contacts.get(id);
	    if (contactToUpdate != null) {
	        contactToUpdate.setName(name);
	        contactToUpdate.setPhoneNumber(phoneNumber);
	        contactToUpdate.setEmail(email);
	    }
	  
	    

	    // Forward to the appropriate JSP
	    request.setAttribute("contacts", contacts);
	    request.getRequestDispatcher("viewcontact.jsp").forward(request, response);
	}

	


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String action = request.getParameter("action");
	        if (action != null) {
	            switch (action) {
	                case "add":
	                    addContact(request, response);
	                    break;
	                case "delete":
	                    deleteContact(request, response);
	                    break;
	                case "updatedetails":
	                	updateContactdetails(request, response);
	                case "update":
	                	updateContacts(request, response);
	                default:
	                    // Handle invalid action
	            }
	        }
	}

}

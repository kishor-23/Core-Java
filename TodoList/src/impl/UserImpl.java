package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.UserDAO;
import model.*;
import util.Dbconnection;


public class UserImpl implements UserDAO{

	@Override
	public void registerUser(String mailId, String name, String password)
			throws ClassNotFoundException, SQLException {
		// Connect to database
		Connection con = Dbconnection.getConnection();
		String selectQuery = "SELECT mailId,password FROM user WHERE mailId = ? ";
		PreparedStatement selectStatement = con.prepareStatement(selectQuery);
		selectStatement.setString(1, mailId);
		ResultSet resultSet = selectStatement.executeQuery();

		if (!resultSet.next()) {
			String insertQuery = "INSERT INTO user (mailId, name, password) VALUES (?, ?, ?)";
			PreparedStatement insertStatement = con.prepareStatement(insertQuery);
			insertStatement.setString(1, mailId);
			insertStatement.setString(2, name);
			insertStatement.setString(3, password);
			insertStatement.executeUpdate();
			System.out.println("User registered successfully.");
		} else {
			System.out.println("User already exists with this email ID.");
		}

	}

	@Override
	public User loginUser(String mailId, String password)
			throws ClassNotFoundException, SQLException {
		// Connect to database
		Connection con = Dbconnection.getConnection();
		String selectQuery = "SELECT mailId,password,name FROM user WHERE mailId = ? AND password = ?";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setString(1, mailId);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return new User(resultSet.getString("mailId"), resultSet.getString("name"),
					resultSet.getString("password"));
		} else {
			System.out.println("Invalid email ID or password. Please try again.");
			return null;
		}
	}

	public  ArrayList<User> listofUsers() throws ClassNotFoundException, SQLException {
		Connection con = Dbconnection.getConnection();
		String query = "select name,mailId,password from user";
		PreparedStatement ps = con.prepareStatement(query);
		ArrayList<User> list = new ArrayList();
		ResultSet resultSet = ps.executeQuery();
		while (resultSet.next()) {
		    String id = resultSet.getString("mailId");
			String name = resultSet.getString("name");
			String password= resultSet.getString("password");

			User u = new User();
			u.setMailId(id);
			u.setName(name);
			u.setPassword(password);
			list.add(u);
		}
		return list;
	}

}

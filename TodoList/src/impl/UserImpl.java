package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.UserDAO;
import model.*;
import util.Dbconnection;

public class UserImpl implements UserDAO {
	private Connection con;

	public UserImpl() throws ClassNotFoundException, SQLException {
		this.con = Dbconnection.getConnection();
	}

	@Override
	public void registerUser(String mailId, String name, String password) throws ClassNotFoundException, SQLException {
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
			System.out.println("User already exists with this email ID. use another email id to sign up or sign in ");
		}

	}

	@Override
	public User loginUser(String mailId, String password) throws ClassNotFoundException, SQLException {
		String selectQuery = "SELECT id,mailId,password,name FROM user WHERE mailId = ?";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setString(1, mailId);
		ResultSet resultSet = preparedStatement.executeQuery();
		// check if the user exists
		if (resultSet.next()) {
			// Check if the password matches
			if (password.equals(resultSet.getString("password"))) {
				// If password matches, return user object
				return new User(resultSet.getInt("id"),resultSet.getString("mailId"), resultSet.getString("name"),
						resultSet.getString("password"));
			} else {
				// If password does not match, indicate wrong password
				System.out.println("Wrong password. Please try again.");
				return null;
			}
		} else {
			// if user does not exist, indicate user does not exist
			System.out.println("User with email ID " + mailId + " does not exist.");
			return null;
		}
	}

	@Override
	public void deleteUser(int id) throws ClassNotFoundException, SQLException {
		String deleteQuery = "DELETE FROM user WHERE id = ?";
		PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
		deleteStatement.setInt(1, id);
		int rowsAffected = deleteStatement.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println("User with  ID " + id + " deleted successfully.");
		} else {
			System.out.println("User with  ID " + id + " not found.");
		}

	}

}

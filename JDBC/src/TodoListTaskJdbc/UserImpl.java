package TodoListTaskJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserImpl implements UserDao {
	String mailId;
	String name;
	String password;

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserImpl(String mailId, String name, String password) {

		this.mailId = mailId;
		this.name = name;
		this.password = password;
	}

	public UserImpl(String mailId, String password) {

		this.mailId = mailId;

		this.password = password;
	}

	@Override
	public void registerUser(String mailId, String name, String password, ArrayList<UserImpl> users)
			throws ClassNotFoundException, SQLException {
		// Connect to database
		Connection con = JdbcConnection.getConnection();
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
	public UserImpl loginUser(String mailId, String password, ArrayList<UserImpl> users)
			throws ClassNotFoundException, SQLException {
		// Connect to database
		Connection con = JdbcConnection.getConnection();
		String selectQuery = "SELECT mailId,password,name FROM user WHERE mailId = ? AND password = ?";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setString(1, mailId);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return new UserImpl(resultSet.getString("mailId"), resultSet.getString("name"),
					resultSet.getString("password"));
		} else {
			System.out.println("Invalid email ID or password. Please try again.");
			return null;
		}
	}

	public  ArrayList<UserImpl> listofUsers() throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		String query = "select name,mailId,password from user";
		PreparedStatement ps = con.prepareStatement(query);
		ArrayList<UserImpl> list = new ArrayList();
		ResultSet resultSet = ps.executeQuery();
		while (resultSet.next()) {
		    String id = resultSet.getString("mailId");
			String name = resultSet.getString("name");
			String password= resultSet.getString("password");

			UserImpl u = new UserImpl();
			u.setMailId(id);
			u.setName(name);
			u.setPassword(password);
			list.add(u);
		}
		return list;
	}


	UserImpl() {

	}

}

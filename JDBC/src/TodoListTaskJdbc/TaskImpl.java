package TodoListTaskJdbc;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import databaseconnection.JdbcConnection;

public class TaskImpl  implements TaskDao{
	int id;
	String name;
	String status;
	String date;
	String umail;

	public String getUmail() {
		return umail;
	}

	public void setUmail(String umail) {
		this.umail = umail;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public TaskImpl(String name, String status) {
		this.name = name;
		this.status = status;
	}

	TaskImpl() {

	}

	public TaskImpl(int id, String name, String status, String date) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.date = date;

	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", status=" + status + ", date=" + date + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public void displayTodayTasks(UserImpl user) throws ClassNotFoundException, SQLException {
	    Connection con = JdbcConnection.getConnection();
	    String selectQuery = "SELECT id, name, status, task_date FROM todo_task WHERE user_mail = ? AND task_date = ?";
	    PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
	    preparedStatement.setString(1, user.getMailId());
	   
	    // Get the current date
	    Date currentDate = new Date();
	    java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
	    preparedStatement.setDate(2, sqlCurrentDate);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    System.out.println("Tasks for User: " + user.getName() + " on " + sqlCurrentDate);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	  
	    while (resultSet.next()) {
	        int id = resultSet.getInt("id");
	        String name = resultSet.getString("name");
	        String status = resultSet.getString("status");
	        Date date = resultSet.getDate("task_date");
	        String formattedDate = dateFormat.format(date);

	        System.out.println("[ ID: " + id + ", Task: " + name + ", Status: " + status + ", Date: " + formattedDate+" ] ");
	    }
	}

	
	@Override
	public  void displayAllTasks(UserImpl user) throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		String selectQuery = "SELECT id, name, status, task_date FROM todo_task WHERE user_mail = ?;";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setString(1, user.getMailId());
		ResultSet resultSet = preparedStatement.executeQuery();

		System.out.println("Tasks for User: " + user.getName());
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String status = resultSet.getString("status");
			String date = resultSet.getString("task_date");

			System.out.println("[ ID: " + id + ", Task: " + name + ", Status: " + status + ", Date: " + date+" ] ");
		}

	}
	@Override
	public void updateTaskStatus(UserImpl user) throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter task id:");
		int id = sc.nextInt();
		sc.nextLine(); 
		System.out.println("update task status :");
		String status = sc.nextLine();
		String updateQuery = "UPDATE todo_task SET status = ? WHERE id = ? AND user_mail = ?";
		PreparedStatement ps = con.prepareStatement(updateQuery);
		ps.setString(1, status);
		ps.setInt(2, id);
		ps.setString(3, user.getMailId());
		int rowsAffected = ps.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println(rowsAffected +" Task status updated successfully.");
		} else {
			System.out.println("No task found with the given id for the user.");
		}

	}
	@Override
	public  void deleteTask(UserImpl user) throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter task id:");
		int id = sc.nextInt();
		String deleteQuery = "DELETE FROM todo_task WHERE id = ? AND user_mail = ?";
		PreparedStatement ps = con.prepareStatement(deleteQuery);
		ps.setInt(1, id);
		ps.setString(2, user.getMailId());
		int rowsAffected = ps.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println(rowsAffected+ ". Task deleted successfully.");
		} else {
			System.out.println("Task not found or you do not have permission to delete.");
		}

	}
	@Override
	public List<TaskImpl> listoftask(UserImpl user) throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();

		String selectQuery = "SELECT id, name, status, task_date FROM todo_task WHERE user_mail = ?;";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setString(1, user.getMailId());
		ResultSet resultSet = preparedStatement.executeQuery();
		List<TaskImpl> list = new ArrayList();
		System.out.println("Tasks for User id: " + user.getMailId());
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String status = resultSet.getString("status");
			String date = resultSet.getString("task_date");
			TaskImpl t = new TaskImpl(id, name, status, date);
			list.add(t);

		}

		return list;
	}
	@Override
	public  void addTask(UserImpl user) throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		String insertQuery = "insert into todo_task (name,status,task_date,user_mail) values(?,?,?,?) ";
		PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a todo task:");
		String task = sc.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String taskDate = format.format(Validation.getDate());
		preparedStatement.setString(1, task);
		preparedStatement.setString(2, "not done");
		preparedStatement.setString(3, taskDate);
		preparedStatement.setString(4, user.getMailId());
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " rows inserted");

	}


}

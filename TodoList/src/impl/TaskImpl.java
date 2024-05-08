package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.TaskDAO;
import model.Task;
import model.User;
import util.Dbconnection;

public class TaskImpl implements TaskDAO {
	private Connection con;

	public TaskImpl() throws ClassNotFoundException, SQLException {
		this.con = Dbconnection.getConnection();
	}

	@Override
	public void addTask(Task task) throws ClassNotFoundException, SQLException {
		String insertQuery = "insert into task (name,status, priority,task_date,user_mail) values(?,?,?,?,?);";
		PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		preparedStatement.setString(1, task.getName());
		preparedStatement.setString(2, task.getStatus());
		preparedStatement.setString(3, task.getPriority());
		preparedStatement.setString(4, task.getDate());
		preparedStatement.setString(5, task.getUsermail());
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " task inserted");
	}

	@Override
	public void displayAllTasks(User user) throws ClassNotFoundException, SQLException {
		String selectQuery = "SELECT id, name, status,priority, task_date  FROM task WHERE user_mail = ?"
				+ "ORDER BY CASE \r\n"
				+ "     WHEN  priority = \"high\" THEN 1\r\n"
				+ "     WHEN priority = \"medium\" THEN 2\r\n"
				+ "     WHEN priority = \"low\" THEN 3\r\n"
				+ "     END ASC,task_date asc  ;";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setString(1, user.getMailId());
		ResultSet resultSet = preparedStatement.executeQuery();

		System.out.println("Tasks for User: " + user.getName());
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String status = resultSet.getString("status");
			String date = resultSet.getString("task_date");
			String priority=resultSet.getString("priority");
			System.out.println("[ ID: " + id + ", Task: " + name + ", Status: " + status +", Priority: " + priority + ", Date: " + date + " ] ");
		}

	}

	@Override
	public void updateTaskStatus(Task task) throws ClassNotFoundException, SQLException {
		String updateQuery = "UPDATE task SET status = ? WHERE id = ? AND user_mail = ?";
		PreparedStatement ps = con.prepareStatement(updateQuery);
		ps.setString(1, task.getStatus());
		ps.setInt(2, task.getId());
		ps.setString(3, task.getUsermail());
		int rowsAffected = ps.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println(" Task status updated successfully.");
		} else {
			System.out.println("No task found with the given id for the user.");
		}

	}

	@Override
	public void deleteTask(int taskid, String usermail) throws ClassNotFoundException, SQLException {
		String deleteQuery = "DELETE FROM task WHERE id = ? AND user_mail = ?";
		PreparedStatement ps = con.prepareStatement(deleteQuery);
		ps.setInt(1, taskid);
		ps.setString(2, usermail);
		int rowsAffected = ps.executeUpdate();
		if (rowsAffected > 0) {
			System.out.println(" Task deleted successfully.");
		} else {
			System.out.println("Task not found or you do not have permission to delete.");
		}

	}

	public void displayTodayTasks(User user) throws ClassNotFoundException, SQLException {

		String selectQuery = "SELECT id, name, status,priority, task_date FROM task WHERE user_mail = ? AND  CAST(task_date AS DATE)=? AND status=\"not done\";";
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
			String priority=resultSet.getString("priority");

			System.out.println("[ ID: " + id + ", Task: " + name + ", Status: " + status +", Priority: " + priority + ", Date: " + formattedDate + " ] ");

		}
	}
	public void displayTasksByDate(String taskdate,User user) throws ClassNotFoundException, SQLException {

		String selectQuery = "SELECT id, name, status, task_date FROM task WHERE user_mail = ? AND  CAST(task_date AS DATE)=? AND status=\"not done\";";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setString(1, user.getMailId());
		preparedStatement.setString(2, taskdate);
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println("Tasks for User: " + user.getName() + " on " + taskdate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String status = resultSet.getString("status");
			Date date = resultSet.getDate("task_date");
			String formattedDate = dateFormat.format(date);
			String priority=resultSet.getString("priority");
			System.out.println(
					"[ ID: " + id + ", Task: " + name + ", Status: " + status +", Priority: " + priority+ ", Date: " + formattedDate + " ] ");
		}
	}

	@Override
	public void displayTodayAndNext5DaysTasks(User user) throws ClassNotFoundException, SQLException {
		String selectQuery = "SELECT id, name, status, task_date FROM task WHERE user_mail = ? AND task_date BETWEEN ? AND ?";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setString(1, user.getMailId());
		// Get the current date
		Date currentDate = new Date();
		java.sql.Date sqlCurrentDate = new java.sql.Date(currentDate.getTime());
		// Calculate date for 5 days after the current date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		calendar.add(Calendar.DATE, 5); // Add 5 days
		java.sql.Date sqlNext5DaysDate = new java.sql.Date(calendar.getTimeInMillis());
		preparedStatement.setDate(2, sqlCurrentDate);
		preparedStatement.setDate(3, sqlNext5DaysDate);
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println("Tasks for User: " + user.getName() + " from " + sqlCurrentDate + " to " + sqlNext5DaysDate);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String status = resultSet.getString("status");
			Date date = resultSet.getDate("task_date");
			String formattedDate = dateFormat.format(date);
			System.out.println("ID: " + id + ", Name: " + name + ", Status: " + status + ", Date: " + formattedDate);
		}

	}
}

package dao;

import java.sql.SQLException;
import java.util.List;

import model.Task;
import model.User;

public interface TaskDAO {

	void addTask(Task task) throws ClassNotFoundException, SQLException;

	void displayAllTasks(User user) throws ClassNotFoundException, SQLException;

	void deleteTask(int taskId, int userId) throws ClassNotFoundException, SQLException;

	void updateTaskStatus(Task task) throws ClassNotFoundException, SQLException;

	void displayTodayTasks(User user) throws ClassNotFoundException, SQLException;

	void displayTasksByDate(String taskdate,User user) throws ClassNotFoundException, SQLException;

	void displayTodayAndNext5DaysTasks(User user) throws ClassNotFoundException, SQLException;

}

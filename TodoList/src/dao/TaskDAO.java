package dao;

import java.sql.SQLException;
import java.util.List;

import model.Task;
import model.User;



public interface TaskDAO {
    void updateTaskStatus(User user) throws ClassNotFoundException, SQLException;
    void displayAllTasks(User user) throws ClassNotFoundException, SQLException;
    List<Task> listoftask(User user) throws ClassNotFoundException, SQLException;
    void addTask(User user) throws ClassNotFoundException, SQLException;
    void deleteTask(User user) throws ClassNotFoundException, SQLException;
    void displayTodayTasks(User user) throws ClassNotFoundException, SQLException;
    void displayTodayAndNext5DaysTasks(User user) throws ClassNotFoundException, SQLException ;

}

package dao;

import java.sql.SQLException;
import java.util.List;

import model.Task;
import model.User;



public interface TaskDAO {
    void updateTaskStatus(Task task) throws ClassNotFoundException, SQLException;
    void displayAllTasks(User user) throws ClassNotFoundException, SQLException;
    void addTask(Task task) throws ClassNotFoundException, SQLException;
    void deleteTask(int taskid,String usermail) throws ClassNotFoundException, SQLException;
    void displayTodayTasks(User user) throws ClassNotFoundException, SQLException;
    void displayTodayAndNext5DaysTasks(User user) throws ClassNotFoundException, SQLException ;

}
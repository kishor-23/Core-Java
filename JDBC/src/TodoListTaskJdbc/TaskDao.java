package TodoListTaskJdbc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TaskDao {
    void updateTaskStatus(UserImpl user) throws ClassNotFoundException, SQLException;
    void displayAllTasks(UserImpl user) throws ClassNotFoundException, SQLException;
    List<TaskImpl> listoftask(UserImpl user) throws ClassNotFoundException, SQLException;
    void addTask(UserImpl user) throws ClassNotFoundException, SQLException;
    void deleteTask(UserImpl user) throws ClassNotFoundException, SQLException;
    void displayTodayTasks(UserImpl user) throws ClassNotFoundException, SQLException;
}

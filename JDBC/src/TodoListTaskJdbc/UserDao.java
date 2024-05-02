package TodoListTaskJdbc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDao {
	 void registerUser(String mailId, String name, String password, ArrayList<UserImpl> users) throws ClassNotFoundException, SQLException;
	  UserImpl loginUser(String mailId, String password, ArrayList<UserImpl> users)  throws ClassNotFoundException, SQLException;
	  ArrayList<UserImpl> listofUsers() throws ClassNotFoundException, SQLException;
}

package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.User;



public interface UserDAO {
	 void registerUser(String mailId, String name, String password) throws ClassNotFoundException, SQLException;
	  User loginUser(String mailId, String password)  throws ClassNotFoundException, SQLException;
	  ArrayList<User> listofUsers() throws ClassNotFoundException, SQLException;
}

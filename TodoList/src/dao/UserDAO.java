package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.User;

public interface UserDAO {
	void registerUser(String mailId, String name, String password) throws ClassNotFoundException, SQLException;

	User loginUser(String mailId, String password) throws ClassNotFoundException, SQLException;

	void deleteUser(String mailId) throws ClassNotFoundException, SQLException;
}

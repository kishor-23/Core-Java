package dao;

import java.sql.SQLException;

import model.User;

public interface UserDAO {
	void registerUser(String mailId, String name, String password) throws ClassNotFoundException, SQLException;

	User loginUser(String mailId, String password) throws ClassNotFoundException, SQLException;

	void deleteUser(int userId) throws ClassNotFoundException, SQLException;
}

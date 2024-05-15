package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.HabitDAO;
import model.Habit;
import model.User;
import util.Dbconnection;

public class HabitImpl implements HabitDAO {
	private Connection con;

	public HabitImpl() throws ClassNotFoundException, SQLException {
		this.con = Dbconnection.getConnection();
	}
	
	public void addHabit(Habit habit) throws ClassNotFoundException, SQLException {
		String insertQuery = "insert into Habits(UserID,HabitName) values(?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		preparedStatement.setInt(1, habit.getUserID());
		preparedStatement.setString(2,habit.getHabitName());
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " habit inserted");
	}
	public void displayAllHabits(User user) throws ClassNotFoundException, SQLException {
		String selectQuery = "select HabitID,HabitName from Habits where userId=? ";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setInt(1, user.getId());
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int id = resultSet.getInt("HabitID");
			String name = resultSet.getString("Habitname");
			System.out.println("[ ID: " + id + ", Habit: " + name + " ] ");
		}

	}

	@Override
	public void deleteHabits(int habitid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}

}

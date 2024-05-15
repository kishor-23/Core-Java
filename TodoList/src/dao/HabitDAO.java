package dao;

import java.sql.SQLException;

import model.Habit;
import model.User;

public interface HabitDAO {
	void addHabit(Habit habit) throws ClassNotFoundException, SQLException ;
	void displayAllHabits(User user) throws ClassNotFoundException, SQLException;
	void deleteHabits(int habitid) throws ClassNotFoundException, SQLException;
}

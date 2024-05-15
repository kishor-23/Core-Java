package dao;

import java.sql.SQLException;

import model.HabitRecords;
import model.User;

public interface HabitRecodDAO {
	 void addHabitRecord(HabitRecords record) throws ClassNotFoundException, SQLException;
	 void displayAllHabitRecords(User user, int habitid) throws ClassNotFoundException, SQLException;
}

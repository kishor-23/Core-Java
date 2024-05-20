package dao;

import java.sql.SQLException;

import model.HabitRecords;
import model.User;

public interface HabitRecordDAO {
	
	void addHabitRecord(HabitRecords record) throws ClassNotFoundException, SQLException;

	void displayAllHabitRecords(User user, int habitid) throws ClassNotFoundException, SQLException;

	void updateHabitRecord(int recordid, String status) throws ClassNotFoundException, SQLException;

}

package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.HabitRecords;
import model.User;
import util.Dbconnection;

public class HabitRecordImpl {
	private Connection con;

	public HabitRecordImpl() throws ClassNotFoundException, SQLException {
		this.con = Dbconnection.getConnection();
	}
	public void addHabitRecord(HabitRecords record) throws ClassNotFoundException, SQLException {
	    // Check if the record already exists
	    String selectQuery = "SELECT COUNT(*) FROM Records WHERE userId = ? AND habitId = ? AND record_date = ?";
	    String select2Query = "SELECT COUNT(*) FROM Habits WHERE userId = ? AND HabitID = ? ";
	    PreparedStatement selectStatement = con.prepareStatement(selectQuery);
	    PreparedStatement ss = con.prepareStatement(select2Query);
	    selectStatement.setInt(1, record.getUserId());
	    selectStatement.setInt(2, record.getHabitId());
	    selectStatement.setString(3, record.getRecordDate());
	    ss.setInt(1, record.getUserId());
	    ss.setInt(2, record.getHabitId());
	    ResultSet resultSet = selectStatement.executeQuery();
	    ResultSet rs = ss.executeQuery();
	    rs.next();
	    int found=rs.getInt(1);
	    resultSet.next();
	    int existingRecords = resultSet.getInt(1);
	    
	    if (existingRecords == 0 && found!=0) {
	        // If the record doesn't exist, insert it
	        String insertQuery = "INSERT INTO Records (userId, habitId, record_date,status) VALUES (?, ?, ?,?)";
	        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
	        preparedStatement.setInt(1, record.getUserId());
	        preparedStatement.setInt(2, record.getHabitId());
	        preparedStatement.setString(3, record.getRecordDate());
	        preparedStatement.setString(4, record.getStatus());
	        int rows = preparedStatement.executeUpdate();
	        System.out.println(rows + " habit record inserted");
	    } else {
	        System.out.println("Record already exists");
	    }
	}

	public void displayAllHabitRecords(User user, int habitid) throws ClassNotFoundException, SQLException {
	    String selectQuery = "SELECT Records.HabitId, Habits.HabitName, Records.record_date, Records.status "
	            + "FROM Records "
	            + "INNER JOIN Habits ON Records.habitId = Habits.HabitID "
	            + "WHERE Records.userId = ? AND Records.habitId = ?";
	    PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
	    preparedStatement.setInt(1, user.getId());
	    preparedStatement.setInt(2, habitid);
	    ResultSet resultSet = preparedStatement.executeQuery();

	    while (resultSet.next()) {
	        int id = resultSet.getInt("HabitId");
	        String name = resultSet.getString("HabitName");
	        String date = resultSet.getString("record_date");
	        String status = resultSet.getString("status");
	        System.out.println("[ ID: " + id + ", Habit: " + name + ", Date: " + date + " status: " + status + " ]");
	    }
	}

}

package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.YearMonth;

import dao.EventDAO;
import model.Event;

import util.Dbconnection;

public class EventImpl implements EventDAO {
	private Connection con;

	public EventImpl() throws ClassNotFoundException, SQLException {
		this.con = Dbconnection.getConnection();
	}

	public void addEvent(Event event) throws ClassNotFoundException, SQLException {
		String insertQuery = "insert into events(UserID,event_name,event_date) values(?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		preparedStatement.setInt(1, event.getUserid());
		preparedStatement.setString(2,event.getEventName());
		preparedStatement.setString(3,event.getDate());
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " event inserted");
	}
	
	public void displayAllEvents( int id) throws ClassNotFoundException, SQLException {
		String selectQuery = "select eventid,event_name,event_date from events where userId=? ";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			int eventid = resultSet.getInt("eventID");
			String name = resultSet.getString("event_name");
			String date = resultSet.getString("event_date");
			System.out.println("[ EventID: " + eventid +" Event date : " + date + ", EventName: " + name + " ] ");
		}

	}
	public void deleteEvent(int eventid) throws ClassNotFoundException, SQLException {
		String insertQuery = "delete from events where eventid= ?";
		PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
		preparedStatement.setInt(1, eventid);
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " habit deleted");
	}
	 public void getCurrentMonthEvents(int userId) throws ClassNotFoundException, SQLException {
	        LocalDate now = LocalDate.now();
	        YearMonth currentMonth = YearMonth.of(now.getYear(), now.getMonth());
	        String selectQuery = "SELECT eventid, event_name, event_date FROM events WHERE userid=?  AND MONTH(event_date)=?";
	        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
	        preparedStatement.setInt(1, userId);
	        preparedStatement.setInt(2, currentMonth.getMonthValue());
	        ResultSet resultSet = preparedStatement.executeQuery();
	        while (resultSet.next()) {
	            int eventid = resultSet.getInt("eventid");
	            String name = resultSet.getString("event_name");
	            String date = resultSet.getString("event_date");
	            System.out.println("[EventID: " + eventid + " Event date: " + date + ", EventName: " + name + "]");
	        }
	    }
	

}

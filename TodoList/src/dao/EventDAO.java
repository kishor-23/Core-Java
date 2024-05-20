package dao;

import java.sql.SQLException;

import model.Event;

public interface EventDAO {
	void addEvent(Event event) throws ClassNotFoundException, SQLException;
	void displayAllEvents( int id) throws ClassNotFoundException, SQLException;
	void deleteEvent(int eventid) throws ClassNotFoundException, SQLException;
	

}

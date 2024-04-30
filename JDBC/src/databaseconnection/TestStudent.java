package databaseconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestStudent {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
		  Student student1 = new Student("Vikram", 25);
	     //   insertStudent(student1);
	    //    read();
	   //     updateStudent(4, "abinesh", 30);
	        readStudentDetails();
	  //      deleteStudent(1);
	 //       read();

	}
	
    public static void insertStudent(Student student) throws ClassNotFoundException, SQLException {
        Connection con = JdbcConnection.getConnection();
        String insertQuery = "INSERT INTO student (name, age) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(insertQuery);
        ps.setString(1, student.getName());
        ps.setInt(2, student.getAge());
        int rows = ps.executeUpdate();
        System.out.println(rows + " rows inserted");
    }

	   public static void readStudentDetails() throws ClassNotFoundException, SQLException {
	        Connection con = JdbcConnection.getConnection();
	        String selectQuery = "SELECT id, name, age FROM student";
	        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        System.out.println("Student Records:");
	        while (resultSet.next()) {
	            System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Age: " + resultSet.getInt("age"));
	        }
	    }
	    public static void updateStudent(int id, String name, int age) throws ClassNotFoundException, SQLException {
	        Connection con = JdbcConnection.getConnection();
	        String updateQuery = "UPDATE student SET name=?, age=? WHERE id=?";
	        PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
	        preparedStatement.setString(1, name);
	        preparedStatement.setInt(2, age);
	        preparedStatement.setInt(3, id);
	        int rows = preparedStatement.executeUpdate();
	        System.out.println(rows + " rows updated");
	    }
	    public static void deleteStudent(int id) throws ClassNotFoundException, SQLException {
	        Connection con = JdbcConnection.getConnection();
	        String deleteQuery = "DELETE FROM student WHERE id=?";
	        PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);
	        preparedStatement.setInt(1, id);
	        int rows = preparedStatement.executeUpdate();
	        System.out.println(rows + " rows deleted");
	    }

}

package demoJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentImpl implements StudentDao {
	private int id;
	private String name;
	private int age;

	public StudentImpl() {

	}

	public StudentImpl(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	public void insertStudent(StudentImpl student) throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		String insertQuery = "INSERT INTO student (name, age) VALUES (?, ?)";
		PreparedStatement ps = con.prepareStatement(insertQuery);
		ps.setString(1, student.getName());
		ps.setInt(2, student.getAge());
		int rows = ps.executeUpdate();
		System.out.println(rows + " rows inserted");
	}

	public void readStudentDetails() throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		String selectQuery = "SELECT id, name, age FROM student";
		PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
		ResultSet resultSet = preparedStatement.executeQuery();
		System.out.println("Student Records:");
		while (resultSet.next()) {
			System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Age: "
					+ resultSet.getInt("age"));
		}
		System.out.println();
	}

	public void updateStudent(int id, String name, int age) throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		String updateQuery = "UPDATE student SET name=?, age=? WHERE id=?";
		PreparedStatement preparedStatement = con.prepareStatement(updateQuery);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, age);
		preparedStatement.setInt(3, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " rows updated");
	}

	public void deleteStudent(int id) throws ClassNotFoundException, SQLException {
		Connection con = JdbcConnection.getConnection();
		String deleteQuery = "DELETE FROM student WHERE id=?";
		PreparedStatement preparedStatement = con.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, id);
		int rows = preparedStatement.executeUpdate();
		System.out.println(rows + " rows deleted");
	}

}
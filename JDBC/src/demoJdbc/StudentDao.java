package demoJdbc;

import java.sql.SQLException;

public interface StudentDao {
	void insertStudent(StudentImpl student) throws ClassNotFoundException, SQLException;
    void readStudentDetails() throws ClassNotFoundException, SQLException;
    void updateStudent(int id, String name, int age) throws ClassNotFoundException, SQLException ;
    void deleteStudent(int id) throws ClassNotFoundException, SQLException;

}

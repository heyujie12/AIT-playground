package model.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;

import model.Student;

public class StudentDAO {
@Resource(name="jdbc/test")
private DataSource ds;

public void addStudent(Student student){
	
	String sql = "INSERT INTO STUDENT VALUES('" + student.getIdStudent() + "', "+ student.getName() + "', " + student.getAge() + "', " + student.getYear();
	executeModifyQuery(sql);
}

public void executeModifyQuery(String sql){
	try{
		Connection conn = ds.getConnection();
		conn.createStatement().execute(sql);
	} catch (Exception e) {
		System.err.println(e.getMessage());
	}
}

	public ArrayList<Student> getAllStudent(){
		ArrayList<Student> list = new ArrayList<Student>();
		String sql = "SELECT FROM STUDENT";
		ResultSet rs = executeFetchQuery(sql);
		try{
			while(rs.next()){
				
				Student student = new Student();
				student.setIdStudent(rs.getInt("IDSTUDENTS"));
				student.setName(rs.getString("NAME"));
				student.setAge(rs.getString("AGE"));
				student.setYear(rs.getString("CLASS"));
				
				
			}
			
		}catch(SQLException ex){
			System.err.println(ex.getMessage());
			
		}
		return list;
		}

	public ResultSet executeFetchQuery(String sql){
		
		ResultSet rs = null;
		try{
		Connection conn=ds.getConnection();
		conn.createStatement().executeQuery(sql);
		conn.close();
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return rs;
	}

}

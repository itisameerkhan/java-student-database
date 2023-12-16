package StudentDatabase;

import java.sql.*;
import java.util.Scanner;

public class StudentDatabase
{
	static Connection con;
	private static void connect()
	{
		String url = "";
		String username = "";
		String password = "";
		try
		{
			con = DriverManager.getConnection(url,username,password);
		}catch(SQLException e) {}
	}
	public static void DisplayAllInfo() throws SQLException
	{
		connect();
		String query = "SELECT * FROM student";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
		rs.close();
		con.close();
	}
	public static void AddInfo(Student s) throws SQLException
	{
		connect();
		String q = "SELECT * FROM student";
		String query = "INSERT INTO student VALUES(?,?)";
		Statement st1 = con.createStatement();
		ResultSet cd = st1.executeQuery(q);
		while(cd.next())
		{
			try
			{
				if(cd.getInt(1) == s.rollno) { throw new DuplicateException();}
				if(s.sname.equals(cd.getString(2))) { throw new DuplicateException();}
			}catch(DuplicateException e) { 
				System.err.println("Entries Restricted"); 
				return;
			}
		}
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, s.rollno);
		st.setString(2,s.sname);
		int count = st.executeUpdate();
		System.out.println(count + " row(s) affected");
		System.out.println("Student Info Updated Sucessfully");
		st.close();
		con.close();
	}
	public static String findName(int rollno) 
	{
		connect();
		String query = "SELECT sname FROM student WHERE rollno = " + rollno;
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			String name = rs.getString(1);
			rs.close();
			con.close();
			return name;
		} catch(SQLException e) { System.err.println("Name not Found !"); }
		return null;
	}
	public static void DeleteStudentInfo(int rollno) 
	{
		connect();
		try
		{
			String query = "DELETE FROM student WHERE rollno = " + rollno;
			PreparedStatement st = con.prepareStatement(query);
			int count = st.executeUpdate();
			System.out.println(count + " rows(s) affected");
			System.out.println("Student Info Deleted Successfully");
			st.close();
			con.close();
		} catch(SQLException e) { System.err.println("Student Info Not Found"); }
	}
	public static void UpdateStudentName(int rollno, String name)
	{
		connect();
		String query = "UPDATE student SET sname = ? WHERE rollno = ? ";
		try
		{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(2,rollno);
			st.setString(1, name);
			int count = st.executeUpdate();
			System.out.println(count + " row(s) affected");
			System.out.println("Student Info Updated Successfully");
		}catch(SQLException e) { e.getMessage();}
	}
}

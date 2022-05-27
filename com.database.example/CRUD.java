package com.database.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CRUD {
	static final String driver="org.postgresql.Driver";
    static final String url="jdbc:postgresql://localhost:5432/";
    static final String user= "postgres";
    static final String pass= "postgres";
    public void crud(Student s1) {
    	Connection con = null;
    	Statement st= null;
    	try
    	{
    		Class.forName(driver);
    		con=DriverManager.getConnection(url,user,pass);
    		st=con.createStatement();
    		String insert="insert into student values("+s1.getId()+",'"+s1.getName()+"','"+s1.getCls()+"','"+s1.getGrade()+"')"; 		
    		st.executeUpdate(insert);
    		System.out.println("1 Row inserted into the table Student");
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
}


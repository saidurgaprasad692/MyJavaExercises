package com.database.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class DBConnection {
	static final String driver="org.postgresql.Driver";
    static final String url="jdbc:postgresql://localhost:5432/";
    static final String user= "postgres";
    static final String pass= "postgres";
    public static void main(String args[]) {
    	Connection con = null;
    	Statement st= null;
    	try
    	{
    		Class.forName(driver);
    		con=DriverManager.getConnection(url,user,pass);
    		st=con.createStatement();
    		//String db="create database College";
    		String table="create table Student(SID int primary key, SName varchar(20), Class varchar(4), Grade varchar(1))";
    		//st.executeUpdate(db);
    		st.executeUpdate(table);
    		System.out.println("Database(College) and Table(Student) are created successfully");
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
}


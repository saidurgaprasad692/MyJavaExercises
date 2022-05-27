package com.database.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class WhereClause {
	static final String driver="org.postgresql.Driver";
    static final String url="jdbc:postgresql://localhost:5432/";
    static final String user= "postgres";
    static final String pass= "postgres";
    public static void main(String args[]) {
    	Connection con = null;
    	Statement st= null;
    	char g;
    	Scanner sc=new Scanner(System.in);
    	try
    	{
    		Class.forName(driver);
    		con=DriverManager.getConnection(url,user,pass);
    		st=con.createStatement();
    		System.out.println("Enter Grade:");
    		g=sc.next().charAt(0);
    		String sql="select * from student where Grade='"+g+"'";
    		ResultSet table=st.executeQuery(sql);
    		while(table.next())
    		{
    			System.out.println(table.getInt("sid")+"\t"+table.getString("sname")+"\t"+table.getString("class")+"\t"+table.getString("grade"));
    		}
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	sc.close();
    }
}

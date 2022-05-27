package com.database.example;
import java.sql.*;
import java.util.Scanner;
public class CRUDSwitch {
	static final String driver="org.postgresql.Driver";
    static final String url="jdbc:postgresql://localhost:5432/";
    static final String user= "postgres";
    static final String pass= "postgres";
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student s1;
		Connection con = null;
    	Statement st= null;
    	try 
    	{
    		Class.forName(driver);
    		con=DriverManager.getConnection(url,user,pass);
    		st=con.createStatement();
    		System.out.println("Enter your query:");
    		char q=sc.next().charAt(0);
    		int sid;
    		String u,value;
    		switch(q)
    		{
    		case 'c': 	s1=StudentMain.getStudentDetails();
    					s1.calculateAvg();
    					s1.findGrade();
    					st.executeUpdate("insert into student values("+s1.getId()+",'"+s1.getName()+"','"+s1.getCls()+"','"+s1.getGrade()+"')");
    					System.out.println("1 row inserted");
    					break;
    		case 'r':	ResultSet rs=st.executeQuery("select * from student");
    					while(rs.next()) {
    						System.out.println(rs.getInt("sid")+"\t"+rs.getString("sname")+"\t"+rs.getString("class")+"\t"+rs.getString("grade"));
    					}
    					break;
    		case 'u':	System.out.println("What do you want to update?\n1. SName\n2. Class\n3. Student Grade");
    					u=sc.next();
    					System.out.println("Enter the value to update in "+u+":");
    					sc.nextLine();
    					value=sc.nextLine();
    					System.out.println("Student Id for which you want to update the information?");
    					sid=sc.nextInt();
    					st.executeUpdate("update student set "+u+"='"+value+"' where sid="+sid);
    					System.out.println("1 Row updated");
    					break;
    		case 'd': 	System.out.println("Student Id for which you want to delete the record for:");
    					sid=sc.nextInt();
    					st.executeUpdate("delete from student where sid="+sid);
    					System.out.println("1 Row deleted");
    					break;
    		default:	System.out.println("Invalid Query\nC->Create\nR->Read\nU->Update\nD->Delete");
    		}
    		
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    	sc.close();
	}

}

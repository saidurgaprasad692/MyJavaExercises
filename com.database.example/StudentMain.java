package com.database.example;

import java.util.Scanner;
public class StudentMain {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		Student s1=getStudentDetails();
		CRUD o=new CRUD();
		s1.calculateAvg();
		s1.findGrade();
		o.crud(s1);
	}
	public static Student getStudentDetails(){
		Student s1=new Student();
		System.out.println("Enter the id:");
		s1.setId(sc.nextInt());
		System.out.println("Enter the name:");
		sc.nextLine();
		s1.setName(sc.nextLine());
		System.out.println("Enter the Class:");
		s1.setCls(sc.next());
		int noOfSubjects;
		while(true) {
			System.out.println("Enter the no of subjects:");
			noOfSubjects=sc.nextInt();
			if(noOfSubjects>0) break;
			else System.out.println("Invalid number of subjects");
		}
		int[] marks=new int[noOfSubjects];
		for(int i=0;i<noOfSubjects;i++) {
			while(true){
				System.out.println("Enter mark for subject "+(i+1));
				marks[i]=sc.nextInt();
				if(marks[i]>0 && marks[i]<=100) break;
				else System.out.println("Invalid Mark");
			}
		}
		s1.setMarks(marks);
		return s1;
	}

}
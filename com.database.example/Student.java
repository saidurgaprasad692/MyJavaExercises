package com.database.example;

public class Student {
	private int id;
	private String name;
	private String cls;
	private int[] marks;
	private float average;
	private char grade;
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public int getId() {
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
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public void calculateAvg() {
		this.setAverage(0);
		for(int i=0;i<marks.length;i++)
		{
			this.setAverage(this.average+marks[i]);
		}
		this.setAverage(this.average/marks.length);
	}
	public void findGrade(){
		if(this.average>=80 && this.average<=100)this.setGrade('O');
		else if(this.average>=50 && this.average<=79)this.setGrade('A');
		else this.setGrade('F');
	}
	
}


import java.util.*;
import java.lang.*;
import java.io.*;


public class Course implements Serializable{

	private int id;
	
	

       private String name;
	
	private Subject subject;
	
	private ArrayList<User>students;
	
	private User teacher;
	

	public Course(){
	
		this.id = 0;
		
		this.name = "No name";
		
		this.subject = new Subject();
		
		this.students = new ArrayList<User>();
		
		this.teacher = new Teacher();
			
	}
	public Course(int id, String name, Subject subject, ArrayList<User> students, User teacher){
	
		this.id = id;
		
		this.name = name;
	
		this.subject = subject;
		
		this.students = students;
		
		this.teacher = teacher;
	
	}
	
	public void setId(int id){
		
		this.id = id;
		
	}
	
	public int getId(){
	
		return this.id;
	
	}
	
	public void setName(String name){
	
		this.name = name;
	
	}
	
	public String getName(){
	
		return this.name;
		
	}
	public void setSubject(Subject subject){
	
		this.subject = subject;
	
	}
	
	public Subject getSubject(){
	
		return this.subject;
		
	}
	public void setStudents(ArrayList<User> students){
	
	this.students=students;
		
	}
	public ArrayList<User> getStudents(){
	
		return this.students;
		
	}
	public void setTeacher(User teacher){
	
		this.teacher = teacher;
	
	}
	
	public User getTeacher(){
	
		return this.teacher;
		
	}
	public String getCourseData(){
		String z="";
		for (int i=0; i<students.size();i++){
			z += getStudents().get(i).getUserData()+", ";
		}
		return "ID :" + getId() + ", Name: " + getName() + ", Subject: "+getSubject().getName()+", Students:" +z+", Teacher: " + getTeacher().getUserData();
		
	}
	
}

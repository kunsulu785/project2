import java.io.*;

public class Teacher extends User implements Serializable{
	
	private String name;
	private String surname;
	private String degree;
	private String department;
	
	public Teacher(){
		
		super();
		
		this.name = "No name";
		
		this.surname = "No surname";
		
		this.degree = "No degree";
		
		this.department = "No department";
		
	}
	public Teacher(int id, String login, String password, String name, String surname, String degree, String department){
	
		super(id,login,password);
		
		this.name = name;
	
		this.surname = surname;
		
		this.degree = degree;
		
		this.department = department;
		
	}
	public void setName(String name){
	
		this.name = name;
	
	}
	
	public String getName(){
	
		return name;
		
	}
		
	public void setSurname(String surname){
	
		this.surname = surname;
	
	}
	
	public String getSurname(){
	
		return this.surname;
		
	}
	public void setDegree(String degree){
	
		this.degree = degree;
	
	}
	
	public String getDegree(){
	
		return this.degree;
		
	}
		
	public void setDepartment(String department){
	
		this.department = department;
	
	}
	
	public String getDepartment(){
	
		return this.department;
		
	}
	public String toString(){

			return "ID: "+ super.getId()+", Login: "+ super.getLogin()+ ", Password: "+super.getPassword()+", Name: " +getName()+ ", Surname: " +getSurname()+", Degree: " + getDegree()+", Department: "+getDepartment();
	
	}
	public String getUserData(){
		
		return "ID: "+ super.getId()+", Login: "+ super.getLogin()+ ", Password: "+super.getPassword()+", Name: " +getName()+ ", Surname: " +getSurname()+", Degree: " + getDegree()+", Department: "+getDepartment();
		
	} 	
}

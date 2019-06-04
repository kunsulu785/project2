import java.io.*;
public class Student extends User implements Serializable{
	
	private String name;
	private String surname;
	private String group;
	
	public Student(){
		
		super();
		
		this.name = "No name";
		
		this.surname = "No surname";
		
		this.group = "No group";
		
		
	}
	public Student(int id, String login, String password, String name, String surname, String group	){
	
		super(id,login,password);
		
		this.name = name;
	
		this.surname = surname;
		
		this.group = group;
		
		
	}
	public void setName(String name){
	
		this.name = name;
	
	}
	
	public String getName(){
	
		return this.name;
		
	}
		
	public void setSurname(String surname){
	
		this.surname = surname;
	
	}
	
	public String getSurname(){
	
		return this.surname;
		
	}
	public void setGroup(String group){
	
		this.group = group;
	
	}
	public String getGroup(){
	
		return this.group;
		
	}
	public String getUserData(){
		
		return "ID: "+ super.getId()+", Login: "+ super.getLogin()+ ", Password: "+super.getPassword()+", Name: " +getName()+ ", Surname: " +getSurname()+", group: "+getGroup();
		
	} 
}

import java.io.*;
public class Subject implements Serializable{

	private int id;
	
	private String name;
	
	private String description;
	

	public Subject(){
	
		this.id = 0;
		
		this.name = "No name";
		
		this.description = "No description";
			
	}
	public Subject(int id, String name, String description){
	
		this.id = id;
		
		this.name = name;
	
		this.description = description;
		
	
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
	public void setDescription(String description){
	
		this.description = description;
	
	}
	
	public String getDescription(){
	
		return this.description;
		
	}
	public String getSubjectData(){
	
		return "ID :" + getId() + ", Name: " + getName() + ", Description: "+getDescription();
	
	}
}

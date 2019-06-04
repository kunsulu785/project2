import java.io.*;

public abstract class User implements Serializable{

	private int id;
	private String login;
	private String password;
	
	public User(){
		
		this.id = 0;
		this.login = "No Login";
		this.password = "No Password";
		
	}
	
	public User(int id, String login, String password){
		
		this.id = id;
		this.login = login;
		this.password = password;
		
	}
	public void setId(int id){
		
		this.id = id;
		
	}
	
	public int getId(){
	
		return this.id;
	
	}
	
	public void setLogin(String login){
	
		this.login = login;
	
	}
	
	public String getLogin(){
	
		return this.login;
		
	}
	public void setPassword(String password){
	
		this.password = password;
	
	}
	
	public String getPassword(){
	
		return this.password;
		
	}
	public abstract String getUserData();
}

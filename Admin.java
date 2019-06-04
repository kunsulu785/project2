import java.io.*;
public class Admin extends User implements Serializable{

	public Admin(){
		
		
super();
		
	}
	
public Admin(int id, String login, String password){
	
		super(id,login,password);
		
	}
	

public String getUserData(){
		
return super.getId()+", Login: "+ super.getLogin()+ ", Password: "+super.getPassword();
		
	} 
}

import java.util.HashMap;

public class UserLoginData {

	HashMap<String,String> logininfo = new HashMap<String,String>();
	
	UserLoginData(){
		
		logininfo.put("Wojtek", "12345");
		
	}
	UserLoginData(String username, String password){
		
		logininfo.put("Wojtek", "12345");
		logininfo.put(username, password);
	}
	
	protected HashMap getLoginInfo(){
		return logininfo;
	}
	
}

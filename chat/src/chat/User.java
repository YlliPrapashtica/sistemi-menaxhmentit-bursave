package chat;
import java.io.Serializable;


public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String userIP;
	private String serverIP;
	private String time;
	
	public User(String name, String userIP, String serverIP, String time){
		this.name= name;
		this.userIP= userIP;
		this.serverIP=serverIP;
		this.time= time;		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	public String getUserIP() {
		return userIP;
	}

	public void setMyIP(String userIP) {
		this.userIP = userIP;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	
	
}

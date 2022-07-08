package Login_RMI_JDBC;

public class User {
	
	String user, pass;
	
	public User() {
		
	}

	public User(String acc, String pass) {
		this.user = acc;
		this.pass = pass;
	}

	public String getAcc() {
		return user;
	}

	public void setAcc(String acc) {
		this.user = acc;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public String toXML() {
		return "\r" + "\t\t" + "<User>\r\n" +
				"\t\t\t" + "<user>"+ user +"</user>\r\n" +
				"\t\t\t" + "<pass>"+ pass +"</pass>\r\n"
				+ "\t\t" + "</User>";
	}
}

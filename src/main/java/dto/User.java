package dto;

public class User {
	
	private int userid;
	private String username;
	private String useremail;
	private long usercontact;
	private String userpassword;
	private byte[] userimage;
	
	public User(int id, String name, String email, long contact, String password, byte[] image) {
		
		super();
		this.userid = id;
		this.username = name;
		this.useremail = email;
		this.usercontact = contact;
		this.userpassword = password;
		this.userimage = image;
	}
	
	public User() {
		super();
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public long getUsercontact() {
		return usercontact;
	}
	public void setUsercontact(long usercontact) {
		this.usercontact = usercontact;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public byte[] getUserimage() {
		return userimage;
	}
	public void setUserimage(byte[] userimage) {
		this.userimage = userimage;
	}
	
	
	
	
	
}
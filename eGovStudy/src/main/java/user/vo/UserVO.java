package user.vo;

import java.io.Serializable;

public class UserVO implements Serializable{
	private String userid ;     //varchar2(15) primary key,
	private String username ;   //varchar2(20),
	private String userpwd ;    //varchar2(10),
	private String email ;      //varchar2(50),
	private String phone ;      //varchar2(15),
	private String address ;    //varchar2(100)
	
	public UserVO() {	}
	
	public UserVO(String userid, String username, 
			      String userpwd, String email,
			      String phone, String address) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserVO [userid=" + userid + ", username=" + username
				+ ", userpwd=" + userpwd + ", email=" + email + ", phone="
				+ phone + ", address=" + address + "]";
	}
}

package cn.jbit.house.web;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	// Fields
	private String username;
	private String password;
	
	// Properties accessors
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception {
		if ((getUsername() == null || getUsername().equals("")) || (getPassword() == null || getPassword().equals(""))) {
			return INPUT;
		}
		return SUCCESS;
	}
	
}

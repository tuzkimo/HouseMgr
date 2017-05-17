package cn.jbit.house.web;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.jbit.house.entity.User;

public class LoginActionBean extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{

	// Fields
	private User user;
	private String nextDispose;
	
	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;

	// Properties accessors
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getNextDispose() {
		return nextDispose;
	}
	public void setNextDispose(String nextDispose) {
		this.nextDispose = nextDispose;
	}
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	
	@Override
	public String execute() throws Exception {
		if ((getUser().getUsername() == null || getUser().getUsername().equals("")) || (getUser().getPassword() == null || getUser().getPassword().equals(""))) {
			return INPUT;
		}
//		if (getUser().getUsername().equals("god")) {
//			setNextDispose("god");
//		}
//		if (getUser().getUsername().equals("mortal")) {
//			setNextDispose("mortal");
//		}
//		Map<String, Object> session = ActionContext.getContext().getSession();
		session.put("username", getUser().getUsername());
		return SUCCESS;
	}
	
}

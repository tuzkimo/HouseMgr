package cn.jbit.house.web;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import cn.jbit.house.entity.User;

public class LoginActionModelDriven implements ModelDriven<User>,Action {
	
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		if ((getModel().getUsername() == null || getModel().getUsername().equals("")) || (getModel().getPassword() == null || getModel().getPassword().equals(""))) {
			return INPUT;
		}
		return SUCCESS;
	}
	
}

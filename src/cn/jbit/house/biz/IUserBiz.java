package cn.jbit.house.biz;

import cn.jbit.house.entity.User;

public interface IUserBiz {

	void register(User user);
	
	User login(String username, String password);
	
}

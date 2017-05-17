package cn.jbit.house.dao;

import cn.jbit.house.entity.User;

public interface IUserDao {

	void insert(User user);
	
	User select(String username, String password);
	
}

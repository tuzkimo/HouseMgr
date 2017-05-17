package cn.jbit.house.biz.impl;

import cn.jbit.house.biz.IUserBiz;
import cn.jbit.house.dao.IUserDao;
import cn.jbit.house.dao.impl.UserDaoImpl;
import cn.jbit.house.entity.User;

public class UserBizImpl implements IUserBiz {

	private IUserDao userDao = new UserDaoImpl();
	
	@Override
	public void register(User user) {
		this.userDao.insert(user);
	}

	@Override
	public User login(String username, String password) {
		return this.userDao.select(username, password);
	}

}

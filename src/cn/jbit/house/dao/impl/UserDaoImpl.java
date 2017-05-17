package cn.jbit.house.dao.impl;

import org.hibernate.Session;

import cn.jbit.house.dao.HibernateUtil;
import cn.jbit.house.dao.IUserDao;
import cn.jbit.house.entity.User;

public class UserDaoImpl implements IUserDao {

	@Override
	public void insert(User user){
		Session session = HibernateUtil.currentSession();
		try {
			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public User select(String username, String password){
		User user = new User();
		try {
			Session session = HibernateUtil.currentSession();
			String hql = "from User where username = :username and password = :password";
			user = (User)session.createQuery(hql)
					.setString("username", username).setString("password", password)
					.setMaxResults(1).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession();
		}
		return user;
	}

}

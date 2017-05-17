package cn.jbit.house.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	
	static {
		try {
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	
	public static Session currentSession() {
		Session currentSession = threadLocal.get();
		if (currentSession == null) {
			currentSession = sessionFactory.openSession();
			threadLocal.set(currentSession);
		}
		return currentSession;
	}
	
	public static void closeSession() {
		Session currentSession = threadLocal.get();
		if (currentSession != null) {
			currentSession.close();
		}
		threadLocal.set(null);
	}
	
}

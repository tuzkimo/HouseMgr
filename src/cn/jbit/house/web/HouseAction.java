package cn.jbit.house.web;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import cn.jbit.house.dao.HibernateUtil;
import cn.jbit.house.entity.House;
import cn.jbit.house.entity.Street;

public class HouseAction extends ActionSupport {
	
	// Fields
	private Street street;
	
	// Properties accessors
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	
	// Methods
	public String add() throws Exception {
//		int result = 1 / 0;
		System.out.println("添加成功！");
		return SUCCESS;
	}
	

	public String update() throws Exception {
		System.out.println("修改成功！");
		return SUCCESS;
	}
	
	public String view() throws Exception {
		Session session = HibernateUtil.currentSession();
		street = session.load(Street.class, 2);
		HibernateUtil.closeSession();
		return SUCCESS;
	}
	
}

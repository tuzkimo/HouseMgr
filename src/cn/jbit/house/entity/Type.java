package cn.jbit.house.entity;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import cn.jbit.house.dao.HibernateUtil;

public class Type {

	// Fields
	private Integer id;
	private String name;
	private Set<House> houses;
	
	// Constructors
	// Default constructor
	public Type() {
		super();
		houses = new HashSet<House>();
	}

	// Minimal constructor
	public Type(String name) {
		super();
		this.name = name;
		houses = new HashSet<House>();
	}

	// Properties accessors
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<House> getHouses() {
		return houses;
	}
	public void setHouses(Set<House> houses) {
		this.houses = houses;
	}
	
	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		session.getTransaction().begin();
		
		session.save(new Type("三室"));
		session.save(new Type("四室"));
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
	
}

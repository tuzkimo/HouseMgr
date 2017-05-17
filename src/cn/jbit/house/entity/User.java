package cn.jbit.house.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import cn.jbit.house.dao.HibernateUtil;

public class User {

	// Fields
	private Integer id;
	private String username;
	private String password;
	private String telephone;
	private Set<House> houses;
	
	// Constructors
	// Default constructor
	public User() {
		super();
		houses = new HashSet<House>();
	}
	
	// Minimal constructor
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		houses = new HashSet<House>();
	}
	
	// Full constructor
	public User(String username, String password, String telephone) {
		super();
		this.username = username;
		this.password = password;
		this.telephone = telephone;
		houses = new HashSet<House>();
	}

	// Properties accessors
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
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
		
//		session.save(new User("尼玛", "p123456", "15123456789"));
		
		List<User> users = session.createQuery("from User u left join fetch u.houses").list();
		for (User user : users) {
			System.out.println(user.getUsername() + ", " + user.getHouses());
		}
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
	
}

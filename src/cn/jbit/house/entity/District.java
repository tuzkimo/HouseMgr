package cn.jbit.house.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.Session;

import cn.jbit.house.dao.HibernateUtil;

@Entity
public class District {

	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String name;
	@OneToMany(mappedBy="street",cascade=CascadeType.ALL)
	private Set<Street> streets;
	
	// Constructors
	// Default constructor
	public District() {
		super();
		streets = new HashSet<Street>();
	}

	// Minimal constructor
	public District(String name) {
		super();
		this.name = name;
		streets = new HashSet<Street>();
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
	
	public Set<Street> getStreets() {
		return streets;
	}

	public void setStreets(Set<Street> streets) {
		this.streets = streets;
	}

	public static void main(String[] args) {
		Session session = HibernateUtil.currentSession();
		session.getTransaction().begin();
//		session.save(new District("test"));
//		session.save(new District("禅城区"));
//		session.save(new District("南海区"));
//		session.save(new District("顺德区"));
//		session.save(new District("高明区"));
//		session.save(new District("三水区"));
		District district = session.load(District.class, 4);
		System.out.println(district.getName());
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
}

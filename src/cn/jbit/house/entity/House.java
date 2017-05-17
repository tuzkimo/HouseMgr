package cn.jbit.house.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;

import cn.jbit.house.dao.HibernateUtil;
import cn.jbit.house.util.Tool;

public class House {

	// Fields
	private Integer id;
	private String name;
	private Integer price;
	private Date pubdate;
	private Street street;
	private User user;
	private Type type;
	
	// Constructors
	// Default constructor
	public House() {
		super();
	}

	// Minimal constructor
	public House(String name) {
		super();
		this.name = name;
	}
	
	// Full constructor
	public House(String name, Integer price, Date pubdate, Street street, User user, Type type) {
		super();
		this.name = name;
		this.price = price;
		this.pubdate = pubdate;
		this.street = street;
		this.user = user;
		this.type = type;
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
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}

	public static void main(String[] args) throws HibernateException, ParseException {
		Session session = HibernateUtil.currentSession();
		session.getTransaction().begin();
		
//		Street street = session.load(Street.class, 13);
//		House house = new House("俊雅花园", 1100000, new Date(), street);
//		session.save(house);
		
//		List<Object[]> houses = session.createQuery("select h.street.district.name, avg(price), max(price), min(price) from House h group by h.street.district.name").list();
//		for (Object[] objects : houses) {
//			System.out.println(objects[0] + " ~ " + objects[1] + " ~ " + objects[2] + " ~ " + objects[3]);
//		}
		
//		User user = session.load(User.class, 2);
//		List<House> houses = session.createQuery("from House where id > 1").list();
//		for (House house : houses) {
//			house.setUser(user);
//		}
		
//		List<House> houses = session.createQuery("from House h where h.user.username = '尼玛'").list();
//		for (House house : houses) {
//			System.out.println(house.getName() + ", " + house.getPrice());
//		}
		
//		List<House> houses = session.createSQLQuery("select h.* from House h, Street s where h.street_id = s.id and s.name = :name")
//				.addEntity("h", cn.jbit.house.entity.House.class).setString("name", "汾江南路").list();
		
//		List<House> houses = session.createNamedQuery("selectHouse").setString("name", "绿景一路").list();
		
//		List<House> houses = session.createCriteria(House.class).add(Restrictions.lt("price", 1000000)).add(Restrictions.gt("pubdate", Tool.strToDate("2017-01-15", "yyyy-MM-dd"))).list();
		
//		List<House> houses = session.createCriteria(House.class, "h")
//				.add(Restrictions.ge("price", 1000000))
//				.createAlias("h.type", "t")
//				.add(Restrictions.eq("t.name", "三室"))
//				.createAlias("h.street", "s")
//				.createAlias("s.district", "d")
//				.add(Restrictions.eq("d.name", "禅城区"))
//				.addOrder(Order.asc("price"))
//				.addOrder(Order.desc("pubdate"))
//				.setFirstResult(0)
//				.setMaxResults(3)
//				.list();
		
//		List<Object[]> objects = session.createCriteria(House.class, "h")
//				.createAlias("h.street", "s")
//				.createAlias("s.district", "d")
//				.setProjection(Projections.projectionList()
//						.add(Projections.groupProperty("d.name"))
//						.add(Projections.avg("price"), "p")
//						)
//				.addOrder(Order.asc("p"))
//				.list();
				
//		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(House.class);
//		List<House> houses = detachedCriteria.getExecutableCriteria(session).list();
//		
//		for (House house : houses) {
//			System.out.println(house.getName() + ", " + house.getPrice() + ", " + house.getPubdate());
//		}
		
//		House house = new House("尼玛居");
//		Street street = new Street("暴走路");
//		house.setStreet(street);
//		session.save(street);
//		session.save(house);
		
//		for (Object[] object : objects) {
//			System.out.println(object[0] + ", " + object[1]/* + " ~ " + object[2] + " ~ " + object[3]*/);
//		}
		
//		House house = session.load(House.class, 11);
//		Type type = session.load(Type.class, 2);
//		house.setType(type);
		
//		List<House> houses = session.createCriteria(House.class, "h")
//				.createAlias("h.street", "s")
//				.add(Restrictions.eq("s.name", "汾江南路"))
//				.list();
//		
//		Iterator<House> it = houses.iterator();
//		
//		while (it.hasNext()) {
//			House house = it.next();
//			System.out.println(house.getName() + ", " + house.getPrice() + ", " + house.getPubdate());
//		}
		
//		String hql = "UPDATE House SET price = price-:step WHERE price > :price";
//		session.createQuery(hql).setParameter("step", 500000).setParameter("price", 1000000).executeUpdate();
		
//		Work work = new Work() {
//			
//			@Override
//			public void execute(Connection connection) throws SQLException {
//				// TODO Auto-generated method stub
//				String sql = "UPDATE House SET name = ?+name";
//				PreparedStatement ps = connection.prepareStatement(sql);
//				ps.setString(1, "出售:");
//				ps.executeUpdate();
//			}
//		};
//		
//		session.doWork(work);
		House house = (House) session.createCriteria(House.class).add(Restrictions.eq("id", 2)).uniqueResult();
		System.out.println(house.getName());
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
}

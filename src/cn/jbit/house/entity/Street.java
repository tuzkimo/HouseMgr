package cn.jbit.house.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.Session;

import cn.jbit.house.dao.HibernateUtil;

@Entity
public class Street {

	// Fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String name;
	@ManyToOne
	@JoinColumn(name="district_id")
	private District district;
	@Transient
	private Set<House> houses;
	
	// Constructors
	// Default constructor
	public Street() {
		super();
		houses = new HashSet<House>();
	}

	// Minimal constructor
	public Street(String name) {
		super();
		this.name = name;
		houses = new HashSet<House>();
	}
	
	// Full constructor
	public Street(String name, District district) {
		super();
		this.name = name;
		this.district = district;
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
	
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
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
//		District district = session.load(District.class, 1);
//		session.save(new Street("test", district));
//		session.save(new Street("季华五路", district));
//		session.save(new Street("汾江南路", district));
//		session.save(new Street("绿景一路", district));
//		District district = session.load(District.class, 2);
//		for (int i = 2; i < 5; i++) {
//			Street street = session.load(Street.class, i);
//			street.setDistrict(district);
//		}
//		Street street = session.load(Street.class, 4);
//		session.delete(street);
		
		
//		Street street = session.load(Street.class, 2);
//		District district = street.getDistrict();
//		System.out.println(district.getId() + "~~" + district.getName());
		
//		District district = session.load(District.class, 2);
//		Street street = session.load(Street.class, 9);
//		district.getStreets().add(street);
//		street.setDistrict(district);
		
//		District district = session.load(District.class, 3);
//		Street street = new Street("海五路");
//		street.setDistrict(district);
//		session.save(street);
		
//		Street street = session.load(Street.class, 3);
//		Set<House> houses = street.getHouses();
//		for (House house : houses) {
//			System.out.println(house.getName());
//		}
		
//		List<Object[]> streets = session.createQuery("select s.name, s.houses.size from Street s").list();
//		for (Object[] street : streets) {
//			System.out.println(street[0] + ", " + street[1]);
//		}
		
		session.getTransaction().commit();
		HibernateUtil.closeSession();
	}
}

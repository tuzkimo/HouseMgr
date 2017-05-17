package cn.jbit.house.dao.impl;

import java.util.List;

import org.hibernate.Session;

import cn.jbit.house.dao.HibernateUtil;
import cn.jbit.house.dao.IHouseDao;
import cn.jbit.house.entity.House;
import cn.jbit.house.entity.HouseCondition;
import cn.jbit.house.entity.PageInfo;
import cn.jbit.house.util.Tool;

public class HouseDaoImpl implements IHouseDao {

	@SuppressWarnings("deprecation")
	@Override
	public PageInfo<House> selectHouse(PageInfo<House> pageInfo, HouseCondition houseCondition) {
		try {
			// 创建检索符合条件的 House 的 HQL 语句
			StringBuilder hql = new StringBuilder(" from House where 1=1");
			if (houseCondition.getTitle() != null) {
				hql.append(" and name like :title");
			}
			if (houseCondition.getStartPrice() != null) {
				hql.append(" and price >= :startPrice");
			}
			if (houseCondition.getEndPrice() != null) {
				hql.append(" and price <= :endPrice");
			}
			if (houseCondition.getStartDate() != null) {
				hql.append(" and pubdate >= :startDate");
			}
			if (houseCondition.getEndDate() != null) {
				hql.append(" and pubdate <= :endDate");
			}
			hql.append(" order by pubdate desc");
			// 创建检索符合条件的 House 总数的 HQL 语句
			String countHql = "select count(*)" + hql.toString();
			// 获取 Hibernate 当前 session
			Session session = HibernateUtil.currentSession();
			// 检索检索符合条件的 House 总数
			Long count = (Long) session.createQuery(countHql).setProperties(houseCondition).uniqueResult();
			pageInfo.setCount(count.intValue());
			// 检索检索符合条件的 House 记录列表
			List<House> list = session.createQuery(hql.toString()).setProperties(houseCondition)
					.setFirstResult((pageInfo.getPageIndex() - 1) * pageInfo.PAGE_SIZE)
					.setMaxResults(pageInfo.PAGE_SIZE).list();
			pageInfo.setPageList(list);
		} finally {
			HibernateUtil.closeSession();
		}
		return pageInfo;
	}
	
	/* Test
	public static void main(String[] args) {
		HouseCondition houseCondition = new HouseCondition();
		houseCondition.setTitle("星城");
		houseCondition.setStartPrice(8000);
		houseCondition.setEndPrice(12000);
		houseCondition.setStartDate(Tool.getDate(-1));
		houseCondition.setEndDate(Tool.getDate(1));
		
		PageInfo<House> pageInfo = new PageInfo<House>();
		pageInfo.setPageIndex(1);
		
		pageInfo = new HouseDaoImpl().selectHouse(pageInfo, houseCondition);
		
		System.out.println(pageInfo.getPageList().get(0).getName());
	}*/

}

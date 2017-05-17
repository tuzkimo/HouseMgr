package cn.jbit.house.biz.impl;

import cn.jbit.house.biz.IHouseBiz;
import cn.jbit.house.dao.IHouseDao;
import cn.jbit.house.dao.impl.HouseDaoImpl;
import cn.jbit.house.entity.House;
import cn.jbit.house.entity.HouseCondition;
import cn.jbit.house.entity.PageInfo;

public class HouseBizImpl implements IHouseBiz {
	
	private IHouseDao houseDao = new HouseDaoImpl();

	@Override
	public PageInfo<House> search(PageInfo<House> pageInfo, HouseCondition houseCondition) {
		return houseDao.selectHouse(pageInfo, houseCondition);
	}

}

package cn.jbit.house.dao;

import cn.jbit.house.entity.House;
import cn.jbit.house.entity.HouseCondition;
import cn.jbit.house.entity.PageInfo;

public interface IHouseDao {

	PageInfo<House> selectHouse(PageInfo<House> pageInfo, HouseCondition houseCondition);
	
}

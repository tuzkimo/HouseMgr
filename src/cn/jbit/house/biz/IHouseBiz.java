package cn.jbit.house.biz;

import cn.jbit.house.entity.House;
import cn.jbit.house.entity.HouseCondition;
import cn.jbit.house.entity.PageInfo;

public interface IHouseBiz {

	PageInfo<House> search(PageInfo<House> pageInfo, HouseCondition houseCondition);
}

package cn.jbit.house.entity;

import java.util.Date;

public class HouseCondition {

	private String title;
	private Integer startPrice;
	private Integer endPrice;
	private Date startDate;
	private Date endDate;
	
	// Properties accessors;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(Integer startPrice) {
		this.startPrice = startPrice;
	}
	public Integer getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(Integer endPrice) {
		this.endPrice = endPrice;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}

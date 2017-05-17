package cn.jbit.house.entity;

import java.util.List;

public class PageInfo<T> {

	public static final Integer PAGE_SIZE = 3;
	private Integer count;
	private List<T> pageList;
	private Integer pageIndex;
	private Integer totalPages;
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getTotalPages() {
		this.totalPages = this.count / this.PAGE_SIZE;
		if (this.count % this.PAGE_SIZE != 0) {
			totalPages++;
		}
		return totalPages;
	}
	
}

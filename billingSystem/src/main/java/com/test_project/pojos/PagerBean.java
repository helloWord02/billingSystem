package com.test_project.pojos;



import java.util.List;
import java.util.Map;

public class PagerBean {

	/**
	 * 当前的页数
	 */
	private int page;
	/**
	 * 每页显示的行数
	 */
	private int rows;
	/**
	 * 分页开始行数（数据库的下标）
	 */
	private int index;
	/**
	 * 满足条件的总行数
	 */
	private int totalRows;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 满足条件的具体的数据
	 */
	private List<?> datas;
	/**
	 * 查询条件Map 
	 */
	private Map params;
	public PagerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PagerBean(int page, int rows, Map params) {
		super();
		this.page = page;
		this.rows = rows;
		this.params = params;
		
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getIndex() {
		index = (page - 1) * rows;
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		totalPage = (totalRows % rows == 0) ? (totalRows / rows) : (totalRows / rows + 1);
		this.totalRows = totalRows;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<?> getDatas() {
		return datas;
	}
	public void setDatas(List<?> datas) {
		this.datas = datas;
	}
	public Map getParams() {
		return params;
	}
	public void setParams(Map params) {
		this.params = params;
	}
	@Override
	public String toString() {
		return "PagerBean [page=" + page + ", rows=" + rows + ", totalRows=" + totalRows + ", totalPage=" + totalPage
				+ ", datas=" + datas + ", params=" + params + "]";
	}
}

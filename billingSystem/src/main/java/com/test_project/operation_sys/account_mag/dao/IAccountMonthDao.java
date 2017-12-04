package com.test_project.operation_sys.account_mag.dao;

import java.util.List;

import com.test_project.bean.AccountDayBean;
import com.test_project.bean.AccountMonthBean;
import com.test_project.bean.AccountYearBean;
import com.test_project.pojos.PagerBean;

public interface IAccountMonthDao {
	/**
	 * 通过所有的账务日数据，计算加入账务月
	 * @param ab
	 */
	public void saveAccountMonth(AccountMonthBean ab);

	
	/**
	 * 查询实验室当月的总时长
	 * @param page--（Map中放入year、month；Map中放year、month、Ip）
	 * @return PagerBean--返回账务月分页对象
	 */
	public PagerBean findAccountMonthByPage(PagerBean page);
	
	/**
	 * 根据传入的月查询所有账务月总时长
	 * @param month
	 * @return
	 */
	public  List<AccountYearBean> findAccountMonth (String month);
	 
}

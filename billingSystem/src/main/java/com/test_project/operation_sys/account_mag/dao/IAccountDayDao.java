package com.test_project.operation_sys.account_mag.dao;

import java.util.List;

import com.test_project.bean.AccountDayBean;
import com.test_project.bean.AccountMonthBean;
import com.test_project.pojos.PagerBean;

public interface IAccountDayDao  {
	/**
	 * 用定时器上传账务日数据
	 * @param ab
	 */
	public void saveAccountDay(AccountDayBean ab);
		
	/**
	 * 查询所有的（实验室）的总时长
	 *
	 * @param page--params中传入每页行数和当前页数
	 * @return  PagerBean--返回账务日分页对象
	 */
	public PagerBean findAccountDayByPage(PagerBean page);
	/**
	 * 根据传入的月查询所有账务日总时长
	 * @param month
	 * @return
	 */
	public   List<AccountMonthBean> findAccountDays(String year,String month);
	 
}

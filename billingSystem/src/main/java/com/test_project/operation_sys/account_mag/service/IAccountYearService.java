package com.test_project.operation_sys.account_mag.service;

import com.test_project.bean.AccountYearBean;
import com.test_project.pojos.PagerBean;

public interface IAccountYearService {
	
	
	/**
	 * 查询所有的账务月数据，计算加入AccountYearBean
	 * @param ab
	 */
	public void saveAccountYear(AccountYearBean ab);

	
	/**
	 * 查询所有的实验室使用信息
	 * @param page （Map中放year；Map中放year、ip；map中放year、ip、month）
	 * @return PagerBean--返回账务年分页对象
	 */
	public PagerBean findAccountYearByPage(PagerBean page);
	

}

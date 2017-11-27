package com.test_project.operation_sys.log_mag.handle_log_mag.dao;

import com.test_project.bean.HandLogBean;
import com.test_project.pojos.PagerBean;

public interface IHandLogDao {
	
	/**
	 * 添加日志
	 * @param hlBean
	 */
	void addHandLog(HandLogBean hlBean);
	
	/**
	 * 查找日志
	 * @param pager
	 * @return
	 */
	HandLogBean findHandLogByPagerBean(PagerBean pager);

}

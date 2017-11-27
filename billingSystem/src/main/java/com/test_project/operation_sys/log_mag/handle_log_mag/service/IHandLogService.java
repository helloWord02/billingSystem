package com.test_project.operation_sys.log_mag.handle_log_mag.service;

import com.test_project.bean.HandLogBean;
import com.test_project.pojos.PagerBean;

public interface IHandLogService {

	/**
	 * 添加日志
	 * @param hlBean
	 */
    public void addHandLog(HandLogBean hlBean);
	
	/**
	 * 分页查询
	 * @param pager
	 * @return 返回分页对象
	 */
    public PagerBean findHandLogByPagerBean(PagerBean pager);
    /**
    * 查找所有日志
    * @return
    */
    public HandLogBean findHandLog();
   

}

package com.test_project.operation_sys.log_mag.loginLog_mag.dao;

import com.test_project.bean.LoginLogBean;
import com.test_project.pojos.PagerBean;

public interface ILoginLogDao {
	

	/**
	 * 查询登陆日志
	 * @param pager
	 * findLoginDataByPager
	 */
	  public PagerBean findLoginLogByPager(PagerBean pager);
	  
	  /**
	   * 添加登陆日志
	   * @param llBean
	   * @return
	   */
	  public void addLoginLog(LoginLogBean llBean);

}

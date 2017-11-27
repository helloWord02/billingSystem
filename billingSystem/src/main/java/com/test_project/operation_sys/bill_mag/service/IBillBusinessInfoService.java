package com.test_project.operation_sys.bill_mag.service;

import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.pojos.PagerBean;

/**
 * 业务账号当月费用明细信息业务层接口
 * 
 * @author huangjun
 *
 */
public interface IBillBusinessInfoService {

	/**
	 * 根据业务账号查询当前业务账号对应服务器信息
	 * 
	 * @param pager
	 * @return
	 */
	public PagerBean findBusinessByBusinessAccount(PagerBean pager);
}

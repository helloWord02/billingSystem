package com.test_project.operation_sys.bill_mag.dao;

import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.pojos.PagerBean;

/**
 * 业务账号当月费用明细信息持久层接口
 * 
 * @author huangjun
 *
 */
public interface IBillBusinessInfoDao {

	/**
	 * 根据服务器信息产生业务账号费用并保存到数据库
	 * 
	 * @param serviceBean
	 */
	public void saveBusinessCost(ServiceBean serviceBean);

	/**
	 * 根据业务账号查询当前业务账号对应服务器信息
	 * 
	 * @param pager
	 * @return
	 */
	public PagerBean findBusinessByBusinessAccount(PagerBean pager);
}

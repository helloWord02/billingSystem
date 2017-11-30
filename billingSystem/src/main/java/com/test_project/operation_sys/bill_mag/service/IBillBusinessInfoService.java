package com.test_project.operation_sys.bill_mag.service;

import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
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
	 * 根据服务器提供的信息生成对应业务账号费用并保存到数据库
	 * 
	 * @param serviceBean
	 */
	public void saveBusinessBean(BusinessBean business);

	/**
	 * 根据业务账号查询当前业务账号对应服务器信息
	 * 
	 * @param pager
	 * @return
	 */
	public BillBusinessInfoBean findBusinessByBusinessAccount(BillBusinessInfoBean billBusiness);
}

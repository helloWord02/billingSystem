package com.test_project.operation_sys.bill_mag.service;

import com.test_project.bean.ServiceBean;
import com.test_project.pojos.PagerBean;

/**
 * 查询所有的账务账号的总费用信息业务层接口
 * @author huangjun
 *
 */
public interface IBillService {
	
	/**
	 * 根据账务账号费用生成每个账号总费用并保存到数据库
	 * 
	 * @param serviceBean
	 */
	public void saveAllBillCost(ServiceBean serviceBean);
	
	/**
	 * 查询所有的账务账号费用信息(模糊查询也用该方法，每月定时生成账单也用该方法)
	 * @param pager
	 * @return
	 */
	public PagerBean findAllBillAccoutCost(PagerBean pager);
}

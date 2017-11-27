package com.test_project.operation_sys.bill_mag.service;

import com.test_project.pojos.PagerBean;

/**
 * 查询所有的账务账号的总费用信息业务层接口
 * @author huangjun
 *
 */
public interface IBillService {
	/**
	 * 查询所有的账务账号费用信息(模糊查询也用该方法，每月定时生成账单也用该方法)
	 * @param pager
	 * @return
	 */
	public PagerBean findAllBillAccoutCost(PagerBean pager);
}

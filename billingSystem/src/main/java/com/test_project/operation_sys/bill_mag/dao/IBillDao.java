package com.test_project.operation_sys.bill_mag.dao;

import java.util.List;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BillBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.pojos.PagerBean;

/**
 * 查询所有的账务账号的总费用信息持久层接口
 * 
 * @author huangjun
 *
 */
public interface IBillDao {
	

	/**
	 * 保存一个账务账号每个月的总账单表
	 * 
	 * @param serviceBean
	 */
	public void saveAllSumBill(BillBean bean);
	
	/**
	 * 查询所有的账务账号费用信息(模糊查询也用该方法，每月定时生成账单也用该方法)
	 * 
	 * @param pager
	 * @return
	 */
	public PagerBean findAllBillAccoutCost(PagerBean pager);
	
	
	/**
	 * 查询所有的账务账号
	 * @return 
	 */
	public List<AccountBean> findAllAccount();
}

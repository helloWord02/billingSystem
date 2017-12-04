package com.test_project.operation_sys.bill_mag.service;

import java.util.List;
import java.util.Map;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BillBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.pojos.PagerBean;

/**
 * 查询所有的账务账号的总费用信息业务层接口
 * @author huangjun
 *
 */
public interface IBillService {
	
	/**
	 * 保存一个账务账号每个月的总账单表
	 * 
	 * @param serviceBean
	 */
	public void addAllSumBill(BillBean bean);
	
	/**
	 * 查询所有的账务账号费用信息(模糊查询也用该方法，每月定时生成账单也用该方法)
	 * @param pager
	 * @return
	 */
	public PagerBean findAllBillAccoutCost(PagerBean pager);
	
	/**
	 * 查询所有的账务账号
	 * @return 
	 */
	public List<AccountBean> findAllAccount();
	
/**
 * 某年月  所有账务账号生成一个当月的总账单
 * @param map
 */
	public void addAllBill(Map map) ;
	
	/**
	 * 每个月生成一次账单
	 * @throws InterruptedException 
	 */
	public void addTimeDo() throws InterruptedException;
	
	
}

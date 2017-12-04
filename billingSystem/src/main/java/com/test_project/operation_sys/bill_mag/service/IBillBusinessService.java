package com.test_project.operation_sys.bill_mag.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.pojos.PagerBean;

/**
 * 账务账号下所有的业务账号当月发生的费用明细信息业务层接口
 * 
 * @author huangjun
 *
 */
public interface IBillBusinessService {
	/**
	 * 保存一个业务月账单
	 * @param buillBusi
	 */
	public void addBillBusiness(BillBusinessBean buillBusi);

	/**
	 * 根据账务账号查询该账号下所有的业务账号当月发生的费用明细信息
	 * 
	 * @param pager
	 * @return
	 */
	public PagerBean findAllBusinessByBillAccount(PagerBean pager);
	
	/**
	 * 保存一个月的所有的  每一个业务的总结对象
	 * @param map 年月
	 */
	public void addSUMBillBusOfMonth(Map map);
	
	/**
	 * 查询某年月下的  某账务账号的所有业务账单
	 * @param map
	 * @return
	 */
	public List<BillBusinessBean> findbillBusByaccount(Map map);
	

}

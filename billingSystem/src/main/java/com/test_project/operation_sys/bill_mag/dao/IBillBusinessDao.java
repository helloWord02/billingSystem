package com.test_project.operation_sys.bill_mag.dao;



import java.util.List;
import java.util.Map;

import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BusinessBean;
import com.test_project.pojos.PagerBean;

/**
 * 账务账号下所有的业务账号当月发生的费用明细信息持久层接口
 * @author huangjun
 *
 */
public interface IBillBusinessDao {
	/**
	 * 保存一个业务月账单
	 * @param buillBusi
	 */
	public void saveBillBusiness(BillBusinessBean buillBusi);

	/**
	 * 根据账务账号查询该账号下所有的业务账号当月发生的费用明细信息
	 * @param pager
	 * @return
	 */
	public PagerBean findAllBusinessByBillAccount(PagerBean pager);
	
	/**
	 * 查询某年月下的  某账务账号的所有业务账单
	 * @param map
	 * @return
	 */
	public List<BillBusinessBean> findbillBusByaccount(Map map);
	

}

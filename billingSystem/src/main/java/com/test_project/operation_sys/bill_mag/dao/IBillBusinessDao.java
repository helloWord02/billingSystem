package com.test_project.operation_sys.bill_mag.dao;



import com.test_project.bean.BusinessBean;
import com.test_project.pojos.PagerBean;

/**
 * 账务账号下所有的业务账号当月发生的费用明细信息持久层接口
 * @author huangjun
 *
 */
public interface IBillBusinessDao {
	
	/**
	 * 根据业务账号费用生成对应账务账号费用并保存到数据库
	 * 
	 * @param serviceBean
	 */
	public void saveBillCost(BusinessBean buesiness);

	/**
	 * 根据账务账号查询该账号下所有的业务账号当月发生的费用明细信息
	 * @param pager
	 * @return
	 */
	public PagerBean findAllBusinessByBillAccount(PagerBean pager);
}

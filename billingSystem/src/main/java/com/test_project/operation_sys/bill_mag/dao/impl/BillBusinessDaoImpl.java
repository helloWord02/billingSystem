package com.test_project.operation_sys.bill_mag.dao.impl;

import org.springframework.stereotype.Repository;

import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillBusinessDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;
/**
 * 账务账号下所有的业务账号当月发生的费用明细信息持久层实现类
 * @author huangjun
 *
 */
@Repository
public class BillBusinessDaoImpl extends BaseDao implements IBillBusinessDao {

	@Override
	public void saveBillCost(BusinessBean buesiness) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PagerBean findAllBusinessByBillAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.test_project.operation_sys.bill_mag.dao.impl;


import org.springframework.stereotype.Repository;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

@Repository
public class BillDaoImpl extends BaseDao implements IBillDao {
	
	
	
	@Override
	public void saveBillCost(ServiceBean serviceBean) {
		// TODO Auto-generated method stub
		getSession().save(serviceBean);
	}

	@Override
	public PagerBean findAllBillAccoutCost(PagerBean pager) {
		// TODO Auto-generated method stub
		return null;
	}

}

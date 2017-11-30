package com.test_project.operation_sys.bill_mag.service.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillDao;
import com.test_project.operation_sys.bill_mag.service.IBillService;
import com.test_project.pojos.PagerBean;
/**
 * 账务账号业务层实现类
 * @author huangjun
 *
 */
@Service
public class BillSercviceImpl implements IBillService {

	@Resource
	private IBillDao billDaoImpl;

	@Override
	public void saveAllBillCost(ServiceBean serviceBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public PagerBean findAllBillAccoutCost(PagerBean pager) {
		// TODO Auto-generated method stub

		return billDaoImpl.findAllBillAccoutCost(pager);
	}

}

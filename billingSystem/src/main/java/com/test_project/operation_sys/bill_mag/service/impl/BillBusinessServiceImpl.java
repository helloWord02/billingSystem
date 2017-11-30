package com.test_project.operation_sys.bill_mag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillBusinessDao;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessService;
import com.test_project.pojos.PagerBean;

/**
 * 一个账务账号下所有业务账号当月发生的费用明细信息
 * @author huangjun
 *
 */
@Service
public class BillBusinessServiceImpl implements IBillBusinessService {

	@Resource
	private IBillBusinessDao billBusinessDaomImpl;
	@Override
	public void saveBillCost(ServiceBean serviceBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public PagerBean findAllBusinessByBillAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		return billBusinessDaomImpl.findAllBusinessByBillAccount(pager);
	}

}

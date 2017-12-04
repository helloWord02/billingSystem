package com.test_project.operation_sys.user_mag.business_mag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.BusinessBean;
import com.test_project.operation_sys.user_mag.business_mag.dao.IBusinessDao;
import com.test_project.operation_sys.user_mag.business_mag.service.IBusinessService;
import com.test_project.pojos.PagerBean;
@Service
public class IBusinessServiceImpl implements IBusinessService {
	@Resource
	private IBusinessDao  Ibusinessdaoimpl;
	
	
	public void saveBusiness(BusinessBean bus) {
		// TODO Auto-generated method stub
		BusinessBean upd=Ibusinessdaoimpl.findBusiness(bus.getPostage().getId());
		Ibusinessdaoimpl.saveBusiness(bus);

	}


	public void delBusiness(BusinessBean bus) {
		// TODO Auto-generated method stub
		Ibusinessdaoimpl.delBusiness(bus);

	}


	public BusinessBean findBusiness(long id) {
		// TODO Auto-generated method stub
		return Ibusinessdaoimpl.findBusiness(id);
	}

	
	public void updBusiness(BusinessBean bus) {
		// TODO Auto-generated method stub
		BusinessBean upd=Ibusinessdaoimpl.findBusiness(bus.getId());
		upd.setState(bus.getState());

		Ibusinessdaoimpl.updBusiness(upd);
	}

	
	public PagerBean findBusinessPager(PagerBean Pager) {
		// TODO Auto-generated method stub
		return Ibusinessdaoimpl.findBusinessPager(Pager);
	}

}

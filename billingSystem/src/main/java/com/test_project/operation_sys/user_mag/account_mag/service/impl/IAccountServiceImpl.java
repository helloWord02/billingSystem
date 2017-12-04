package com.test_project.operation_sys.user_mag.account_mag.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.AccountBean;
import com.test_project.operation_sys.user_mag.account_mag.dao.IAccountDao;
import com.test_project.operation_sys.user_mag.account_mag.service.IAccountService;
import com.test_project.pojos.PagerBean;
@Service
public class IAccountServiceImpl implements IAccountService {
	@Resource
	private IAccountDao IAccountdaoImpl;
	
	@Override
	public void saveAccount(AccountBean acc) {
		// TODO Auto-generated method stub
		IAccountdaoImpl.saveAccount(acc);
	}

	@Override
	public void delAccount(AccountBean acc) {
		// TODO Auto-generated method stub
		IAccountdaoImpl.delAccount(acc);
	}

	@Override
	public AccountBean findAccount(long id) {
		// TODO Auto-generated method stub
		return IAccountdaoImpl.findAccount(id);
	}

	@Override
	public void updAccount(AccountBean acc) {
		// TODO Auto-generated method stub
		AccountBean upd=IAccountdaoImpl.findAccount(acc.getId());
		upd.setPhoneNumber(acc.getPhoneNumber());
		upd.setCord(acc.getCord());
		upd.setAddress(acc.getAddress());
		upd.setQq(acc.getQq());
		upd.setState(acc.getState());
		IAccountdaoImpl.updAccount(upd);
		System.out.println("##################################"+upd);
	}

	@Override
	public PagerBean findAccountPager(PagerBean Pager) {
		// TODO Auto-generated method stub
		return IAccountdaoImpl.findAccountPager(Pager);
	}

}

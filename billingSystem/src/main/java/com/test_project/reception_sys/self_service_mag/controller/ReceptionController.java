package com.test_project.reception_sys.self_service_mag.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test_project.bean.AccountBean;
import com.test_project.reception_sys.self_service_mag.service.IReceptionService;

@RestController
@RequestMapping("/receptions")
public class ReceptionController {

	@Resource
	private IReceptionService receptionServiceImpl;

	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces= {"application/json;charset=utf-8"})
	public AccountBean getAccountBeanById(@PathVariable("id") Long id) {
		AccountBean account = null;
		account =  receptionServiceImpl.findAccountBean(id);
		return account;
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT,produces= {"application/json;charset=utf-8"})
	public AccountBean updateAccountBean(@PathVariable("id")Long id,AccountBean account) {
		receptionServiceImpl.updateAccountBean(account);
		return account;
	}

}

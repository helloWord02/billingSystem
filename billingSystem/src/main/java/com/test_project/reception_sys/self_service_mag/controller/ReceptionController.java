package com.test_project.reception_sys.self_service_mag.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.AccountBean;
import com.test_project.reception_sys.self_service_mag.service.IReceptionService;

@RestController
@RequestMapping("/receptions")
public class ReceptionController {

	@Resource 
	private IReceptionService receptionServiceImpl;

	@RequestMapping(value="/find")
	public ModelAndView find(long id) {
	
		//查询后台得到数据
		AccountBean account = receptionServiceImpl.findAccountBean(id);
		
		ModelAndView mv = new ModelAndView("view/reception/page_person_info");
	
		mv.addObject("account", account);// === req.setAttribute()
		
		System.out.println(mv);
		
		return mv;
	}
	
	@RequestMapping(value="/update")
	public ModelAndView update(AccountBean account) {
	
		//查询后台得到数据
		account = receptionServiceImpl.findAccountBean(account.getId());
		
		ModelAndView mv = new ModelAndView("view/reception/page_person_upd");
	
		mv.addObject("account", account);// === req.setAttribute()
		  
		System.out.println(mv);
		
		return mv;
	}
	
	@RequestMapping(value="/upd")
	public ModelAndView upd(AccountBean account) {
		System.out.println(account);
		
		receptionServiceImpl.updateAccountBean(account);
		
		ModelAndView mv = new ModelAndView("view/operation/account/main");
		
		return mv;	
	}
}

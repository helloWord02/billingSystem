package com.test_project.reception_sys.self_service_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.AccountBean;
import com.test_project.pojos.PagerBean;
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
		
		receptionServiceImpl.updateAccountBean(account);
		
		ModelAndView mv = new ModelAndView("view/reception/page_person_info");
		
		mv.addObject("account", account);
	
		return mv;	
	}
	
	@RequestMapping(value="/cutpage")
	public @ResponseBody PagerBean findBill(int pageNum,String month,String userid) {
		PagerBean pager = new PagerBean(pageNum,5,null);  
		
		Map map = new HashMap();
		
		map.put("month", month);
		map.put("account", userid);

		pager.setParams(map);
		
		pager = receptionServiceImpl.findBillBusinessBeanByPagerBean(pager);
		
		return pager;
	}
}

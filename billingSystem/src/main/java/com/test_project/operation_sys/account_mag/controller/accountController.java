package com.test_project.operation_sys.account_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test_project.operation_sys.account_mag.service.IAccountYearService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping("/account")
public class accountController {
	@Resource
	private IAccountYearService accountYearServiceImpl; 
	
	@RequestMapping("/accountpage")	
	public @ResponseBody PagerBean cutpage(int pageNum) {
		Map  map = new HashMap();
		map.put("year", "");
		PagerBean page=new PagerBean(pageNum, 5, map);
		System.out.println(page);
		PagerBean repage= accountYearServiceImpl.findAccountYearByPage(page); 
		System.out.println(repage);
		return repage;
		
	}
	
	

}

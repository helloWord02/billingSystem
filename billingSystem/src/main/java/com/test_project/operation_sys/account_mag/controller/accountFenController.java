package com.test_project.operation_sys.account_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test_project.operation_sys.account_mag.service.IAccountDayService;
import com.test_project.operation_sys.account_mag.service.IAccountMonthService;
import com.test_project.operation_sys.account_mag.service.IAccountYearService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping("/accountfen")
public class accountFenController {
	@Resource
	private IAccountYearService accountYearServiceImpl; 
	@Resource
	private IAccountMonthService accountMonthServiceImpl; 
	@Resource
	private IAccountDayService accountDayServiceImpl; 
	
	@RequestMapping("/fenpage")
	
	public @ResponseBody PagerBean cutpage(int pageNum,String year,String month,String ip) {
		 Map map = new  HashMap ();
		 map.put("ip", ip);
		 map.put("month", month);
		 map.put("year", year);
		PagerBean page=new PagerBean(pageNum, 5, map);
		System.out.println(page);
		PagerBean repage=null;
		if("".equals(month)&&"".equals(ip)) {
			repage = accountYearServiceImpl.findAccountYearByPage(page); 
		}else if(!("".equals(month))&&!("".equals(ip))){
			repage = accountDayServiceImpl.findAccountDayByPage(page); 
		}else {
			repage = accountMonthServiceImpl.findAccountMonthByPage(page); 
		}
		
		System.out.println(repage);
		return repage;
		
	}

}

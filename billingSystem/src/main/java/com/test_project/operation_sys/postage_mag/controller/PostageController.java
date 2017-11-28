package com.test_project.operation_sys.postage_mag.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test_project.operation_sys.postage_mag.service.IPostageService;
import com.test_project.pojos.PagerBean;

@Controller
@RequestMapping("/postage")
public class PostageController {
	@Resource
	private IPostageService postageServiceImpl;
	
	@RequestMapping("/cutpage")
	
	public @ResponseBody PagerBean cutpage(int pageNum) {
		PagerBean page=new PagerBean(pageNum, 5, null);
		System.out.println(page);
		PagerBean repage=postageServiceImpl.findPageByPostage(page);
		System.out.println(repage);
		return repage;
		
	}

}

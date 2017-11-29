package com.test_project.operation_sys.postage_mag.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	public @ResponseBody PagerBean cutpage(int page,String postageName,Integer potageType) {
		Map map=new HashMap();
		map.put("postageName", postageName);
		map.put("postageType", potageType);
		PagerBean page1 =new PagerBean(page,5,map);
		System.out.println(page1);
		PagerBean repage=postageServiceImpl.findPageByPostage(page1);
		System.out.println(repage);
		return repage;
		
	}

}

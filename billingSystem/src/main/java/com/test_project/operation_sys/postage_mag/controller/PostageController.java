package com.test_project.operation_sys.postage_mag.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.PostageBean;
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
	
	@RequestMapping("/findInfo")
	public ModelAndView findInfo(long nowId) {
		ModelAndView mv=new ModelAndView("view/operation/postage/page_postage_info");
		PostageBean bean=postageServiceImpl.findPostageById(nowId);
		if(bean.getBeginDate()!=null) {
		String date=new SimpleDateFormat("yyyy-MM-dd").format(bean.getBeginDate());
		mv.addObject("date", date);
		}
		mv.addObject("postageInfo", bean);
		return mv;
	}
	
	@RequestMapping("/delt")
	public ModelAndView del(long nowId) {
		ModelAndView mv=new ModelAndView("view/operation/postage/page_postage");
		PostageBean p=new PostageBean();
		p.setId(nowId);
		postageServiceImpl.delPostageById(p);
		return mv;
	}
	
	@RequestMapping("/updatefind")
	public ModelAndView updatefind(long nowId) {
		ModelAndView mv=new ModelAndView("view/operation/postage/page_postage_upd");
		PostageBean bean=postageServiceImpl.findPostageById(nowId);
		mv.addObject("postageBean", bean);
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(PostageBean postage) {
		System.out.println("更新========================"+postage);
		ModelAndView mv=new ModelAndView("view/operation/postage/page_postage");
		postageServiceImpl.updPostage(postage);
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(PostageBean postage) {
		System.out.println("添加========================"+postage);
		ModelAndView mv=new ModelAndView("view/operation/postage/page_postage");
		postageServiceImpl.savePostage(postage);
		return mv;
	}
	
	@RequestMapping("/depend")
	public @ResponseBody boolean isDepend(long nowid) {
		long i=postageServiceImpl.findIsDepend(nowid);
		if(i==0) {
			return true;
		}else {
			return false;
		}
	}

}

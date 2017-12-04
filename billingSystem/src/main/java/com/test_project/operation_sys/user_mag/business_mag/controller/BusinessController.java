package com.test_project.operation_sys.user_mag.business_mag.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.PostageBean;
import com.test_project.operation_sys.user_mag.business_mag.service.IBusinessService;
import com.test_project.pojos.PagerBean;
import com.test_project.util.ImportExcelUtil;

@Controller
@RequestMapping("/business")
public class BusinessController {
	@Resource
	private IBusinessService IBusinessServiceImpl;
	
	
	@RequestMapping("/buspage")
	public @ResponseBody PagerBean buspage(int page,String businessAccount,String billAccount) {

		Map map=new HashMap();
		map.put("businessAccount", businessAccount);
		map.put("billAccount", billAccount);
		PagerBean pager=new PagerBean(page, 5, map);
		System.out.println("-------------------"+pager);
		PagerBean repage=IBusinessServiceImpl.findBusinessPager(pager);
		System.out.println(repage);
		return repage;
		
	}
	
	@RequestMapping("/findInfo")
	public ModelAndView findInfo(long nowId) {
	ModelAndView mv=new ModelAndView("view/operation/user/business/page_business_info");
	BusinessBean bean=IBusinessServiceImpl.findBusiness(nowId);
	mv.addObject("Businesstinfo",bean);
	return mv;
	
	}
	
	@RequestMapping("/delt")
	public ModelAndView del(long nowId) {
	ModelAndView mv=new ModelAndView("view/operation/user/business/page_business");
	BusinessBean bean= new BusinessBean();
	bean.setId(nowId);
	IBusinessServiceImpl.delBusiness(bean);
	
		return mv;	
	
	}
	@RequestMapping("/updatefind")
	public ModelAndView updatefind(long nowId) {
		ModelAndView mv=new ModelAndView("view/operation/user/business/page_business_upd");
		BusinessBean  bean= IBusinessServiceImpl.findBusiness(nowId);
		 mv.addObject("Businessfind",bean);
		 return mv;
		
	
	}
	
	@RequestMapping(value="/update")
	public ModelAndView update(BusinessBean bus) {
	IBusinessServiceImpl.updBusiness(bus);
	ModelAndView mv=new ModelAndView("view/operation/user/business/page_business");	
	System.out.println("__________________________________________"+mv);
	return mv;
		
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(BusinessBean bus) {
	IBusinessServiceImpl.saveBusiness(bus);
	ModelAndView mv=new ModelAndView("view/operation/user/business/page_business");	
	System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^"+mv);
	return mv;
		
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)    
	 public ModelAndView doUploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {  
	  
	        if (!file.isEmpty()) {  
	            try {  
	            	InputStream in = null;  
	    	        List<List<Object>> listob = null;  
	    	        in = file.getInputStream();  
	    	        listob = new ImportExcelUtil().getBankListByExcel(in, file.getOriginalFilename());  
	    	        // 该处可调用service相应方法进行数据保存到数据库中，现只对数据输出  
	    	        for (int i = 0; i < listob.size(); i++) {  
	    	            List<Object> lo = listob.get(i); 
	    	            BusinessBean bean=new BusinessBean();
	    	            bean.setBusinessAccount(String.valueOf(lo.get(0)));
	    	            bean.setPassword(String.valueOf(lo.get(1)));
	    	            AccountBean account=IBusinessServiceImpl.findAccountByname(String.valueOf(lo.get(2)));
	    	            bean.setAccount(account);
	    	            bean.setIp(String.valueOf(lo.get(3)));
	    	            PostageBean postage=IBusinessServiceImpl.findPostageByname(String.valueOf(lo.get(4)));
	    	            bean.setPostage(postage);
	    	            	            
	    	           System.out.println(bean);  
	    	           IBusinessServiceImpl.saveBusiness(bean);
	    	        }  
	    	  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        ModelAndView mv=new ModelAndView("view/operation/user/business/page_business");	

	    	return mv;
	       
	    }  
	
	
}

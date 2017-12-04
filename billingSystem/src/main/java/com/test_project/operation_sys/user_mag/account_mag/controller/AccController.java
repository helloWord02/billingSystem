package com.test_project.operation_sys.user_mag.account_mag.controller;



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
import com.test_project.operation_sys.user_mag.account_mag.service.IAccountService;
import com.test_project.pojos.PagerBean;
import com.test_project.util.ImportExcelUtil;

@Controller
@RequestMapping("/account")
public class AccController {
	
	@Resource
	private IAccountService IAccountServiceImpl;
	
	@RequestMapping("/conpage")
	public @ResponseBody PagerBean conpage(int page,String realName,String billAccount,String idCard) {
		System.out.println("-----------"+realName);
		System.out.println("------------"+billAccount);
		System.out.println("---------------"+idCard);
		Map map=new HashMap();
		map.put("realName", realName);
		map.put("billAccount", billAccount);
		map.put("idCard",idCard);	
		PagerBean pager=new PagerBean(page, 5, map);
		System.out.println(pager);
		PagerBean repage=IAccountServiceImpl.findAccountPager(pager);
		System.out.println(repage);
		return repage;
		
	}
	@RequestMapping("/findInfo")
	public ModelAndView findInfo(long nowId) {
	ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number_info");
	AccountBean bean=IAccountServiceImpl.findAccount(nowId);
	mv.addObject("Accountinfo",bean);
	return mv;
	
	}
	@RequestMapping("/delt")
	public ModelAndView del(long nowId) {
	ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number");
	AccountBean bean= new AccountBean();
	bean.setId(nowId);
	IAccountServiceImpl.delAccount(bean);
	
		return mv;	
		
	}
	@RequestMapping("/updatefind")
	public ModelAndView updatefind(long nowId) {
		ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number_upd");
		AccountBean bean=IAccountServiceImpl.findAccount(nowId);
		 mv.addObject("Accountfind",bean);
		 return mv;
		
	
	}
	
	
	@RequestMapping(value="/update")
	public ModelAndView update(AccountBean acc) {
	IAccountServiceImpl.updAccount(acc);
	ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number");	
	System.out.println("__________________________________________"+mv);
	return mv;
		
	}
	
	@RequestMapping(value="/add")
	public ModelAndView add(AccountBean acc) {
	IAccountServiceImpl.saveAccount(acc);
	ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number");	
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
	    	            AccountBean bean=new AccountBean();
	    	            bean.setRealName(String.valueOf(lo.get(0)));
	    	            bean.setGender(String.valueOf(lo.get(1))=="男"?1:0);
	    	            bean.setBillAccount(String.valueOf(lo.get(2)));
	    	            bean.setPassword(String.valueOf(lo.get(3)));
	    	            bean.setIdCard(String.valueOf(lo.get(4)));
	    	            bean.setPhoneNumber(String.valueOf(lo.get(5)));
	    	            bean.setCord(Integer.parseInt(String.valueOf(lo.get(6))));
	    	            bean.setAddress(String.valueOf(lo.get(7)));
	    	            bean.setQq(Integer.parseInt(String.valueOf(lo.get(8))));	            
	    	           System.out.println(bean);  
	    	           IAccountServiceImpl.saveAccount(bean);
	    	        }  
	    	  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        ModelAndView mv=new ModelAndView("view/operation/user/account/page_account_number");	

	    	return mv;
	       
	    }  
	  
	    
	

}

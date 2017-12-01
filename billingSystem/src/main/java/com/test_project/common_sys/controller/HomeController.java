package com.test_project.common_sys.controller;





import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;

import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test_project.bean.AccountBean;







@Controller
@RequestMapping(value="/user")
public class HomeController{
	
	@RequestMapping(value="/login")
	public @ResponseBody String login(AccountBean user)
	{
		
		
	    System.out.println("login++"+user);
	   
       //获取凭据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getBillAccount(),user.getPassword());
        token.setRememberMe(true);
       
        Subject currentUser = SecurityUtils.getSubject();
	    try {
	    	//提交凭据，
	        currentUser.login(token);
	        return "0";
	    } catch (Exception ex) {  
	       ex.printStackTrace();
	        return "1";
	    } 
		
	   

    	
	}
	
	@RequestMapping(value="/loginout")
	public String loginOut() {
		 
		Subject currentUser = SecurityUtils.getSubject();		 
			currentUser.logout();
		 return "view/operation/account/login";
	}
	
	
	
}

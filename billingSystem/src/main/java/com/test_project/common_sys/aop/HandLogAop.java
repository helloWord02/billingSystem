package com.test_project.common_sys.aop;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
 
import org.aspectj.lang.annotation.AfterReturning;
 
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.test_project.bean.AccountBean;
import com.test_project.bean.HandLogBean;
import com.test_project.operation_sys.log_mag.handle_log_mag.service.IHandLogService;

@Component
@Aspect
public class HandLogAop {
	@Resource
	private IHandLogService handLogServiceImpl;
	
	 
	@Pointcut("execution(* com.test_project.operation_sys.*mag.service.impl.*ServiceImpl.*(..))")
	private void test() {
	
	}
	@AfterReturning (value = "test()")
		 public void recordOperator(JoinPoint jp){  
			  
			//获取目标对象
			Object obj = jp.getTarget();
			HttpServletRequest request =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
	        HttpSession session =request.getSession();   
			System.out.println("+++++++++================================================================");
			System.out.println(session.getAttribute("user"));
			AccountBean user = (AccountBean) session.getAttribute("user");
			
			
			//获取目标方法
			String methodName = jp.getSignature().getName();
			Object[] param = jp.getArgs(); // 方法参数列表  	
			String str =null;
			for (Object object : param) {
				 str =object.toString() + "  ";
				
			}
	        HandLogBean log = new HandLogBean(); // 日志  
	        log.setHandTime (new Date()); // 创建时间  	          
	        log.setMagName( user.getBillAccount() );
	        log.setHandMethod(methodName); 
	        log.setHandArgs(str);
	        handLogServiceImpl.addHandLog(log);
	       }  
	    	
	    	
	    
	    
	     
	      
	     
	
}

package com.test_project.common_sys.listener;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.test_project.bean.AccountBean;
import com.test_project.bean.LoginLogBean;
import com.test_project.operation_sys.log_mag.loginLog_mag.service.ILoginLogService;


public class SessionListener implements HttpSessionListener {
	
	private ILoginLogService loginLogServiceImpl;
	
	
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("创建session======================");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
		System.out.println(arg0.getSession().getAttribute("user"));
		//存登录日志	
		WebApplicationContext springCtx = WebApplicationContextUtils.getWebApplicationContext(arg0.getSession().getServletContext()); 
		loginLogServiceImpl = (ILoginLogService)(springCtx.getBean(ILoginLogService.class)); 
		
        LoginLogBean log = new LoginLogBean();
        log.setHandTime(new Date());
        AccountBean user = (AccountBean) arg0.getSession().getAttribute("user");
        log.setMagName(user.getBillAccount());
        log.setHandType(1);
		
		loginLogServiceImpl.addLoginLog(log);
		
		System.out.println("销毁session======================");
	}

}

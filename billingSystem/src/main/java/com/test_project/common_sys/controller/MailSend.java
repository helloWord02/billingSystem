package com.test_project.common_sys.controller;

import javax.annotation.Resource;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.test_project.bean.AccountBean;



@Component  
public class MailSend {  
	@Resource
    private JavaMailSenderImpl email;  
	@Resource
    private SimpleMailMessage message;  
       
    //发送邮件  
    public void sendcode(AccountBean user,String code){     
        message.setTo(user.getMail());  
        message.setSubject("登录认证邮件");  
        message.setText("您好"+user.getRealName()+"!  您的验证码为:"+code);  
        email.send(message);  
    }  
    public void sendbean(AccountBean user){   
    	System.out.println("发送邮件中！！！！");
        message.setTo(user.getMail());  
        message.setSubject("账号开通，通知邮件");  
        message.setText("您好"+user.getRealName()+"!  您的账号为:"+user.getBillAccount()+"密码:"+user.getPassword()+"。请妥善保管您的账号和密码!");  
        email.send(message);  
    }  
}  


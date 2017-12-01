package com.test_project.common_sys.controller;





import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.test_project.bean.AccountBean;
import com.test_project.bean.RoleBean;
import com.test_project.common_sys.service.ICommonService;
import com.test_project.operation_sys.admin_mag.service.IAdminService;


@Service
public class MyRealm extends AuthorizingRealm{

   @Resource
    private IAdminService adminServiceImpl;
   
   @Resource
   private ICommonService commonServiceImpl;
   
//权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
 
		 String username=(String)principals.fromRealm(getName()).iterator().next();  
	        System.out.println(getName()+"====================================================================");
		 if( username != null ){  
			 AccountBean user = adminServiceImpl.findAccountBeanByName(username); 
	            System.out.println("权限"+user);
	            if( user != null && user.getRoles() != null ){  
	                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
	                	RoleBean role=user.getRoles();
                        info.addRole(role.getRoleName());  
                        info.addStringPermissions(role.getPermissionsName());  
	                 
	                return info;  
	            }  
	        }  
		return null;
	}
//登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        String userName = token.getUsername(); 
        char[] userPwd = token.getPassword(); 
        System.out.println(userName+"------------------");
       
        if( userName != null && !"".equals(userName) ){  
        	System.out.println(String.valueOf(userPwd)+"-----666666---------");
        	AccountBean bean=new AccountBean();
        	bean.setBillAccount(userName);
        	bean.setPassword(String.valueOf(userPwd));
        	AccountBean user = commonServiceImpl.login(bean);  
            Subject currentUser = SecurityUtils.getSubject();
            Session s=currentUser.getSession();
	        s.setAttribute("user", user);
            if( user != null ) { 
            	System.out.println("登录+++++++++++++"+user);
                return new SimpleAuthenticationInfo(user.getBillAccount(),user.getPassword(), getName());  
            }else {
            	
            	 return null;
            }
          }else {
        	
        	  return null;
          }  
	}

}

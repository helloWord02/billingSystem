package com.test_project.operation_sys.service_mag.dao;

import java.util.List;

import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
/**
 * 服务器持久层接口
 * @author huangjun
 *
 */
public interface IServiceDao {
	
	/**
	 * 根据业务账号查询该账号在服务器上的消费时长
	 * @param businessBean
	 * @return
	 */
	public List<ServiceBean> findAllServiceBean(ServiceBean service);
}

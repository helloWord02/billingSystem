package com.test_project.operation_sys.service_mag.dao;

import java.util.List;
import java.util.Map;

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
	
	/**
	 * 每个月查询一次所有的service当月表的信息
	 * @param map 年,月
	 * @return
	 */
	public List<ServiceBean> findAllService(Map<String, Integer> map);
	/**
	 * 模拟数据  定时添加记录
	 */
	public void saveRow(ServiceBean bean);
}

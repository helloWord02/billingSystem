package com.test_project.operation_sys.service_mag.service;

import java.util.List;
import java.util.Map;

import com.test_project.bean.ServiceBean;

public interface IServiceService {
	/**
	 * 每个月查询一次所有的service当月表的信息
	 * @param map 年,月
	 * @return
	 */
	public List<ServiceBean> findAllService(Map<String, Integer> map);
	
	/**
	 * 模拟数据  添加记录
	 */
	public void addRow(Map map);
	
	/**
	 * 定时添加数据
	 */
	public void addtimeDo();
}

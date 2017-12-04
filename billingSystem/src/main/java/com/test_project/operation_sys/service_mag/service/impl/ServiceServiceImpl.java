package com.test_project.operation_sys.service_mag.service.impl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.service_mag.dao.IServiceDao;
import com.test_project.operation_sys.service_mag.service.IServiceService;

@Service
public class ServiceServiceImpl  implements IServiceService{
	@Resource
	private IServiceDao serviceDao;

	@Override
	public List<ServiceBean> findAllService(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return serviceDao.findAllService(map);
	}

	@Override
	public void addRow(Map map) {
		// TODO Auto-generated method stub
		 Random random = new Random();
		 int i=random.nextInt(6)+1;//产生从1--6的随机数
		
		//日期转换  月从0--11
		int year=Integer.parseInt(map.get("year").toString());
		int month=Integer.parseInt(map.get("month").toString());
		int day=Integer.parseInt(map.get("day").toString());
		Calendar c1=new GregorianCalendar();
		c1.set(year, month-1, day, Integer.parseInt(map.get("hour").toString()), 1);
		
		Calendar c2=new GregorianCalendar(year,month-1, day);
		c2.set(year, month-1, day, Integer.parseInt(map.get("hour").toString())+3, 1);
		
		ServiceBean bean=new ServiceBean("12345",c2.getTime() , c1.getTime(), "业务账号"+Integer.parseInt(map.get("account").toString()));
		serviceDao.saveRow(bean);
		

	}

	@Override
	@Scheduled(fixedRate=1000*15)
	public void addtimeDo() {
		System.out.println("执行");
		// TODO Auto-generated method stub
		 Random random = new Random();
		 int i=random.nextInt(6)+1;//产生从1--6的随机数
		Map<String, Integer> map=new HashMap();
		map.put("year", 2017);
		map.put("month", 11);
		map.put("day", random.nextInt(30)+1);
		map.put("hour", random.nextInt(24));
		map.put("account", i);
		addRow(map);
	}



}

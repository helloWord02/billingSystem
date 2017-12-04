package com.test_project.operation_sys.bill_mag.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillBusinessInfoDao;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessInfoService;
import com.test_project.operation_sys.service_mag.dao.IServiceDao;
import com.test_project.operation_sys.service_mag.service.IServiceService;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

@Service
public class BillBusinessInfoServiceImpl implements IBillBusinessInfoService {

	
	@Resource
	private IBillBusinessInfoDao billBussinessInfoDao;
	@Resource
	private IServiceService serviceserviceImpl;

	@Override
	/**
	 * 根据服务器提供的信息生成对应业务账号费用并保存到数据库
	 * 
	 * @param serviceBean
	 */
	public void addBusinessInfoBean(BillBusinessInfoBean billInfo) {
		billBussinessInfoDao.saveBusinessInfoBean(billInfo);
	}

	@Override
	public PagerBean findBusinessByBusinessAccount(PagerBean pager) {
		// TODO Auto-generated method stub

		return billBussinessInfoDao.findBusinessByBusinessAccount(pager);
	}


	@Override
	public void addBillInfoMonth(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		List<ServiceBean> listservice= serviceserviceImpl.findAllService(map);
		for (ServiceBean serviceBean : listservice) {
			BillBusinessInfoBean billInfo=new BillBusinessInfoBean(serviceBean.getBusniessAccount(), serviceBean.getLoginoutTime(), serviceBean.getLoginTime(), serviceBean.getIp());
			long loginoutTime=serviceBean.getLoginoutTime().getTime();
			long loginTime=serviceBean.getLoginTime().getTime();
			long minus=loginoutTime-loginTime;
			billInfo.setTimeLong(minus);
			billBussinessInfoDao.saveBusinessInfoBean(billInfo);
		}
	}



}

package com.test_project.operation_sys.bill_mag.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillBusinessInfoDao;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessInfoService;
import com.test_project.operation_sys.service_mag.dao.IServiceDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

@Service
public class BillBusinessInfoServiceImpl extends BaseDao implements IBillBusinessInfoService {

	@Resource
	private IServiceDao serviceDao;
	@Resource
	private IBillBusinessInfoDao billBussinessInfoDao;

	@Override
	public void saveBusinessBean(BusinessBean business) {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/**
		 * 产生查询日期条件并封闭到ServiceBean
		 */
		ServiceBean service = new ServiceBean();
		Date beginDate;
		Date endDate;
		try {
			beginDate = dateFormat.parse("2017-11-01 00:00:00");
			endDate = dateFormat.parse("2017-11-30 00:00:00");
			service.setLoginTime(beginDate);
			service.setLoginoutTime(endDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<ServiceBean> ls = serviceDao.findAllServiceBean(service);

		for (ServiceBean serviceBean : ls) {

			try {
				Date loginTime = serviceBean.getLoginTime();
				Date loginOutTime = serviceBean.getLoginoutTime();
				String str = dateFormat.format(loginTime);
				String str1 = dateFormat.format(loginOutTime);
				Date date = dateFormat.parse(str);
				Date date1 = dateFormat.parse(str1);
				System.out.println("date:" + date);
				System.out.println("date1:" + date1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Override
	public PagerBean findBusinessByBusinessAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		/**
		 * 分页信息查询
		 */
		Criteria criteria = getSession().createCriteria(BusinessBean.class);
		criteria.add(Restrictions.like("business_account", pager.getParams().get("business_account").toString()));
		criteria.setProjection(Projections.count("id"));
		int totalRows =  (int) criteria.uniqueResult();
		pager.setTotalRows(totalRows);
		
		/**
		 * 查询具体数据
		 */
		criteria.setProjection(null);
		criteria.setFirstResult(pager.getIndex());
		criteria.setMaxResults(pager.getRows());
		criteria.addOrder(Order.desc("id"));
		List<?> datas = criteria.list();
		pager.setDatas(datas);		
		return pager;
	}

}

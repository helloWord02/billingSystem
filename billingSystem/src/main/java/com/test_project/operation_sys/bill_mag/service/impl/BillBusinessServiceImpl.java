package com.test_project.operation_sys.bill_mag.service.impl;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.PostageBean;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillBusinessDao;
import com.test_project.operation_sys.bill_mag.dao.IBillBusinessInfoDao;
import com.test_project.operation_sys.bill_mag.dao.impl.BillBusinessInfoDaoImpl;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessInfoService;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessService;
import com.test_project.pojos.PagerBean;

/**
 * 一个账务账号下所有业务账号当月发生的费用明细信息
 * 
 * @author huangjun
 *
 */
@Service
public class BillBusinessServiceImpl implements IBillBusinessService {

	@Resource
	private IBillBusinessDao billBusinessDaomImpl;
	@Resource
	private IBillBusinessInfoDao billBusinessInfoDaoImpl;

	@Override
	/**
	 * 保存一个业务月账单
	 * 
	 * @param buillBusi
	 */
	public void addBillBusiness(BillBusinessBean buillBusi) {
		billBusinessDaomImpl.saveBillBusiness(buillBusi);
	}

	@Override
	public PagerBean findAllBusinessByBillAccount(PagerBean pager) {
		// TODO Auto-generated method stub
		return billBusinessDaomImpl.findAllBusinessByBillAccount(pager);
	}

	/* (non-Javadoc)
	 * @see com.test_project.operation_sys.bill_mag.service.IBillBusinessService#saveSUMBillBusOfMonth(java.util.Map)
	 */
	@Override
	public void addSUMBillBusOfMonth(Map map) {
		
		//得到所有的业务对象
		List<BusinessBean> list=billBusinessInfoDaoImpl.findAllAccont();
		
		//查询当月的使用明细表情况,没有就收基本费用,有就计算费用
		for (BusinessBean busBean : list) {
			//得到基本信息
			String billAccount = busBean.getAccount().getBillAccount();
			PostageBean postage = busBean.getPostage();
			String ip = busBean.getIp();
			
			//查询是否有当月的登录记录
			map.put("businessAccount", busBean.getBusinessAccount());
			List<BillBusinessInfoBean> busInfoList = billBusinessInfoDaoImpl.findBillInfoMonth(map);
			// 查询业务账号下当月的业务登录详情,得到登录总时长
			long sumTime = 0;
			double SumPay = 0;
			if(busInfoList.size()!=0) {
				for (BillBusinessInfoBean BusinessInfo : busInfoList) {
					sumTime += BusinessInfo.getTimeLong();
				}
				// 计算总费用 资费类型1是小时 2是套餐 3是包月,
				if (postage.getType() == 1) {
					long horse = sumTime / 1000 / 60 / 60;
					SumPay = horse * postage.getBaisecost();
				}
				if (postage.getType() == 2 || postage.getType() == 3) {
					SumPay = postage.getBaisecost();
				}
			}
			
			else {
				if (postage.getType() == 2 || postage.getType() == 3) {
					SumPay = postage.getBaisecost();
				}
			}
			
			
			//日期转换  月从0--11
			int year=Integer.parseInt(map.get("year").toString());
			int month=Integer.parseInt(map.get("month").toString());
			Calendar c=new GregorianCalendar(year,month-1, 1);
			
			//构建对象,保存对象
			BillBusinessBean bean=new BillBusinessBean
					(billAccount, busBean.getBusinessAccount(), c.getTime()
							, SumPay, postage.getPostageName(), ip, sumTime);
			
			addBillBusiness(bean);
			
		}
			
		}

	@Override
	public List<BillBusinessBean> findbillBusByaccount(Map map) {
		// TODO Auto-generated method stub
		return billBusinessDaomImpl.findbillBusByaccount(map);
	}

}

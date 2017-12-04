package com.test_project.operation_sys.bill_mag.service.impl;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BillBean;
import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.operation_sys.bill_mag.dao.IBillDao;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessInfoService;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessService;
import com.test_project.operation_sys.bill_mag.service.IBillService;
import com.test_project.pojos.PagerBean;
/**
 * 账务账号业务层实现类
 * @author huangjun
 *
 */
@Service
public class BillSercviceImpl implements IBillService {

	@Resource
	private IBillDao billDaoImpl;
	
	@Resource
	private IBillBusinessService billBusinessServiceImpl;
	
	@Resource
	private IBillBusinessInfoService BillBusinessInfoServiceImpl;



	@Override
	public PagerBean findAllBillAccoutCost(PagerBean pager) {
		// TODO Auto-generated method stub

		return billDaoImpl.findAllBillAccoutCost(pager);
	}



	@Override
	public void addAllSumBill(BillBean bean) {
		// TODO Auto-generated method stub
		billDaoImpl.saveAllSumBill(bean);
	}



	@Override
	public List<AccountBean> findAllAccount() {
		// TODO Auto-generated method stub
		return billDaoImpl.findAllAccount();
	}



	@Override
	public void addAllBill(Map map) {
		// TODO Auto-generated method stub
		//查出所有的账务账号对象
		List<AccountBean> acclist=findAllAccount();
		
		for (AccountBean accountBean : acclist) {
			
			//查询出 某年月它下面的所有业务的账单
			map.put("account", accountBean.getBillAccount());
			List<BillBusinessBean> billBuslist=billBusinessServiceImpl.findbillBusByaccount(map);
			//计算总价
			double sumPay=0;
			for (BillBusinessBean billBusinessBean : billBuslist) {
				sumPay+=billBusinessBean.getCost();
			}
			
			//日期转换  月从0--11
			int year=Integer.parseInt(map.get("year").toString());
			int month=Integer.parseInt(map.get("month").toString());
			Calendar c=new GregorianCalendar(year,month-1, 1);
			
			//构建对象   支付状态 0表示未支付  1表示已支付
			BillBean bb=new BillBean(sumPay, accountBean.getBillAccount(), c.getTime(),
				accountBean.getIdCard(), 0,null,accountBean.getRealName());
			
			addAllSumBill(bb);
			
		}
	}



	@Override
	@Scheduled(cron="0 * * * * ?")
	public void addTimeDo() throws InterruptedException {
		// TODO Auto-generated method stub
		Map map=new HashMap<>();
		map.put("year", new Integer(2017));
		map.put("month", new Integer(11));
		BillBusinessInfoServiceImpl.addBillInfoMonth(map);
		
		billBusinessServiceImpl.addSUMBillBusOfMonth(map);
		
		addAllBill(map);
		
		System.out.println("关账了======================================");
	}

}

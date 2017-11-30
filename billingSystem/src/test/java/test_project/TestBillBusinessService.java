package test_project;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BillBean;
import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.PostageBean;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessInfoService;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessService;
import com.test_project.operation_sys.bill_mag.service.IBillService;
import com.test_project.operation_sys.bill_mag.service.impl.BillBusinessInfoServiceImpl;
import com.test_project.operation_sys.postage_mag.service.IPostageService;
import com.test_project.pojos.PagerBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestBillBusinessService {
	
	@Resource
	private IBillBusinessService billBusinessServiceImpl;
	
	@Test
	public void testFindBusinessByBusinessAccount() {
		
		BillBusinessBean b = new BillBusinessBean();
		
		b.setBillAccount("账务账号1");
		
		PagerBean pager = new PagerBean();
		pager.setRows(5);
		pager.setPage(1);
		Map<String, Object> map =  new HashMap<>();
		map.put("billAccount", b.getBillAccount());
		
		System.out.println("封装MAP："+map.get("billAccount"));
		pager.setParams(map);
		System.out.println("PagerBeanMAP"+pager.getParams().get("billAccount"));
		pager = billBusinessServiceImpl.findAllBusinessByBillAccount(pager);
		System.out.println(pager);
	}
	
}

package test_project;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.PostageBean;
import com.test_project.operation_sys.bill_mag.service.IBillBusinessInfoService;
import com.test_project.operation_sys.bill_mag.service.impl.BillBusinessInfoServiceImpl;
import com.test_project.operation_sys.postage_mag.service.IPostageService;
import com.test_project.pojos.PagerBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestBillBusinessInfoService {
	
	@Resource
	private IBillBusinessInfoService billBusinessInfoServiceImpl;
	
	@Test
	public void testFindBusinessByBusinessAccount() {
		BillBusinessInfoBean bb = new BillBusinessInfoBean();
		bb.setBusinessAccount("业务账户3");
		
		bb = billBusinessInfoServiceImpl.findBusinessByBusinessAccount(bb);
		System.out.println("详细业务账号信息："+bb);
	}
	
}

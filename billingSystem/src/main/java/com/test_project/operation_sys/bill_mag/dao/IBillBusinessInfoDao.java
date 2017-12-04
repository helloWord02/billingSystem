package com.test_project.operation_sys.bill_mag.dao;

import java.util.List;
import java.util.Map;

import com.test_project.bean.BillBusinessBean;
import com.test_project.bean.BillBusinessInfoBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.ServiceBean;
import com.test_project.pojos.PagerBean;

/**
 * 业务账号当月费用明细信息持久层接口
 * 
 * @author huangjun
 *
 */
public interface IBillBusinessInfoDao {

	/**
	 * 根据服务器提供的信息生成对应业务账号费用并保存到数据库
	 * 
	 * @param serviceBean
	 */
	public void saveBusinessInfoBean(BillBusinessInfoBean billInfo);

	/**
	 * 根据业务账号查询当前业务账号对应服务器信息
	 * 
	 * @param pager
	 * @return
	 */
	public BillBusinessInfoBean findBusinessByBusinessAccount(BillBusinessInfoBean billBusiness);
	/**
	 * 查询某业务账号某年月的所有账单详情
	 * @param map 年月  业务账号
	 */
	public List<BillBusinessInfoBean> findBillInfoMonth(Map<String, ?> map);
	/**
	 * 通过业务账号  查询出业务账号bean
	 * @param accont
	 * @return
	 */
	public BusinessBean findBUSBeanByAccont(String accont);
	
	/**
	 * 给业务账号分组,查询当月的所有业务账号
	 * @param map 年月 
	 * @return
	 */
	public List<String> findAllAccontByMonth(Map map);
	/**
	 * 查询所有的业务账号对象
	 * @return
	 */
	public List<BusinessBean> findAllAccont();

	/**
	 * 根据业务账号查询当前业务账号对应服务器信息
	 * 
	 * @param pager
	 * @return
	 */
	public PagerBean findBusinessByBusinessAccount(PagerBean pager);
	

}

package com.test_project.operation_sys.postage_mag.dao;

import java.util.List;

import com.test_project.bean.BusinessBean;
import com.test_project.bean.PostageBean;
import com.test_project.pojos.PagerBean;

public interface IPostageDao {
	/**
	 * 添加一条资费
	 * @param bean
	 */
	public void savePostage(PostageBean bean);
	
	/**
	 * 删除一条资费
	 * @param bean
	 */
	public void delPostageById(PostageBean bean); 
	/**
	 * 按id查询一条资费详情
	 * @param id
	 * @return
	 */
	public PostageBean  findPostageById(long id);
	/**
	 * 更新一条资费
	 * @return
	 */
	public void  updPostage(PostageBean bean);
	
	/**
	 * 根据id查询这条资费是否被业务引用
	 * @param id 资费id
	 * @return null为没被引用
	 */
	public long findIsDepend(long id);
	/**
	 * 分页查询资费
	 * @param page
	 * @return
	 */
	public PagerBean findPageByPostage(PagerBean page);

}

package com.test_project.operation_sys.postage_mag.service;

import java.util.List;

import com.test_project.bean.AccountBean;
import com.test_project.bean.PostageBean;
import com.test_project.pojos.PagerBean;

/**
 * 资费业务层接口
 * @author xyf
 *
 */
public interface IPostageService {
	/**
	 * 添加一条资费
	 * @param bean
	 */
	public void savePostage(PostageBean bean);
	
	/**
	 * 删除一条资费,在没有被业务引用的时候才可以删除
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
	 * 更新一条资费,只有在没有被业务引用的时候才能更新(这个页面上有业务的时候灰掉)
	 * @return
	 */
	public void  updPostage(PostageBean bean);
	
	/**
	 * 根据id查询这条资费是否被业务引用
	 * @param id 资费id
	 * @return true 为被引用了 false为没被引用
	 */
	public List<AccountBean> findIsDepend(long id);
	/**
	 * 分页查询资费
	 * @param page
	 * @return
	 */
	public PagerBean findPageByPostage(PagerBean page);
	

}

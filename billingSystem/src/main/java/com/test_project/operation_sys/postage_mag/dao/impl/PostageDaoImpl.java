package com.test_project.operation_sys.postage_mag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountBean;
import com.test_project.bean.PostageBean;
import com.test_project.operation_sys.postage_mag.dao.IPostageDao;
import com.test_project.pojos.PagerBean;
import com.test_project.util.BaseDao;

@Repository
public class PostageDaoImpl extends BaseDao implements IPostageDao{

	@Override
	public void savePostage(PostageBean bean) {
		// TODO Auto-generated method stub
		getSession().save(bean);
	}

	@Override
	public void delPostageById(PostageBean bean) {
		// TODO Auto-generated method stub
		getSession().delete(bean);
	}

	@Override
	public PostageBean findPostageById(long id) {
		// TODO Auto-generated method stub
		PostageBean bean=(PostageBean) getSession().get(PostageBean.class, id);
		return bean;
	}

	@Override
	public void updPostage(PostageBean bean) {
		// TODO Auto-generated method stub
		getSession().update(bean);
	}

	@Override
	public List<AccountBean> findIsDepend(long id) {
		String hql="from AccountBean a where a.billAccount=:id";
		Query q=getSession().createQuery(hql);
		q.setLong("id", id);
		List<AccountBean> list=q.list();
		return list;
	}

	@Override
	public PagerBean findPageByPostage(PagerBean page) {
		// TODO Auto-generated method stub
		return null;
	}

}

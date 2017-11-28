package com.test_project.operation_sys.postage_mag.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BusinessBean;
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
	public long findIsDepend(long id) {
		String hql="select count(b.id) from BusinessBean b where b.postage=:id";
		Query q=getSession().createQuery(hql);
		q.setLong("id", id);
		long l=(long) q.uniqueResult();
		return l;
	}

	@Override
	public PagerBean findPageByPostage(PagerBean page) {
		// TODO Auto-generated method stub
		
		String hql="from PostageBean p order by p.beginDate DESC";
		Query q=getSession().createQuery(hql);
		q.setFirstResult(page.getIndex());
		q.setMaxResults(page.getRows());
		List<PostageBean> list=q.list();
		page.setDatas(list);
		
		hql="select count(p.id) from PostageBean p";
		 q=getSession().createQuery(hql);
		 long i=(long) q.uniqueResult();
		 page.setTotalRows(Integer.parseInt(i+""));
		
		return page;
	}

}

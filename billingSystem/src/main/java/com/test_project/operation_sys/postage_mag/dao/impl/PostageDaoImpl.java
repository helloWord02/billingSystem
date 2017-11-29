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
		String dyn="";
		if((!"".equals(page.getParams().get("postageName")))&&page.getParams().get("postageName")!=null) {
			dyn+=" and p.postageName like CONCAT(:postageName,'%')";
		}
		if((Integer)page.getParams().get("postageType")!=0) {
			dyn+=" and p.type=:postageType";
		}
		
		String hql="from PostageBean p where 1=1"+dyn;
		System.out.println("hql=========="+hql);
		Query q=getSession().createQuery(hql);
		q.setProperties(page.getParams());
		q.setFirstResult(page.getIndex());
		q.setMaxResults(page.getRows());
		List<PostageBean> list=q.list();
		page.setDatas(list);
		
		hql="select count(p.id) from PostageBean p where 1=1"+dyn;
		 q=getSession().createQuery(hql);
		 q.setProperties(page.getParams());
		 long i=(long) q.uniqueResult();
		 page.setTotalRows(Integer.parseInt(i+""));
		
		return page;
	}

}

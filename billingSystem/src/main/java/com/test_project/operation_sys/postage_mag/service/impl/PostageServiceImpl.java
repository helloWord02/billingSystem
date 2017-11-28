package com.test_project.operation_sys.postage_mag.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test_project.bean.AccountBean;
import com.test_project.bean.BusinessBean;
import com.test_project.bean.PostageBean;
import com.test_project.operation_sys.postage_mag.dao.IPostageDao;
import com.test_project.operation_sys.postage_mag.service.IPostageService;
import com.test_project.pojos.PagerBean;

@Service
public class PostageServiceImpl implements IPostageService {
	@Resource
	private IPostageDao postageDao;

	@Override
	public void savePostage(PostageBean bean) {
		// TODO Auto-generated method stub
		postageDao.savePostage(bean);
	}

	@Override
	public void delPostageById(PostageBean bean) {
		// TODO Auto-generated method stub
		if(postageDao.findIsDepend(bean.getId())!=0) {
			postageDao.delPostageById(bean);
		}
		
	}

	@Override
	public PostageBean findPostageById(long id) {
		// TODO Auto-generated method stub
		
		return postageDao.findPostageById(id);
	}

	@Override
	public void updPostage(PostageBean bean) {
		// TODO Auto-generated method stub
		if(postageDao.findIsDepend(bean.getId())!=0) {
			postageDao.updPostage(bean);
		}
		
	}

	@Override
	public long findIsDepend(long id) {
		// TODO Auto-generated method stub
		return postageDao.findIsDepend(id);
	}

	@Override
	public PagerBean findPageByPostage(PagerBean page) {
		// TODO Auto-generated method stub
		return postageDao.findPageByPostage(page);
	}
	

}

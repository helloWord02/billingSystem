package com.test_project.operation_sys.postage_mag.service.impl;

import java.util.Date;
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
		bean.setState(1);
		if(bean.getType()==1) {
			//小时,得到单位,基本时长设置为1,单位费用==基本费用
			bean.setBaisetime(1);
			bean.setBaisecost(bean.getUnitcost());
		}
		else if(bean.getType()==2) {
			//套餐 ,得到基本时长,基本费用, 单位费用=基本费用/基本时长
			bean.setUnitcost(bean.getBaisecost()/bean.getBaisetime());
		}
		else if(bean.getType()==3) {
			//包月,得到基本费用,基本时长为0,单位费用0
			bean.setBaisetime(0);
			bean.setUnitcost(0);
		}
		postageDao.savePostage(bean);
	}

	@Override
	public void delPostageById(PostageBean bean) {
		// TODO Auto-generated method stub
			postageDao.delPostageById(bean);
		
	}

	@Override
	public PostageBean findPostageById(long id) {
		// TODO Auto-generated method stub
		
		return postageDao.findPostageById(id);
	}

	@Override
	public void updPostage(PostageBean bean) {
		// TODO Auto-generated method stub
		//查询出原有的bean
	PostageBean oldbean=postageDao.findPostageById(bean.getId());
	if(bean.getState()==2 &&oldbean.getState()==1) {
		oldbean.setBeginDate(new Date());
	}
	//非逻辑的设值
	oldbean.setPostageName(bean.getPostageName());
	oldbean.setCostexplain(bean.getCostexplain());
	oldbean.setState(bean.getState());
	oldbean.setType(bean.getType());
	//得到前面传过来的类型,按类型计算
	if(bean.getType()==1) {
		//小时,得到单位,基本时长设置为1,单位费用==基本费用
		oldbean.setUnitcost(bean.getUnitcost());
		oldbean.setBaisetime(1);
		oldbean.setBaisecost(bean.getUnitcost());
	}
	else if(bean.getType()==2) {
		//套餐 ,得到基本时长,基本费用, 单位费用=基本费用/基本时长
		oldbean.setBaisetime(bean.getBaisetime());
		oldbean.setBaisecost(bean.getBaisecost());
		oldbean.setUnitcost(bean.getBaisecost()/bean.getBaisetime());
	}
	else if(bean.getType()==3) {
		//包月,得到基本费用,基本时长为0,单位费用0
		oldbean.setBaisecost(bean.getBaisecost());
		oldbean.setBaisetime(0);
		oldbean.setUnitcost(0);
	}
	postageDao.updPostage(oldbean);
		
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

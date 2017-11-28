package com.test_project;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test_project.bean.PostageBean;
import com.test_project.operation_sys.postage_mag.service.IPostageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestPostage {
	
	@Resource
	private IPostageService postageService;
	
	@Test
	public void testSave() {
		PostageBean bean=new PostageBean("测试添加", 1, 123456, 0.5, 0.2, "就测一下", 0, new Date());
		postageService.savePostage(bean);
	}
	
	@Test
	public void testfindByID() {
		System.out.println(postageService.findPostageById(1));
	}
	
	@Test
	public void testdel() {
		PostageBean bean=postageService.findPostageById(5);
		postageService.delPostageById(bean);
	}
	
	@Test
	public void testUp() {
		PostageBean bean=postageService.findPostageById(1);
		bean.setPostageName("测试修改");
		System.out.println(bean);
		postageService.updPostage(bean);
	}

}

package com.test_project.common_sys.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Random;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class CodeController {

	
	
	@RequestMapping("/imgCode")
	public void imgCode(HttpServletRequest request,HttpServletResponse response){
		//在内存里面创建一张图片，宽度、高度、图片不透明，TYPE_INT_ARGB透明
				BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
				
				//获取到图片，用于在java平台获取带一个二维图形，
				//Graphics2D:提供了对几何图形、坐标转换，颜色管理或者文本格式的控制。
				Graphics2D g = (Graphics2D) image.getGraphics();
				
				//设置图片的背景
				g.setColor(Color.WHITE);
				//设置背景填充,第一个和第二个都是位置，第三个和第四个是要填充的大小
				g.fillRect(0, 0, 80, 20);
				
				//向图片上写数据
				//设置图片上文字的颜色
				g.setColor(Color.BLUE);
				//设置字体的风格
				g.setFont(new Font("微软雅黑",Font.BOLD,20));
				String num = getNum();
				//创建一个session用于装每个用户的验证码
				HttpSession session = request.getSession();
				session.setAttribute("code",num);
				g.drawString(num, 10, 20);
				
				
				//设置响应的MIME类型
				response.setContentType("image/jpeg");
				//控制浏览器不能缓存我图片
				response.setDateHeader("expries", -1);
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "no-cache");
				
				
				
				//将图片发送给浏览器
				try {
					ImageIO.write(image, "jpg", response.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
			public String getNum(){
				Random  r = new Random();
				String num = r.nextInt(9999)+"";
				
				StringBuffer b = new StringBuffer();
				for(int i=0;i<4-num.length();i++){
					b.append("0");
				}
				String newStr = b.toString()+num;
				return newStr;
			}
		
}

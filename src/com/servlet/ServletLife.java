package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet的生命周期：
 * 		1、从第一次调用到服务器关闭。
 * 		2、如果Servlet在web.xml中配置了load-on-startup，生命周期为从服务器启动到服务器关闭
 * 注意：
 * 		init方法是对Servlet进行初始化的一个方法，会在Servlet第一次加载进行存储时执行
 * 		destory方法是在servlet被销毁时执行，也就服务器关闭时。
 */
//@WebServlet("/life")
public class ServletLife extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		System.out.println("servlet初始化完成！");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.getWriter().write("life");
		System.out.println("life");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet销毁");
	}
}

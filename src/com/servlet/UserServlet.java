package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserSeviceImp;

@WebServlet("/user.do")
public class UserServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/xml;charset=utf-8");
		//获取请求信息
		String name=req.getParameter("name");
		System.out.println("用户请求信息为："+name);
		//处理请求信息
			//获取业务层对象
			UserService us=new UserSeviceImp();
			//处理业务
			User u=us.getUserInfoService(name);
			System.out.println("查询结果为:"+u);
		//响应处理结果
			resp.getWriter().write(new Gson().toJson(u));
	}
}

package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Address;
import com.pojo.OtherUser;

/**
 * 问题：
 * 	在servlet进行请求处理后，使用作用域对象作为数据流转的载体。将数据流转给对应的jsp文件。
 * 	那么怎么在jsp中获取作用域中的数据呢？
 * 使用：
 * 	传统方式:在jsp页面中使用java脚本段语句。
 */
@WebServlet("/es")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置请求编码格式
		req.setCharacterEncoding("utf-8");
		//设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		//获取请求信息
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		//处理请求信息
		System.out.println(uname+":"+pwd);
		//响应处理结果
			//使用request作用域进行数据流转
				//普通字符串
				req.setAttribute("str","今天的天气很清爽，适合学习");
				//对象类型
				OtherUser u=new OtherUser(1, "柳岩","拍电影",new Address("河南","商丘", "虞城县"));
				req.setAttribute("user", u);
				//集合类型
					//List集合
						//存储普通字符
						List<String> list=new ArrayList<String>();
						list.add("张家辉");
						list.add("关晓彤");
						list.add("刘诗诗");
						//存储对象
						OtherUser u2=new OtherUser(2, "古力娜扎","拍电影",new Address("新疆","乌鲁木齐","乌鲁木齐"));
						List<OtherUser> list2=new ArrayList<OtherUser>();
						list2.add(u2);
						req.setAttribute("list",list);
						req.setAttribute("list2",list2);
					//Map集合
						//存储普通字符
						Map<String,String> map=new HashMap<String,String>();
						map.put("a", "北京");
						map.put("b", "上海");
						map.put("c", "商丘");
						req.setAttribute("map",map);
						//存储对象
						Map<String,OtherUser> map2=new HashMap<String,OtherUser>();
						map2.put("a1", new OtherUser(3, "迪丽热巴","拍电影",new Address("新疆","吐鲁番","吐鲁番")));
						req.setAttribute("map2",map2);
					//空值判断
						req.setAttribute("s","");
						req.setAttribute("s1",new OtherUser());
						req.setAttribute("s2",new ArrayList());
						req.setAttribute("s3",new HashMap());
						
						
						
			//请求转发
			req.getRequestDispatcher("/el.jsp").forward(req, resp);	
			return;
	}

}

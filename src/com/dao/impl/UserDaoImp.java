package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.UserDao;
import com.pojo.User;

public class UserDaoImp implements UserDao {

	/**
	 * 获取用户信息
	 */
	@Override
	public User getUserInfo(String name) {
		//声明存储对象
		User u=null;
		//声明Jdbc对象
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获取连接对象
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","123456");
			//创建sql命令
			String sql="select * from t_user where uname=?";
			//创建sql命令对象
			ps=conn.prepareStatement(sql);
			//给占位符赋值
			ps.setString(1,name);
			//遍历查询
			rs=ps.executeQuery();
			if(rs.next()){
				u=new User();
				u.setId(rs.getInt("id"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}//关闭资源
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//返回
		return u;
	}
	
}

package com.zhao.util;

import java.sql.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import java.sql.Connection;
/**
 * JBDC 工具
 * @author j
 *
 */
public class DButil {
	private static String URL;
	private static String USER;
	private static String DRIVERCLASS;
	private static String PASSWORD;
	/**
	 * 静态初始化块 当类第一次被访问时执行
	 * 配置文件
	 */
	static {
		Properties p = new Properties();
		InputStream inStream;// 输入流
		try {
			inStream = DButil.class.getResourceAsStream("/com/zhao/util/test.properties");
			p.load(inStream);// 加载文件

			DRIVERCLASS = p.getProperty("driverClass");
			URL = p.getProperty("url");
			USER = p.getProperty("user");
			PASSWORD = p.getProperty("password");
			// String s = p.getProperty("cc");
			// System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 连接数据库 获取连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {

		Connection conn = null;
		try {
			Class.forName(DRIVERCLASS);
			conn =  DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * sql语句DML：增，删，改
	 * @return
	 * @param sql
	 * @param params
	 */
	public static boolean executeDML(String sql, Object[] params) {
		Connection conn = null;
		// 预处理 预编译 占位符 ？/:变量名(占位符只能代表一个值)
		PreparedStatement ps = null;
		boolean b = false;
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			// sql带有？ 需要设置参数
			if (null != params && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject((i + 1), params[i]);
				}
			}
			b = ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)ps.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
	}

	/**
	 * sql查询语句
	 */
	public static List<Object[]> executeQurry(String sql, Object[] params) {
		Connection conn = null;
		// 预处理 预编译 占位符 ？/:变量名(占位符只能代表一个值)
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Object[]> list = new ArrayList<Object[]>();
		try {
			conn = DButil.getConnection();
			ps = conn.prepareStatement(sql);
			// sql带有？ 需要设置参数
			if (null != params && params.length > 0) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject((i + 1), params[i]);
				}
			}
			rs = ps.executeQuery();
			// 处理结果集 获取结果集列数
			int columncount = rs.getMetaData().getColumnCount();
			Object[] os = null;
			while (rs.next()) {
				os = new Object[columncount];
				for (int i = 0; i < columncount; i++) {
					os[i] = rs.getObject(i + 1);
				}
				list.add(os);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)rs.close();
				if(ps!=null)ps.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		return list;
	}

}

package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.util.SpringApplicationContext;
import com.util.Util;



public class DB {
	public static String SQLTYPE="mysql";
	static{
		try {
			//Class.forName(Util.getPropertyResourceBundleValue("jdbc", "jdbc.driverClassName"));
			//加载数据库类型
			//SQLTYPE=(Util.getPropertyResourceBundleValue("jdbc", "jdbc.sqltype"));
			if(SQLTYPE==null){
				SQLTYPE="sqlserver";
			}
		} catch (Exception e) {
		}
	}
	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConnection(){
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection(Util.getPropertyResourceBundleValue("jdbc","jdbc.url"), 
//					Util.getPropertyResourceBundleValue("jdbc","jdbc.username"),
//					Util.getPropertyResourceBundleValue("jdbc", "jdbc.password"));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		com.jolbox.bonecp.BoneCPDataSource ds =SpringApplicationContext.getApplicationContext().getBean(com.jolbox.bonecp.BoneCPDataSource.class);
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 执行SQL语句增删改
	 * @param sql
	 * @return
	 */
	public int executeSql(String sql){
		Connection connection = getConnection();
		Statement stmt= null;
		try {
			stmt= connection.createStatement();
			int res = stmt.executeUpdate(sql);
			return res;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return -1;
	}
	public List<Map<String, Object>> query(String sql){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Connection connection = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs=stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int cc = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= cc; i++) {
					String c =md.getColumnName(i);
					Object object = rs.getObject(c);
					if(object==null){
						object="";
					}
					else if(object instanceof java.sql.Date ){
						java.sql.Date da = (Date) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}
					else if(object instanceof java.sql.Timestamp ){
						java.sql.Timestamp da = (java.sql.Timestamp) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}
					map.put(c.toLowerCase(), object);
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (stmt!=null) {
					stmt.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Map<String, Object>> query(String sql,Object[] obj){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Connection connection = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				stmt.setObject(i+1, obj[i]);
			}
			rs=stmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int cc = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= cc; i++) {
					String c =md.getColumnName(i);
					Object object = rs.getObject(c);
					if(object==null){
						object="";
					}else if(object instanceof java.sql.Date ){
						java.sql.Date da = (Date) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}else if(object instanceof java.sql.Timestamp ){
						java.sql.Timestamp da = (java.sql.Timestamp) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}
					map.put(c.toLowerCase(), object);
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (stmt!=null) {
					stmt.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<List> queryList(String sql){
		List<List> list = new ArrayList<List>();
		Connection connection = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs=stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int cc = md.getColumnCount();
			while (rs.next()) {
				List list1 = new ArrayList();
				for (int i = 1; i <= cc; i++) {
					String c =md.getColumnName(i);
					Object object = rs.getObject(c);
					if(object==null){
						object="";
					}else if(object instanceof java.sql.Date ){
						java.sql.Date da = (Date) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}else if(object instanceof java.sql.Timestamp ){
						java.sql.Timestamp da = (java.sql.Timestamp) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}
					list1.add(object);
				}
				list.add(list1);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (stmt!=null) {
					stmt.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<List> queryList(String sql,Connection connection){
		List<List> list = new ArrayList<List>();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs=stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int cc = md.getColumnCount();
			while (rs.next()) {
				List list1 = new ArrayList();
				for (int i = 1; i <= cc; i++) {
					String c =md.getColumnName(i);
					Object object = rs.getObject(c);
					if(object==null){
						object="";
					}else if(object instanceof java.sql.Date ){
						java.sql.Date da = (Date) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}else if(object instanceof java.sql.Timestamp ){
						java.sql.Timestamp da = (java.sql.Timestamp) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}
					else if(object instanceof byte[] ){
						object = new String((byte[])object);
					}
					list1.add(object);
				}
				list.add(list1);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (stmt!=null) {
					stmt.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<List> queryList(String sql,Object[] obj){
		List<List> list = new ArrayList<List>();
		Connection connection = getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				stmt.setObject(i+1, obj[i]);
			}
			rs=stmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int cc = md.getColumnCount();
			while (rs.next()) {
				List list1 = new ArrayList();
				for (int i = 1; i <= cc; i++) {
					String c =md.getColumnName(i);
					Object object = rs.getObject(c);
					if(object==null){
						object="";
					}else if(object instanceof java.sql.Date ){
						java.sql.Date da = (Date) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}else if(object instanceof java.sql.Timestamp ){
						java.sql.Timestamp da = (java.sql.Timestamp) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}
					list1.add(object);
				}
				list.add(list1);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (stmt!=null) {
					stmt.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<List> queryList(String sql,Object[] obj,Connection connection){
		List<List> list = new ArrayList<List>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				stmt.setObject(i+1, obj[i]);
			}
			rs=stmt.executeQuery();
			ResultSetMetaData md = rs.getMetaData();
			int cc = md.getColumnCount();
			while (rs.next()) {
				List list1 = new ArrayList();
				for (int i = 1; i <= cc; i++) {
					String c =md.getColumnName(i);
					Object object = rs.getObject(c);
					if(object==null){
						object="";
					}else if(object instanceof java.sql.Date ){
						java.sql.Date da = (Date) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}else if(object instanceof java.sql.Timestamp ){
						java.sql.Timestamp da = (java.sql.Timestamp) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}
					list1.add(object);
				}
				list.add(list1);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (stmt!=null) {
					stmt.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<Map<String, Object>> queryUpper(String sql){
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Connection connection = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs=stmt.executeQuery(sql);
			ResultSetMetaData md = rs.getMetaData();
			int cc = md.getColumnCount();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (int i = 1; i <= cc; i++) {
					String c =md.getColumnName(i);
					Object object = rs.getObject(c);
					if(object==null){
						object="";
					}else if(object instanceof java.sql.Date ){
						java.sql.Date da = (Date) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}else if(object instanceof java.sql.Timestamp ){
						java.sql.Timestamp da = (java.sql.Timestamp) object;
						object = new String(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(da));
					}
					map.put(c.toUpperCase(), object);
				}
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if (rs!=null) {
					rs.close();
				}
				if (stmt!=null) {
					stmt.close();
				}
				if (connection!=null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public String queryFirst(String sql){
		String res="";
		Connection connection = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			int cc = rs.getMetaData().getColumnCount();
			if (rs.next()) {
					Object object = rs.getObject(1);
					if(object!=null){
						res=object.toString();
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if (stmt!=null)
					stmt.close();
				if(connection!=null)
					connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	public String queryFirst(String sql,Connection connection){
		String res="";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			int cc = rs.getMetaData().getColumnCount();
			if (rs.next()) {
				Object object = rs.getObject(1);
				if(object!=null){
					res=object.toString();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null)
					rs.close();
				if (stmt!=null)
					stmt.close();
				if(connection!=null)
					connection.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	public int batchSql(String[] sqls){
		Connection con = null;
		Statement stmt = null;
		int res = 0;
		try {
			con =getConnection();
			con.setAutoCommit(false);
			stmt =con.createStatement();
			stmt.clearBatch();
			for(String sql:sqls){
				stmt.addBatch(sql);
			}
			int[]temp =stmt.executeBatch();
			for(int test:temp){
				if(test<0){
					res=-1;
					break;
				}
			}
			if(res>=0){
				res=temp.length;
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			res=-1;
			try {
			con.rollback();
			} catch (SQLException e1) {
			}
		}finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return res;
	}
	public int batchSql(List<String> sqls){
		Connection con = null;
		Statement stmt = null;
		int res = 0;
		try {
			con =getConnection();
			con.setAutoCommit(false);
			stmt =con.createStatement();
			stmt.clearBatch();
			for(String sql:sqls){
				stmt.addBatch(sql);
			}
			int[]temp =stmt.executeBatch();
			for(int test:temp){
				if(test<0){
					res=-1;
					break;
				}
			}
			if(res>=0){
				res=temp.length;
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			res=-1;
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
		}finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return res;
	}
	public int batchSql(String sql,List<String> keys,List<Map<String,Object>> param){
		Connection con = null;
		PreparedStatement  stmt = null;
		int res = 0;
		try {
			con =getConnection();
			con.setAutoCommit(false);
			stmt =con.prepareStatement(sql);
			for(Map<String,Object> map:param){
				int i=1;
				for(String key:keys){
					stmt.setObject(i, map.get(key));
					i++;
				}
				stmt.addBatch();
			}
			int[]temp =stmt.executeBatch();
			for(int test:temp){
				if(test<0){
					res=-1;
					break;
				}
			}
			if(res>=0){
				res=temp.length;
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			res=-1;
			try {
				con.rollback();
			} catch (SQLException e1) {
			}
		}finally{
			try {
				if(stmt!=null){
					stmt.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
			}
		}
		return res;
	}
	public static void main(String[] args) {
	}
}
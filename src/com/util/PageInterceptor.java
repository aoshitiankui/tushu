package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})  
public class PageInterceptor implements Interceptor {
	private static Logger logger = LoggerFactory.getLogger(PageInterceptor.class);
	private static String filterMethod=".*ByCondition$";
	private static String dialect="oracle";
	private static String[] filterPackages;
	static{
			dialect = Util.getPropertyResourceBundleValue("jdbc","sql.dialect");
			String tmp = Util.getPropertyResourceBundleValue("jdbc","sql.mybatis.exc.package");
			if(tmp!=null){
				filterPackages = tmp.split(",");
			}
	}
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		if(filterPackages==null){
			return invocation.proceed(); 
		}
		StatementHandler statementHandler = (StatementHandler)invocation.getTarget();  
		MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,new DefaultReflectorFactory());  
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");  
		String id = mappedStatement.getId();  
		String packAge = id.substring(0,id.lastIndexOf("."));
		boolean con = false;
		for(String test : filterPackages){
			if(packAge.matches(test)){
				con = true;
				break;
			}
		}
		if(con&&id.matches(filterMethod)){  
			BoundSql boundSql = statementHandler.getBoundSql();
			Object object = boundSql.getParameterObject();
			if (!(object instanceof Map||object instanceof Page)){
				throw new  Exception("分页查询入参必须为Page或者Map");
			}
			//PageInfo page = (PageInfo)boundSql.getParameterObject();  
			String sql = boundSql.getSql();  
			String col = null;
			MappedStatement tmp = null;
			try {
				tmp = mappedStatement.getConfiguration().getMappedStatement(id+"_col",false);
			} catch (Exception e) {
			}
			if(tmp!=null){
				col = tmp.getBoundSql(null).getSql();
			}
			metaObject.setValue("delegate.boundSql.sql", getSql(sql,col,object,0));  
		}  
		return invocation.proceed();  
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);  
	}

	@Override
	public void setProperties(Properties properties) {

	}
	private String getSql(String sql,String col,Object obj,int total)throws Exception{
		int no = 1 ;
		int size = 15;
		if(obj instanceof Page){
			Page temp = (Page) obj;
			no = temp.getPageNumber();
			size = temp.getPageSize();
		}else{
			Map temp = (Map) obj;
			try {
				no = Integer.parseInt(temp.get("pageNo").toString());
			} catch (Exception e) {			
			}
			try {
				size = Integer.parseInt(temp.get("pageSize").toString());
			} catch (Exception e) {
			}
		}
		if("oracle".equals(dialect)){
			if(col==null){
				col="*";
			}
			return "select "+col+" from (select t_.*,rownum rn from ("+sql+")  t_ where rownum<="+(no*size)+") t where rn >="+(((no-1)*size)+1);
		}else if("mysql".equals(dialect)){
			String tmp = sql+" limit "+((no-1)*size)+","+size;
			if(col==null){
				return tmp;
			}else{
				return "select "+col+" from ("+tmp+") t";
			}
		}else{
			throw new Exception(dialect+" not support...");
		}
	}

	public void ObjColletions(){

	}
	/*public static void main(String[] args) {
		SpringApplicationContext.setClassPathXmlApplicationContext("conf/conf-application.xml");
		UserMapper user = SpringApplicationContext.getApplicationContext().getBean(UserMapper.class);
		UserModel u = new UserModel();
		List test = user.queryByPage(u);
		System.out.println(JSONUtil.converObject2String(test));
		System.out.println(test.size());
	}*/
}

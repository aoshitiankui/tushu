＃图书推荐商城
图书商城系统采用B/S结构(Browser/Server,浏览器/服务器结构)和基于Web服务两种模式，是一个适用于Internet环境下的模型结构。

管理员登录界面

核心代码：

	@RequestMapping("login")
	public String login(){
		String userId = SpringApplicationContext.getRequest().getParameter("userId");
		String passWord = SpringApplicationContext.getRequest().getParameter("passWord");
		String sql = "select * from users where userId='"+userId+"' and password='"+passWord+"'";
		DB db = new DB();
		List<Map<String, Object>> res = db.query(sql);
		String content = "";
		if(res==null||res.size()==0){
			content=("{\"return_code\":\"error\"}");
		}else{
			SpringApplicationContext.getRequest().getSession().setAttribute("user", res.get(0));
			Map map = res.get(0);
			content=("{\"return_code\":\"ok\",\"type\":\""+map.get("usertype")+"\"}");
		}
		Util.printResult(SpringApplicationContext.getResponse(), content, true);
		return null;
	}














管理员个人信息界面

核心代码：

@RequestMapping("updpwd")
	
	public String updpwd(){
		String userId = SpringApplicationContext.getRequest().getParameter("userId");
		String passWord = SpringApplicationContext.getRequest().getParameter("passWord");
		String sql = "update users set password='"+passWord+"' where userId='"+userId+"'";
		DB db = new DB();
		int i = db.executeSql(sql);
		Res res = new Res();
		if(i>=0){
			res.setCode(0);
			res.setMsg("修改成功！");
		}else{
			res.setMsg("修改失败！");
		}
		Util.printResult(SpringApplicationContext.getResponse(), res);
		return null;
	}


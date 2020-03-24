function updateMiniCart(){
	$.post(cur_path+"/cart/findCartOfMini.do", function(data) {
		if(data){
			$("#mymoney").text(data.money);
			$("#mycount").text(data.num);
		}
    },"json");
	
}
function loadCart(){
	if(!cur_user){
		BootstrapDialog.show({
			title : '系统提示',
			type : BootstrapDialog.TYPE_DANGER,
			message : '你还未登录,请登录后操作',
            closeByBackdrop: false,
            closeByKeyboard: false,
			buttons : [ {
				label : '确定',
				action : function(dialogRef) {
					dialogRef.close();
					window.location.href=cur_path+"/customer/login.jsp";
				}
			} ]
		  });
		
		
	}else{
		
		window.location.href= cur_path+"/index.jsp?jumpUrl="+decodeURI( cur_path+"/CartList.jsp")
    }
	 
	return false
}
function addTocart(row,index){
	if(!cur_user){
		BootstrapDialog.show({
			title : '系统提示',
			type : BootstrapDialog.TYPE_DANGER,
			message : '你还未登录,请登录后操作',
            closeByBackdrop: false,
            closeByKeyboard: false,
			buttons : [ {
				label : '确定',
				action : function(dialogRef) {
					dialogRef.close();
					window.location.href=cur_path+"/customer/login.jsp";
				}
			} ]
		  });
		
		
	}else{
		var urls=cur_path+"/cart/addCart.do?bid="+row.bid;
		if(row.buynum){
			var urls=cur_path+"/cart/addCart.do?bid="+row.bid+"&cnum="+row.buynum;
		}
		$.post(urls, function(data) {
    		if(data.code==0){
				BootstrapDialog.show({
					title : '系统提示',
					type : BootstrapDialog.TYPE_SUCCESS,
					message : '添加购物车成功',
		            closeByBackdrop: false,
		            closeByKeyboard: false,
					buttons : [ {
						label : '确定',
						action : function(dialogRef) {
							dialogRef.close();
							updateMiniCart();
						}
					} ]
				  });
    		}else{
				BootstrapDialog.show({
					title : '系统提示',
					type : BootstrapDialog.TYPE_DANGER,
					message : '添加购物车失败',
		            closeByBackdrop: false,
		            closeByKeyboard: false,
					buttons : [ {
						label : '确定',
						action : function(dialogRef) {
							dialogRef.close();
						}
					} ]
				  });
    			
    		}
        },"json");
    }
	 
	  
	
	return false
}
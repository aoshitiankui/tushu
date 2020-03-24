$(function(){
	
    /*
        Fullscreen background
    */
    $.backstretch(cur_path+"/assets/loginassets/bg/1.jpg");

    
    $("#login").click(function(){
    	
        $("#loginForm").bootstrapValidator('validate').off('success.form.bv').on('success.form.bv', function(e) { 
        	e.preventDefault();
    		//if( $("#loginForm").data('bootstrapValidator').isValid()){
    			//e.preventDefault();
    			var ls_url = cur_path + "/checkCode.do?method=checkCode&code="+$("#code").val();
    			$.post(ls_url,function(data){
    				var return_code = data.return_code;
    				if(return_code=='ok'){
    					$.get( cur_path + "/login.do?method=login&userId="+$("#userId").val()+"&passWord="+md5($("#passWord").val())+"&d="+new Date(),function (data1){
    						return_code = data1.return_code;
    						if(return_code!='ok'){
								BootstrapDialog.show({
									title : '系统提示',
									message : '用户名或者密码有误',
						            closeByBackdrop: false,
						            closeByKeyboard: false,
									buttons : [ {
										label : '确定',
										action : function(dialogRef) {
											dialogRef.close();
										}
									} ]
								  });
    						}else{
    							window.location.href=cur_path + "/index.jsp";
    						}
    					});
    				}else{
						BootstrapDialog.show({
							title : '系统提示',
							message : '验证码输入有误',
				            closeByBackdrop: false,
				            closeByKeyboard: false,
							buttons : [ {
								label : '确定',
								action : function(dialogRef) {
									dialogRef.close();
								}
							} ]
						  });
    					return  false;
    				}
    			},"json");
    		//	return false;
    		//}


    		});
    	
    })
})
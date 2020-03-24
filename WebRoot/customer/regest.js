$(function(){
	

    
    $("#regest").click(function(){
    	
        $("#regestForm").bootstrapValidator({

        	fields: {
        		userId: {
	                    validators: {
	                        notEmpty: {
	                            message: '用户名不能为空'
	                        },
	                        stringLength: {
	                            /*长度提示*/
	                            min: 4,
	                            max: 15,
	                            message: '用户名长度必须在4到15之间'
	                        },
	                        threshold: 4,//只有4个字符以上才发送ajax请求
	                        remote: {
	                            url: cur_path+"/checkusername.do",
	                            data: function (validator) {
	                                return {
	                                	userid: $("#userId").val()
	                                    
	                                };
	                            },
	                            message: '该用户名已被使用，请使用其他用户名',
	                            delay:2000
	                        }
	                    }
	                }

        	  }
        	
        }).off('success.form.bv').on('success.form.bv', function(e) { 
        	e.preventDefault();
    		//if( $("#loginForm").data('bootstrapValidator').isValid()){
    			//e.preventDefault();
    					$.post( cur_path + "/regest.do?method=login&userId="+$("#userId").val()+"&email="+$("#email").val()+"&passWord="+md5($("#passWord").val())+"&d="+new Date(),function (data1){
    						if(data1.code== 0){

								
								BootstrapDialog.show({
									title : '系统提示',
									message : '注册成功',
						            closeByBackdrop: false,
						            closeByKeyboard: false,
									buttons : [ {
										label : '确定',
										action : function(dialogRef) {
											dialogRef.close();
											window.location.href=cur_path + "/customer/login.jsp";
										}
									} ]
								  });
    						}else{
								BootstrapDialog.show({
									title : '系统提示',
									message : '注册失败,请稍后再试',
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
    					});

    			


    		});
    	
    })
})
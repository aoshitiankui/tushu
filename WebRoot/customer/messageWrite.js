$(function(){
    $("#messageButton").click(function(){
    	
        $("#messageForm").bootstrapValidator('validate').off('success.form.bv').on('success.form.bv', function(e) { 
        	e.preventDefault();
 
    			var ls_url = cur_path+'/message/addMessage.do';
 
    					$.post( ls_url ,$("#messageForm").serializeJSON(),function (data1){
    						 
    						if(data1.code=='0'){
								BootstrapDialog.show({
									title : '系统提示',
									message : '操作成功,感谢您的意见/建议！',
						            closeByBackdrop: false,
						            closeByKeyboard: false,
									buttons : [ {
										label : '确定',
										action : function(dialogRef) {
											dialogRef.close();
											window.location.href=window.location.href;
										}
									} ]
								  });
    						}else{
								BootstrapDialog.show({
									title : '系统提示',
									message : '操作失败,请稍后重试！',
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
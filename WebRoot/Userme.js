$(function(){
	$("#usertype").attr("readonly","readonly");
	$("#usertype option[value!='"+$('#usertype').val()+"']").remove().attr("readonly","readonly");
	initDateAndTime();
	var bootstrapFileinputInit1 = new bootstrapFileinputInit({
		eId:'img',
		eIdName:'imgName',
        cName:"头像"
	});
	bootstrapFileinputInit1.on("fileuploaded", function(event, data) { 
        $("#img").val(data.response.rows[0].id).change();
	}).on("filecleared",function(){
		$("#img").val("").change();
	});
	
	$('#savefrom').click(function(){
	    $("#UsermeForm").bootstrapValidator({excluded:[":disabled"]}).off('success.form.bv').on('success.form.bv', function(e) {
	    		e.preventDefault();
				$.post(cur_path+'/user/updUser.do',$("#UsermeForm").serialize(), function(data) {
		        		if(data.code==0){
		        			 
							BootstrapDialog.show({
								title : '系统提示',
								type : BootstrapDialog.TYPE_SUCCESS,
								message : '保存成功',
					            closeByBackdrop: false,
					            closeByKeyboard: false,
								buttons : [ {
									label : '确定',
									//cssClass: 'btn-primary',
									action : function(dialogRef) {
										dialogRef.close();
									}
								} ]
							  });
		        			
		        		}else{
							BootstrapDialog.show({
								title : '系统提示',
								type : BootstrapDialog.TYPE_DANGER,
								message : '保存失败',
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
					

				});

		})
})
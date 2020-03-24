function bootstrapOfTable(option){
	var checkboxMenu = {
            checkbox: true,
            title: '选择'
    };
	var tableOrders ={
			title : '序号',
			align: "center",
			formatter: function (value, row, index) {
			    return pageSize * (pageNumber - 1) + index + 1;
			}
	}
	var settings={
			url:undefined,
			tId:undefined,
		    paramForm:undefined,			
/*		    queryParams: function (params) {
		        return {
		            pageSize : 15, //排序
		            pageNo : 1 //页码
		        };
		    },*/
		    setColPrimaryKeys:"",//当前行的主键列
		    method: 'post',
		    striped:true,
		    sortable: false,
		    queryParams:undefined,
		    showHeader : true,
		    showColumns : false,
		    showRefresh : false,
		    clickToSelect:true,
		    singleSelect:true,
		    checkbox: true,//显示CHECKBOX选项
		    tableOrders:true,//显示排序序号
		    pagination: true,//分页
		    paginationLoop:false,
		    sidePagination : 'server',//服务器端分页
		    queryParamsType:'',//不启用restful风格
		    pageNumber : 1,
		    contentType:'application/x-www-form-urlencoded; charset=UTF-8',	
		    pageList: [15, 20, 50],//分页步进值
		    classes: 'table',
		    onDblClickRow:undefined
			 
			
	}
	
	this.settings= $.extend({}, settings, option);
	this.settings.queryParams = function(params){
		params = {pageNumber:this.pageNumber,pageSize:this.pageSize};
		var pJson = $("#"+this.paramForm).serializeJSON();
		for(var key in pJson){  
            try{  
             if(!pJson[key]){
            	 delete pJson[key];  
             }		
            }catch(e){}  
        }  
		if(this.paramForm){
			params = $.extend({}, params, pJson);
		}
		return params;
	}
	if(this.settings.checkbox){
		
		
		this.settings.columns.unshift(checkboxMenu);
	}
	
	if(this.settings.tableOrders){
		
		
		this.settings.columns.unshift({
			title : '',
			align: "center",
			width: 40,
			formatter: function (value, row, index) {
			    return   index + 1;
			}
		});
	}

	var btable = $("#"+this.settings.tId).bootstrapTable(this.settings);
	
	btable.btn_add = function(modal,openUrl,saveUrl,formId,eCall){
		var $modal=$(modal);
		$modal.modal(
				{
					remote: openUrl
					
				}).off('loaded.bs.modal').on('loaded.bs.modal',function(e){
					$("#modalTitle").append("新增");
					eCall($modal,formId);
					//$(formId).bootstrapValidator('resetForm', true);//此处为了处理 加载远端数据 VD不初始化//http://blog.csdn.net/zero_295813128/article/details/52692277
					//$(formId)[0].reset();
					$modal.find('button[id="bsSave"]').click(function(e2){
					    $(formId).bootstrapValidator({excluded:[":disabled"]}).off('success.form.bv').on('success.form.bv', function(e) {
					    	e.preventDefault();
							$.post(saveUrl,$(formId).serialize(), function(data) {
					        		if(data.code==0){
					        			$modal.modal('hide')
										BootstrapDialog.show({
											title : '系统提示',
											type : BootstrapDialog.TYPE_SUCCESS,
											message : '添加成功',
								            closeByBackdrop: false,
								            closeByKeyboard: false,
											buttons : [ {
												label : '确定',
												action : function(dialogRef) {
													dialogRef.close();
													btable.bootstrapTable('refresh');
												}
											} ]
										  });
					        		}else{
										BootstrapDialog.show({
											title : '系统提示',
											type : BootstrapDialog.TYPE_DANGER,
											message : '添加失败',
								            closeByBackdrop: false,
								            closeByKeyboard: false,
											buttons : [ {
												label : '确定',
												action : function(dialogRef) {
													dialogRef.close();
													//btable.bootstrapTable('refresh');
												}
											} ]
										  });
			    	        			
			    	        		}
					            },"json");


							});
					})
					
				}).off('hidden.bs.modal').on("hidden.bs.modal", function(e) {
					 //e.preventDefault();
					 $(this).removeData("bs.modal");
				});

	}
	//param(窗口id,打开窗口加载的url,保存数据url,窗口中FROM的ID)
	btable.btn_edit = function(modal,openUrl,saveUrl,formId,eCall){
		
		var $modal=$(modal);
		
		if(btable.bootstrapTable('getSelections').length==0){
/*			Modal.tip({
		        title:'系统提示',  
		        msg: '请选择要操作的行' 
			});*/
	        BootstrapDialog.show({
	            title: '系统提示',
	            type: BootstrapDialog.TYPE_DANGER,
	            message: '请选择要操作的行',
	            closeByBackdrop: false,
	            closeByKeyboard: false,
	            buttons: [{
	            	label: '确定',
	                action: function(dialogRef){
	                    dialogRef.close();
	                }
	            }]
	        });
			return false;
		}		
		
		
		$modal.modal(
				{
					remote: openUrl+"?"+btable.bootstrapTable('getOptions').setColPrimaryKeys+"="+btable.bootstrapTable('getSelections')[0][btable.bootstrapTable('getOptions').setColPrimaryKeys]
					
				}).off('loaded.bs.modal').on('loaded.bs.modal',function(e){
					$("#modalTitle").append("编辑");
					eCall($modal,formId);
					
				$modal.find('button[id="bsSave"]').click(function(){
				    $(formId).bootstrapValidator({excluded:[":disabled"]}).off('success.form.bv').on('success.form.bv', function(e) {
				    		e.preventDefault();
							$.post(saveUrl,$(formId).serialize(), function(data) {
					        		if(data.code==0){
					        			$modal.modal('hide');
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
													btable.bootstrapTable('refresh');
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
													//btable.bootstrapTable('refresh');
												}
											} ]
										  });
			    	        			
			    	        		}
					            },"json");
								

							});

					})
				}).off('hidden.bs.modal').on("hidden.bs.modal", function(e) {
					 //event.preventDefault();
					 $(this).removeData("bs.modal");
				});

	}
	
	
	btable.btn_delete=function(saveUrl){
		
		if(btable.bootstrapTable('getSelections').length==0){
			/*			Modal.tip({
					        title:'系统提示',  
					        msg: '请选择要操作的行' 
						});*/
				        BootstrapDialog.show({
				            title: '系统提示',
				            type: BootstrapDialog.TYPE_DANGER,
				            message: '请选择要操作的行',
				            closeByBackdrop: false,
				            closeByKeyboard: false,
				            buttons: [{
				            	label: '确定',
				                action: function(dialogRef){
				                    dialogRef.close();
				                }
				            }]
				        });
						return false;
					}	
	        BootstrapDialog.confirm({
	            title: '系统提示',
	            message: '确认要删除么',
	            type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
	            closable: true, // <-- Default value is false
	            draggable: false, // <-- Default value is false
	            btnCancelLabel: '取消', // <-- Default value is 'Cancel',
	            btnOKLabel: '确定', // <-- Default value is 'OK',
	            btnOKClass: 'btn-warning', // <-- If you didn't specify it, dialog type will be used,
	            closeByBackdrop: false,
	            closeByKeyboard: false,
	            callback: function(result) {
	                // result will be true if button was click, while it will be false if users close the dialog directly.
	                if(result) {
	    				$.post(saveUrl+"?"+btable.bootstrapTable('getOptions').setColPrimaryKeys+"="+btable.bootstrapTable('getSelections')[0][btable.bootstrapTable('getOptions').setColPrimaryKeys], function(data) {
	    	        		if(data.code==0){
								BootstrapDialog.show({
									title : '系统提示',
									type : BootstrapDialog.TYPE_SUCCESS,
									message : '删除成功',
						            closeByBackdrop: false,
						            closeByKeyboard: false,
									buttons : [ {
										label : '确定',
										action : function(dialogRef) {
											dialogRef.close();
											btable.bootstrapTable('refresh');
										}
									} ]
								  });
	    	        		}else{
								BootstrapDialog.show({
									title : '系统提示',
									type : BootstrapDialog.TYPE_DANGER,
									message : '删除失败',
						            closeByBackdrop: false,
						            closeByKeyboard: false,
									buttons : [ {
										label : '确定',
										action : function(dialogRef) {
											dialogRef.close();
											btable.bootstrapTable('refresh');
										}
									} ]
								  });
	    	        			
	    	        		}
	    	            },"json");
	                }
	            }
	        });
 
	}
	btable.btn_search = function(){
		btable.bootstrapTable('removeAll');
		btable.bootstrapTable('refresh');		
	}
	
	//param(窗口id,打开窗口加载的url,保存数据url,窗口中FROM的ID)
	btable.btn_view = function(modal,openUrl,eCall,formId){
		
		var $modal=$(modal);
		
		if(btable.bootstrapTable('getSelections').length==0){
	        BootstrapDialog.show({
	            title: '系统提示',
	            type: BootstrapDialog.TYPE_DANGER,
	            message: '请选择要操作的行',
	            closeByBackdrop: false,
	            closeByKeyboard: false,
	            buttons: [{
	            	label: '确定',
	                action: function(dialogRef){
	                    dialogRef.close();
	                }
	            }]
	        });
			return false;
		}		
		
		
		$modal.modal(
				{
					remote: openUrl+"?"+btable.bootstrapTable('getOptions').setColPrimaryKeys+"="+btable.bootstrapTable('getSelections')[0][btable.bootstrapTable('getOptions').setColPrimaryKeys]
					
				}).off('loaded.bs.modal').on('loaded.bs.modal',function(e){
					$("#modalTitle").append("查看");
					eCall($modal,formId);				
				}).off('hidden.bs.modal').on("hidden.bs.modal", function(e) {
					 $(this).removeData("bs.modal");
				});

	}
	return btable;
}
 var ctable=undefined;	
 var loadedEditCallback = function(eModal,formId){
		//初始化日期	
		initDateAndTime();
	}	
function doEdit(cid){
		 tryEdit(cid,'#CartModal',cur_path+'/cart/findCartById.do',cur_path+'/cart/updCart.do','#cartForm',loadedEditCallback);
		 
	 }
	  function tryEdit (cid,modal,openUrl,saveUrl,formId,eCall){
			
			var $modal=$(modal);
			

			
			
			$modal.modal(
					{
						remote: openUrl+"?cid="+cid
						
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
														ctable.bootstrapTable('refresh');
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
$(function(){
	 //初始化日期控件
	 initDateAndTime();
	 

	 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/cart/findCartByCondition.do",
				tId:"Carttable",
				paramForm:"CartForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 100,
		        paginationVAlign:"",
		        setColPrimaryKeys:"cid",
		        singleSelect:false,
		        onCheck:domycount,
		        onUncheck:domycount,
		        onCheckAll:domycount,
		        onUncheckAll:domycount,
			    columns: [// cid, cnum, bnum, bname,b.img
							{
							    field: 'img',//域值
							    title: '封面',//标题
							    visible: true,//false表示不显示
							    valign:'middle',
					            formatter: function (value, row, index) {  
					                 return '<img src="'+cur_path+'/upload.s?method=down&fileid='+value+'" style="width:auto;height:55px" class="img-responsive">';  
					             }  
							} ,
			        {
			            field: 'cid',//域值
			            title: 'CID',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'bnum',//域值
			            title: '图书编码',//标题
			            visible: true,//false表示不显示
			            valign:'middle',
			        },{
			            field: 'bname',//域值
			            title: '图书名称',//标题
			            visible: true,//false表示不显示
			            valign:'middle',
			        },{
			            field: 'mprice',//域值
			            title: '市场价',//标题
			            visible: true,//false表示不显示
			            valign:'middle',
			        },{
			            field: 'vprice',//域值
			            title: '会员价',//标题
			            visible: true,//false表示不显示
			            valign:'middle',
			        },{
			            field: 'cnum',//域值
			            title: '购买数量',//标题
			            visible: true,//false表示不显示
			            valign:'middle',
			        },{
			            field: 'img',//域值
			            title: '操作',//标题
			            visible: true,//false表示不显示
			            formatter: function (value, row, index) {  
			                 return '<button type="button" onclick=doEdit("'+row.cid+'") class="btn btn-sm btn-danger">修改</button>';  
			             }  
			            	
			        }
			        
			    ]
				 
				
		};
	 
	 $("#mycheckSave").off("click").click(function(){
		  if($("#money").val()<=0){
				BootstrapDialog.show({
					title : '系统提示',
					type : BootstrapDialog.TYPE_DANGER,
					message : '请选择要结算的商品',
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
				return false;;
			  
		  }
		    $("#checkordersForm").bootstrapValidator({excluded:[":disabled"]}).off('success.form.bv').on('success.form.bv', function(e) {
	    		e.preventDefault();
				$.post(cur_path+"/orders/addOrders.do",$.extend($("#checkordersForm").serializeJSON(),{checkeds:$("#checkeds").val()}), function(data) {
		        		if(data.code==0){
							BootstrapDialog.show({
								title : '系统提示',
								type : BootstrapDialog.TYPE_SUCCESS,
								message : '提交订单成功',
					            closeByBackdrop: false,
					            closeByKeyboard: false,
								buttons : [ {
									label : '确定',
									//cssClass: 'btn-primary',
									action : function(dialogRef) {
										dialogRef.close();
										window.location.href=cur_path+"/OrdersList.jsp";
									}
								} ]
							  });
		        			
		        		}else{
							BootstrapDialog.show({
								title : '系统提示',
								type : BootstrapDialog.TYPE_DANGER,
								message : '提交订单失败',
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
	 function domycount(){
		 var _money =0;
		 var rows = bTable.bootstrapTable('getSelections');
		 var checkes=[];
		 if(rows&&rows.length>0){
			 
			 for(var i=0;i<rows.length;i++){
				 _money+=rows[i].vprice* rows[i].cnum;
				 checkes.push(rows[i].cid);
			 }
			
			
		 }
		 $("#money").val(_money.toFixed(2));
		 $("#checkeds").val(checkes.join(","));
	 }
	 
	 var bTable = new bootstrapOfTable(option);
	 ctable= bTable;
		//页面中有文件
	 var loadedAddCallback = function(eModal,formId){
			//初始化日期	
			initDateAndTime();
		}	
	 
	 
 

		$("#btn_edit").click(function(){
			$("#checkDiv").toggle();
		});

		 
		//页面中有文件
		var loadedViewCallback = function(eModal){
			eModal.find("button[type='submit']").hide();
			//初始化日期	
			initDateAndTime(eModal);
			eModal.find(".form_datetime,.form_date,.dateMonth,.mytree,select,.myUpfile").attr("disabled","disabled");
		}
 
		//删除
		$("#btn_delete").click(function(){
			
			if(bTable.bootstrapTable('getSelections').length==0){
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
		                if(result) {//checkeds
		                	var checkeds =[];
		                	for(var i=0;i<bTable.bootstrapTable('getSelections').length;i++){
		                		checkeds.push(bTable.bootstrapTable('getSelections')[i][bTable.bootstrapTable('getOptions').setColPrimaryKeys]);
		                	}
		                	
		    				$.post(cur_path+"/cart/delCart.do?checkeds="+checkeds.join(','), function(data) {
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
												bTable.bootstrapTable('refresh');
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
												bTable.bootstrapTable('refresh');
											}
										} ]
									  });
		    	        			
		    	        		}
		    	            },"json");
		                }
		            }
		        });

		});
		

		
		

 })
 var cTable = undefined;
function uporders(status,orid){		
		$.post(cur_path+"/orders/updOrders.do?status="+status+"&orid="+orid, function(data) {
    		if(data.code==0){
				BootstrapDialog.show({
					title : '系统提示',
					type : BootstrapDialog.TYPE_SUCCESS,
					message : '操作成功',
		            closeByBackdrop: false,
		            closeByKeyboard: false,
					buttons : [ {
						label : '确定',
						//cssClass: 'btn-primary',
						action : function(dialogRef) {
							dialogRef.close();
							cTable.bootstrapTable('refresh');
							 
						}
					} ]
				  });
    			
    		}else{
				BootstrapDialog.show({
					title : '系统提示',
					type : BootstrapDialog.TYPE_DANGER,
					message : '操作失败',
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

$(function(){
	 //初始化日期控件
	 initDateAndTime();
		var clickdoblest = function(field, value, row, $element){
			window.location.href=cur_path+"/orders/findOrdersByIdView.do?orid="+field.orid+"&status="+field.status
			return false;
		} 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/orders/findOrdersByCondition.do",
				tId:"Orderstable",
				paramForm:"OrdersForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 10,
		        setColPrimaryKeys:"orid",
		        onDblClickRow:  clickdoblest,
			    columns: [
			        {
			            field: 'orid',//域值
			            title: '订单编号',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'usersn',//域值
			            title: '用户ID',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'orname',//域值
			            title: '收货人',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'address',//域值
			            title: '收货地址',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'mobile',//域值
			            title: '手机',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'money',//域值
			            title: '总金额',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'statusname',//域值
			            title: '订单状态',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'createtime',//域值
			            title: '创建时间',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'createtime',//域值
			            title: '操作',//标题
			            visible: true,//false表示不显示
			            formatter: function (value, row, index) {  
			            	if(userType=='1'){
			            		if(row.status=='33'){
			            			 return '<button type="button" onclick=uporders("34","'+row.orid+'") class="btn btn-sm btn-danger">发货</button>';  
			            		} 
			            	}else{
			            		if(row.status=='32'){
			            			 return '<button type="button" onclick=uporders("33","'+row.orid+'") class="btn btn-sm btn-danger">付款</button>';  
			            		}else if(row.status=='34'){
			            			return '<button type="button" onclick=uporders("35","'+row.orid+'") class="btn btn-sm btn-danger">确认收货</button>';  
			            		}
			            	}
			                
			             }  
			        }
			        
			    ]
				 
				
		};
	 
	 var bTable = new bootstrapOfTable(option);
	 cTable= bTable;
		//页面中有文件
	 var loadedAddCallback = function(eModal,formId){
			//初始化日期	
			initDateAndTime();
		}	
	 var loadedEditCallback = function(eModal,formId){
			//初始化日期	
			initDateAndTime();
		}		 
	 
		//查询
		$("#btn_search").click(function(){
					bTable.btn_search();

		});
/*		//编辑
		$("#btn_edit").click(function(){
			bTable.btn_edit('#OrdersModal',cur_path+'/orders/findOrdersById.do',cur_path+'/orders/updOrders.do','#ordersForm',loadedEditCallback);

		});*/
		//页面中有文件
		var loadedViewCallback = function(eModal){
			eModal.find("button[type='submit']").hide();
			//初始化日期	
			initDateAndTime(eModal);
			eModal.find(".form_datetime,.form_date,.dateMonth,.mytree,select,.myUpfile").attr("disabled","disabled");
		}
		//查看
		$("#btn_view").click(function(){
			bTable.btn_view('#OrdersModal',cur_path+'/orders/findOrdersById.do',loadedViewCallback);

		});
/*		//删除
		$("#btn_delete").click(function(){
			bTable.btn_delete(cur_path+'/orders/delOrders.do');

		});*/
 })
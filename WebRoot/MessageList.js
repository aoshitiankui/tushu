 $(function(){
	 //初始化日期控件
	 initDateAndTime();
	 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/message/findMessageByCondition.do",
				tId:"Messagetable",
				paramForm:"MessageForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 10,
		        setColPrimaryKeys:"mid",
			    columns: [
			        {
			            field: 'mid',//域值
			            title: 'MID',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'name',//域值
			            title: '姓名',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'email',//域值
			            title: 'EMAIL',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'mobile',//域值
			            title: '手机',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'title',//域值
			            title: '主题',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'messages',//域值
			            title: '留言内容',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'mtime',//域值
			            title: '留言时间',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'isdealname',//域值
			            title: '是否已处理',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'mtypename',//域值
			            title: '留言类型',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'ipaddress',//域值
			            title: 'IP地址',//标题
			            visible: true,//false表示不显示
			        }
			        
			    ]
				 
				
		};
	 
	 var bTable = new bootstrapOfTable(option);
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
		//编辑
		$("#btn_edit").click(function(){
			bTable.btn_edit('#MessageModal',cur_path+'/message/findMessageById.do',cur_path+'/message/updMessage.do','#messageForm',loadedEditCallback);

		});
		//页面中有文件
		var loadedViewCallback = function(eModal){
			eModal.find("button[type='submit']").hide();
			//初始化日期	
			initDateAndTime(eModal);
			eModal.find(".form_datetime,.form_date,.dateMonth,.mytree,select,.myUpfile").attr("disabled","disabled");
		}
		//查看
		$("#btn_view").click(function(){
			bTable.btn_view('#MessageModal',cur_path+'/message/findMessageById.do',loadedViewCallback);

		});
		//删除
		$("#btn_delete").click(function(){
			bTable.btn_delete(cur_path+'/message/delMessage.do');

		});
 })
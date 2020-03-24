 $(function(){
	 //初始化日期控件
	 initDateAndTime();
	 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/codes/findCodesByCondition.do",
				tId:"Codestable",
				paramForm:"CodesForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 10,
		        setColPrimaryKeys:"id",
			    columns: [
			        {
			            field: 'id',//域值
			            title: '编码值',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'codename',//域值
			            title: '编码名称',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'codetypename',//域值
			            title: '类型名称',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'codetype',//域值
			            title: '编码类型',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'ordernum',//域值
			            title: '组内排序',//标题
			            visible: true,//false表示不显示
			        }
			        
			    ]
				 
				
		};
	 
	 var bTable = new bootstrapOfTable(option);
		//页面中有文件
	 var loadedCallback = function(eModal,formId){
			//初始化日期	
			initDateAndTime();
		}	 
	 
	 	//添加
		$("#btn_add").click(function(em){
			bTable.btn_add('#CodesModal',cur_path+'/Codes.jsp',cur_path+'/codes/addCodes.do','#codesForm',loadedCallback);
			


		});
		//查询
		$("#btn_search").click(function(){
					bTable.btn_search();

		});
		//编辑
		$("#btn_edit").click(function(){
			bTable.btn_edit('#CodesModal',cur_path+'/codes/findCodesById.do',cur_path+'/codes/updCodes.do','#codesForm',loadedCallback);

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
			bTable.btn_view('#CodesModal',cur_path+'/codes/findCodesById.do',loadedViewCallback);

		});
		//删除
		$("#btn_delete").click(function(){
			bTable.btn_delete(cur_path+'/codes/delCodes.do');

		});
 })
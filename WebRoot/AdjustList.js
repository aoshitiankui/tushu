 $(function(){
	 //初始化日期控件
	 initDateAndTime();
	 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/adjust/findAdjustByCondition.do",
				tId:"Adjusttable",
				paramForm:"AdjustForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 10,
		        setColPrimaryKeys:"adid",
			    columns: [
			        {
			            field: 'adid',//域值
			            title: 'ADID',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'bid',//域值
			            title: '图书ID',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'examinedname',//域值
			            title: '审核状态',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'adjust',//域值
			            title: '评论内容',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'username',//域值
			            title: '用户姓名',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'adtime',//域值
			            title: '添加时间',//标题
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
			bTable.btn_edit('#AdjustModal',cur_path+'/adjust/findAdjustById.do',cur_path+'/adjust/updAdjust.do','#adjustForm',loadedEditCallback);

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
			bTable.btn_view('#AdjustModal',cur_path+'/adjust/findAdjustById.do',loadedViewCallback);

		});
		//删除
		$("#btn_delete").click(function(){
			bTable.btn_delete(cur_path+'/adjust/delAdjust.do');

		});
 })
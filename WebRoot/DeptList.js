 $(function(){
	 //初始化日期控件
	 initDateAndTime();
	 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/dept/findDeptByCondition.do",
				tId:"Depttable",
				paramForm:"DeptForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 10,
		        setColPrimaryKeys:"id",
			    columns: [
			        {
			            field: 'id',//域值
			            title: 'ID',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'deptname',//域值
			            title: '部门名称',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'deptup',//域值
			            title: '父级部门',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'tel',//域值
			            title: '电话',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'fax',//域值
			            title: '传真',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'conperson',//域值
			            title: '联系人',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'conpersonphone',//域值
			            title: '联系人电话',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'conaddress',//域值
			            title: '联系人地址',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'address',//域值
			            title: '部门地址',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'des',//域值
			            title: '部门描述',//标题
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
			bTable.btn_add('#DeptModal',cur_path+'/Dept.jsp',cur_path+'/dept/addDept.do','#deptForm',loadedCallback);
			


		});
		//查询
		$("#btn_search").click(function(){
					bTable.btn_search();

		});
		//编辑
		$("#btn_edit").click(function(){
			bTable.btn_edit('#DeptModal',cur_path+'/dept/findDeptById.do',cur_path+'/dept/updDept.do','#deptForm',loadedCallback);

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
			bTable.btn_view('#DeptModal',cur_path+'/dept/findDeptById.do',loadedViewCallback);

		});
		//删除
		$("#btn_delete").click(function(){
			bTable.btn_delete(cur_path+'/dept/delDept.do');

		});
 })
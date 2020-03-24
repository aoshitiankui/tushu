 $(function(){
	 //初始化日期控件
	 initDateAndTime();
	 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/user/findUserByCondition.do",
				tId:"Usertable",
				paramForm:"UserForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 10,
		        setColPrimaryKeys:"usersn",
			    columns: [
			        {
			            field: 'usersn',//域值
			            title: 'USERSN',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'userid',//域值
			            title: '用户名',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'username',//域值
			            title: '姓名',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'usertypename',//域值
			            title: '用户类型',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'mobile',//域值
			            title: '手机',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'img',//域值
			            title: '头像',//标题
			            visible: true,//false表示不显示
			            formatter: function (value, row, index) {  
			                 return '<img src="'+cur_path+'/upload.s?method=down&fileid='+value+'" style="width:auto;height:35px" class="img-circle img-responsive">';  
			             }  
			            	
			        }/*,{
			            field: 'img',//域值
			            title: '操作',//标题
			            visible: true,//false表示不显示
			            formatter: function (value, row, index) {  
			                 return '<button type="button" class="btn btn-sm btn-danger">禁用</button>';  
			             }  
			            	
			        }*/
			        
			    ]
				 
				
		};
	 
	 var bTable = new bootstrapOfTable(option);
		//页面中有文件
	 var loadedAddCallback = function(eModal,formId){
			//初始化日期	
			initDateAndTime();
			var bootstrapFileinputInit1 = new bootstrapFileinputInit({
				eId:'img',
				eIdName:'imgName',
				cName:"文件"
			});
			//配置监听
			bootstrapFileinputInit1.on("fileuploaded", function(event, data) { 
		         $("#img").val(data.response.rows[0].id).change();
			}).on("filecleared",function(){
				$("#img").val("").change();
			});
			$("#password2").change(function(){
				$("#password").val(md5($("#password2").val())).change();
			});
		}
	 
		//页面中有文件
	 var loadedEditCallback = function(eModal,formId){
		    $("#deptName").val(bTable.bootstrapTable('getSelections')[0].dept);
			//初始化日期	
			initDateAndTime();
			var bootstrapFileinputInit1 = new bootstrapFileinputInit({
				eId:'img',
				eIdName:'imgName',
				cName:"文件"
			});
			//配置监听
			bootstrapFileinputInit1.on("fileuploaded", function(event, data) { 
		         $("#img").val(data.response.rows[0].id).change();
			}).on("filecleared",function(){
				$("#img").val("").change();
			});
			
			$("#password2").change(function(){
				$("#password").val(md5($("#password2").val())).change();
			});
		}
	 
	 	//添加
		$("#btn_add").click(function(em){
			bTable.btn_add('#UserModal',cur_path+'/User.jsp',cur_path+'/user/addUser.do','#userForm',loadedAddCallback);
			


		});
		//查询
		$("#btn_search").click(function(){
					bTable.btn_search();

		});
		//编辑
		$("#btn_edit").click(function(){
			bTable.btn_edit('#UserModal',cur_path+'/user/findUserById.do',cur_path+'/user/updUser.do','#userForm',loadedEditCallback);

		});
		//页面中有文件
		var loadedViewCallback = function(eModal){
			$("#deptName").val(bTable.bootstrapTable('getSelections')[0].dept);
			eModal.find("button[type='submit']").hide();
			//初始化日期	
			initDateAndTime(eModal);
			var bootstrapFileinputInit1 = new bootstrapFileinputInit({
				eId:'img',
				eIdName:'imgName',
				showUpload: false,
				showRemove:false,
		        showCancel: false,
		        showClose: false,
		        cName:"文件"
			});
			eModal.find(".form_datetime,.form_date,.dateMonth,.mytree,select,.myUpfile").attr("disabled","disabled");
		}
		//查看
		$("#btn_view").click(function(){
			bTable.btn_view('#UserModal',cur_path+'/user/findUserById.do',loadedViewCallback);

		});
		//删除
		$("#btn_delete").click(function(){
			bTable.btn_delete(cur_path+'/user/delUser.do');

		});
 })
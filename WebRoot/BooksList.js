 $(function(){
	 //初始化日期控件
	 initDateAndTime();
	 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/books/findBooksByCondition.do",
				tId:"Bookstable",
				paramForm:"BooksForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 10,
		        setColPrimaryKeys:"bid",
			    columns: [
			        {
			            field: 'bid',//域值
			            title: 'BID',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'bnum',//域值
			            title: '图书编号',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'bname',//域值
			            title: '图书名称',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'btypename',//域值
			            title: '图书类型',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'bpublish',//域值
			            title: '出版社',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'publishdate',//域值
			            title: '出版日期',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'pkben',//域值
			            title: '开本',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'pfengzname',//域值
			            title: '封装方式',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'bbanci',//域值
			            title: '版次',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'writer',//域值
			            title: '作者',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'traner',//域值
			            title: '译者',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'isbn',//域值
			            title: 'ISBN',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'mprice',//域值
			            title: '市场价',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'vprice',//域值
			            title: '会员价',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'salepoint',//域值
			            title: '折扣',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'sales',//域值
			            title: '销量',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'viewcount',//域值
			            title: '浏览次数',//标题
			            visible: false,//false表示不显示
			        },{
			            field: 'img',//域值
			            title: '封面',//标题
			            visible: true,//false表示不显示
			            formatter: function (value, row, index) {  
			                 return '<img src="'+cur_path+'/upload.s?method=down&fileid='+value+'" style="width:auto;height:45px" class="img-rounded img-responsive">';  
			             } 
			        },{
			            field: 'stores',//域值
			            title: '库存',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'instoresdate',//域值
			            title: '入库时间',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'issalename',//域值
			            title: '是否上架',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'ratingnum',//域值
			            title: '推荐指数',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'isnewname',//域值
			            title: '是否新品',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'bdesc',//域值
			            title: '图书介绍',//标题
			            visible: false,//false表示不显示
			        }
			        
			    ]
				 
				
		};
	 
	 var bTable = new bootstrapOfTable(option);
		//页面中有文件
	 var loadedAddCallback = function(eModal,formId){
		 $("#instoresdatediv").hide();
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
		}	
	 var loadedEditCallback = function(eModal,formId){
		   
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
		}		 
	 
	 	//添加
		$("#btn_add").click(function(em){
			bTable.btn_add('#BooksModal',cur_path+'/Books.jsp',cur_path+'/books/addBooks.do','#booksForm',loadedAddCallback);
			


		});
		//查询
		$("#btn_search").click(function(){
					bTable.btn_search();

		});
		//编辑
		$("#btn_edit").click(function(){
			bTable.btn_edit('#BooksModal',cur_path+'/books/findBooksById.do',cur_path+'/books/updBooks.do','#booksForm',loadedEditCallback);

		});
		//页面中有文件
		var loadedViewCallback = function(eModal){
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
			bTable.btn_view('#BooksModal',cur_path+'/books/findBooksById.do',loadedViewCallback);

		});
		//删除
		$("#btn_delete").click(function(){
			bTable.btn_delete(cur_path+'/books/delBooks.do');

		});
 })
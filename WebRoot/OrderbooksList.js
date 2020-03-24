	var cTable= undefined;
function domyadjust(obid,bid,obj){
			$.post(cur_path+"/adjust/addAdjust.do",{obid:obid,bid:bid,examined:"37",adjust:$(obj).siblings('textarea').val(),title:$(obj).siblings('input').val()}, function(data) {
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

	 
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/orderbooks/findOrderbooksByCondition.do",
				tId:"Orderbookstable",
				paramForm:"OrderbooksForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 1000,
		        paginationVAlign:"",
		        setColPrimaryKeys:"obid",
		        checkbox:false,
			    columns: [
					{
					    field: 'img',//域值
					    title: '封面',//标题
					    visible: true,//false表示不显示
					    valign:'middle',
			            formatter: function (value, row, index) {  
			                 return '<img src="'+cur_path+'/upload.s?method=down&fileid='+value+'" style="width:auto;height:55px" class="img-responsive">';  
			             }  
					}  ,{
			            field: 'bnum',//域值
			            title: '图书编号',//标题
			            visible: true,//false表示不显示
					    valign:'middle'
			        },{
			            field: 'bname',//域值
			            title: '图书名称',//标题
			            visible: true,//false表示不显示
			            valign:'middle'
			        },{
			            field: 'mprice',//域值
			            title: '市场价',//标题
			            visible: true,//false表示不显示
			            valign:'middle'
			        },{
			            field: 'vprice',//域值
			            title: '会员价',//标题
			            visible: true,//false表示不显示
			            valign:'middle'
			        },{
			            field: 'salepoint',//域值
			            title: '折扣',//标题
			            visible: true,//false表示不显示
			            valign:'middle'
			        },{
			            field: 'stores',//域值
			            title: '购买数量',//标题
			            visible: true,//false表示不显示
			            valign:'middle'
			        },{
			            field: 'isadjust',//域值
			            title: '评论信息',//标题
			            visible: true,//false表示不显示
			            formatter: function (value, row, index) {  
			            	if(value=='39'&&cur_status=='35'&&userType=='2'&&row.isadjust=='39'){
			            		return [ '标题:<input type="text" class="form-control" id="title" name="title"  value="">',
			            		        ' 内容：<textarea id="adjust" name="adjust" class="form-control " rows="3" onkeydown="textAreaLengthLmit(50)" placeholder="请输入描述，长度不大于50"></textarea>',
			            		        '<button type="button" onclick=domyadjust("'+row.obid+'","'+row.bid+'",this) class="btn btn-primary" id="bsSave">保存</button>'].join("");
			            	}else{
			            		return ['标题:'+(row.title||''),'<br>','内容:',(row.adjust||'')].join("");
			            	}
			                
			             } 
			        }
			        
			    ]
				 
				
		};
	 
	 var bTable = new bootstrapOfTable(option);
	 cTable=bTable;
		//页面中有文件
	 var loadedAddCallback = function(eModal,formId){
			//初始化日期	
			initDateAndTime();
		}	
	 var loadedEditCallback = function(eModal,formId){
			//初始化日期	
			initDateAndTime();
		}		 
	 
	 	//添加
		$("#btn_add").click(function(em){
			bTable.btn_add('#OrderbooksModal',cur_path+'/Orderbooks.jsp',cur_path+'/orderbooks/addOrderbooks.do','#orderbooksForm',loadedAddCallback);
			


		});
		//查询
		$("#btn_search").click(function(){
					bTable.btn_search();

		});
		//编辑
		$("#btn_edit").click(function(){
			bTable.btn_edit('#OrderbooksModal',cur_path+'/orderbooks/findOrderbooksById.do',cur_path+'/orderbooks/updOrderbooks.do','#orderbooksForm',loadedEditCallback);

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
			bTable.btn_view('#OrderbooksModal',cur_path+'/orderbooks/findOrderbooksById.do',loadedViewCallback);

		});
		//删除
		$("#btn_delete").click(function(){
			bTable.btn_delete(cur_path+'/orderbooks/delOrderbooks.do');

		});
 })
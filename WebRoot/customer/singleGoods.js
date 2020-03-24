

$(function(){
	  if(!!cur_user){
		  updateMiniCart();
	  }

	$("#domyadd").click(function(){
		var obj={bid:$("#bid").val(),buynum:$("#qty").val()}
		addTocart(obj,1);
	})
	 //初始化日期控件
	 $("select").each(function(){
		 $(this).find("option[value!='"+$(this).val()+"']").remove().attr("readonly","readonly");
	 })
	 $("#usertype option[value!='"+$('#usertype').val()+"']").remove().attr("readonly","readonly");
	 var option ={
			 toolbar:"#toolbar",
				url:cur_path+"/adjust/findAdjustByCondition.do?examined=36",
				tId:"adjustTable",
				paramForm:"adjustTableForm",
			    pageNumber : 1,
			    pageList: [5, 10,15],//分页步进值
		        pageSize: 10,
		        setColPrimaryKeys:"adid",
		        classes: 'table-no-bordered',
		        tableOrders:false,
		        checkbox:false,
		        formatNoMatches:function(){
		        	return "暂无评论信息";
		        },
			    columns: [
			     /*   {
			            field: 'adid',//域值
			            title: 'ADID',//标题
			            visible: true,//false表示不显示
			        },{
			            field: 'bid',//域值
			            title: '图书ID',//标题
			            visible: true,//false表示不显示
			        } ,{
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
			        },*/{
			            field: 'adtime',//域值
			            title: '',//标题
			            visible: true,//false表示不显示
			            formatter: function (value, row, index) {  
			            	return [' <div class="review"><h6><a href="#">'+row.title+'</a></h6>',
			            	        ' <span>'+row.username+'</span><small>回复于'+row.adtime+' </small>',
			            	        '<div class="review-txt"> '+row.adjust+' </div></div>'
			            	        ].join('');
			                  
			             } 
			        }
			    ]
				 
				
		};
	 
	 var bTable = new bootstrapOfTable(option);
 
 })
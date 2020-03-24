 $(function(){
	  if(!!cur_user){
		  updateMiniCart();
	  }
	 var option ={
				url:cur_path+"/books/findBooksByCondition.do?hotPoint=hotPoint",
				tId:"hotartsiss",
				 paginationVAlign:"",
			    pageNumber : 1,
			    pageList: [15, 20,30],//分页步进值
		        pageSize: 4,
		        setColPrimaryKeys:"bid",
		        lisImg:{
		        	imgKey:'img',
		        	url:cur_path+'/books/findBooksById.do?bookView=bookView',
		            left:"hotpoint"		
		        },
		        lisTitle:{
		        	nameKey:"bname",
		        	url:cur_path+'/books/findBooksById.do?bookView=bookView',
		        },
		        lisClass:"item col-lg-3 col-md-3 col-sm-3 col-xs-12",
		        lisContent:[{addClass:'old-price',values:[{
		        	name:"市场价:",
		        	nameKey:"mprice",
		            addClass:"old-price",
		            prefix:'￥'
		        }]},{addClass:'',values:[{
		        	name:"会员价:",
		        	nameKey:"vprice",
		            addClass:"",
		            prefix:'￥'
		        },{
		        	name:"销量:",
		        	nameKey:"sales",
		            addClass:"",		
		        }
		        ]}],
		        lisAction:[{
		        	name:"购买",
		        	addClass:"",
		        	hander:addTocart
		        }],
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
	 
	 var option2 ={
				url:cur_path+"/books/findBooksByCondition.do?guess=guess",
				tId:"newsartsiss",
				 paginationVAlign:"",
			    pageNumber : 1,
			    pageList: [15, 20,30],//分页步进值
		        pageSize: 4,
		        setColPrimaryKeys:"bid",
		        lisImg:{
		        	imgKey:'img',
		        	url:cur_path+'/books/findBooksById.do?bookView=bookView',
		            left:"newpoint"		
		        },
		        lisTitle:{
		        	nameKey:"bname",
		        	url:cur_path+'/books/findBooksById.do?bookView=bookView',
		        },
		        lisClass:"item col-lg-3 col-md-3 col-sm-3 col-xs-12",
		        lisContent:[{addClass:'old-price',values:[{
		        	name:"市场价:",
		        	nameKey:"mprice",
		            addClass:"old-price",
		            prefix:'￥'
		        }]},{addClass:'',values:[{
		        	name:"会员价:",
		        	nameKey:"vprice",
		            addClass:"",
		            prefix:'￥'
		        },{
		        	name:"销量:",
		        	nameKey:"sales",
		            addClass:"",		
		        }
		        ]}],
		        lisAction:[{
		        	name:"购买",
		        	addClass:"",
		        	hander:addTocart
		        }],
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
	 
	 var option3 ={
				url:cur_path+"/books/findBooksByCondition.do?sysPoint=sysPoint",
				tId:"pointsartsiss",
				 paginationVAlign:"",
			    pageNumber : 1,
			    pageList: [15, 20,30],//分页步进值
		        pageSize: 4,
		        setColPrimaryKeys:"bid",
		        lisImg:{
		        	imgKey:'img',
		        	url:cur_path+'/books/findBooksById.do?bookView=bookView',
		            left:"syspoint"		
		        },
		        lisTitle:{
		        	nameKey:"bname",
		        	url:cur_path+'/books/findBooksById.do?bookView=bookView',
		        },
		        lisClass:"item col-lg-3 col-md-3 col-sm-3 col-xs-12",
		        lisContent:[{addClass:'old-price',values:[{
		        	name:"市场价:",
		        	nameKey:"mprice",
		            addClass:"old-price",
		            prefix:'￥'
		        }]},{addClass:'',values:[{
		        	name:"会员价:",
		        	nameKey:"vprice",
		            addClass:"",
		            prefix:'￥'
		        },{
		        	name:"推荐指数:",
		        	nameKey:"ratingnum",
		            addClass:"",		
		        }
		        ]}],
		        lisAction:[{
		        	name:"购买",
		        	addClass:"",
		        	hander:addTocart
		        }],
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
	 
	 
	 var bootDiv2 = new bootstrapOfDiv(option2);
	 var bootDiv = new bootstrapOfDiv(option);
	 var bootDiv3 = new bootstrapOfDiv(option3);

 })
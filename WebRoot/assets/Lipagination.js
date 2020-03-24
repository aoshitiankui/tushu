function bootstrapOfDiv(option){
	var settings={
			url:undefined,
			tId:undefined,
		    paramForm:undefined,			
/*		    queryParams: function (params) {
		        return {
		            pageSize : 15, //排序
		            pageNo : 1 //页码
		        };
		    },*/
		    setColPrimaryKeys:"",//当前行的主键列
		    method: 'post',
		    striped:true,
		    sortable: false,
		    queryParams:undefined,
		    showHeader : true,
		    showColumns : false,
		    showRefresh : false,
		    clickToSelect:true,
		    singleSelect:true,
		    checkbox: true,//显示CHECKBOX选项
		    tableOrders:true,//显示排序序号
		    pagination: true,//分页
		    paginationLoop:false,
		    sidePagination : 'server',//服务器端分页
		    queryParamsType:'',//不启用restful风格
		    pageNumber : 1,
		    contentType:'application/x-www-form-urlencoded; charset=UTF-8',	
		    pageList: [15, 20, 50],//分页步进值
		    classes: 'table',
		    onDblClickRow:undefined,
		    downUrlPath:cur_path+'/upload.s?method=down&fileid='
			 
			
	}
	
	this.settings= $.extend({}, settings, option);
	this.settings.queryParams = function(params){
		params = {pageNumber:this.pageNumber,pageSize:this.pageSize};
		var pJson = $("#"+this.paramForm).serializeJSON();
		for(var key in pJson){  
            try{  
             if(!pJson[key]){
            	 delete pJson[key];  
             }		
            }catch(e){}  
        }  
		if(this.paramForm){
			params = $.extend({}, params, pJson);
		}
		return params;
	}
	var btable = $("#"+this.settings.tId).bootstrapDiv(this.settings);	
	return btable;
}
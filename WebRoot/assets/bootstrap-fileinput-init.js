function bootstrapFileinputInit(options){
	
	var settings={
				eId:'',
				eIdName:'',
	            language: 'zh', //设置语言  
	            uploadUrl: cur_path+"/upload.s?method=up",  //上传地址  
	            showUpload: true, //是否显示上传按钮  
	            showRemove:true,  
	             dropZoneEnabled: false,  
	            showCaption: true,//是否显示标题  
	            allowedPreviewTypes: ['image'],  
	            allowedFileTypes: ['image'],  
	            allowedFileExtensions:  ['jpg', 'png'],  
	            maxFileSize : 2000,  
	            maxFileCount: 1,  
	            enctype: 'multipart/form-data',
	            autoReplace:true,
	            cName:"文件",//默认文件名字
                layoutTemplates: {
                    actions: '',
                    actionDelete: '',
                    actionUpload: '',
                    actionDownload: '',
                    	indicator:''
                },
	            initialPreview: [],
	            initialPreviewConfig: [],
	            initialPreviewFileType:'image',
	            initialCaption:"",
	            downUrlPath:cur_path+'/upload.s?method=down&fileid='
	              
	        }
	
	this.settings= $.extend({}, settings, options);
	
	if($('#'+this.settings.eId).val()){
		this.settings.initialPreview=[
		                              "<img src='"+this.settings.downUrlPath+$('#'+this.settings.eId).val()+"' class='file-preview-image kv-preview-data rotate-31035 is-landscape-gt4' style='width:auto;height:auto;max-width:100%;max-height:100%;' alt='"+$('#'+this.settings.eIdName).attr('title')+"' title='"+$('#'+this.settings.eIdName).attr('title')+"'>",  
		                              ];
		this.settings.initialPreviewConfig=[{
        	caption:($('#'+this.settings.eIdName).attr('title')||this.settings.cName)
        	}]
		
		this.settings.initialCaption=($('#'+this.settings.eIdName).attr('title')||this.settings.cName);
	}
	
	return $("#"+this.settings.eIdName).fileinput(this.settings);
	
}
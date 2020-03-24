/*$(function(){
    $(document).on('show.bs.modal', '.modal .fade', function() {
        var zIndex = 1040 + (10 * $('.modal:visible').length);
        $(this).css('z-index', zIndex);
        setTimeout(function() {
            $('.modal-backdrop').not('.modal-stack').css('z-index', zIndex - 1).addClass('modal-stack');
        }, 0);
    });
})
*/
function textAreaLengthLmit(len){
		var evt = window.event || arguments.callee.caller.arguments[0]; // 获取event对象
		var src = evt.srcElement || evt.target; // 获取触发事件的源对象
		var iKeyCode = evt.keyCode || evt.which; //获取按钮代码
		if(iKeyCode!='8'&&iKeyCode!='46'){//去掉BACKSPACE 和DELETE
			if (src.value.length>=len){ 
				if (window.navigator.userAgent.indexOf("IE")>=1){
					evt.returnValue=false; 
				}else {
					evt.preventDefault()
				}
			}
		}

	}
	
function opentree(modal,sqlid,treetype,id,name){		
		var $modal=$("#"+modal);
		$modal.modal(
				{
					remote: cur_path+'/CommonTree.jsp?&sqlid='+sqlid+'&isCheckBox='+treetype+'&isAutoClose=1&getTreeValueStyle=2&displayText='+name+'&displayVlaue='+id
					
				}).off('loaded.bs.modal').on('loaded.bs.modal',function(e){

					$modal.find('button[id="treeQuery"]').click(function(e2){
					 $modal.modal('hide');
							 
					})
					
				}).off('hidden.bs.modal').on("hidden.bs.modal", function(e) {
					 $(this).removeData("bs.modal");
				});
	}


function initDateAndTime(eModal){
	if(eModal){
		eModal.find(".form_datetime").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true,
	        language:'zh-CN',
	        pickerPosition:"bottom-left"
	      });
		eModal.find(".form_date").datetimepicker({
	    	startView: 2, 
	    	minView: 2,
	        format: "yyyy-mm-dd",
	        autoclose: true,
	        todayBtn: true,
	        language:'zh-CN',
	        pickerPosition:"bottom-left"
	      });    
		eModal.find(".dateMonth").datetimepicker({
	    	startView: 3, 
	    	minView: 3,
	        format: "yyyy-mm",
	        autoclose: true,
	        todayBtn: true,
	        language:'zh-CN',
	        pickerPosition:"bottom-left"
	      });
	}else{
	    $(".form_datetime").datetimepicker({
	        format: "yyyy-mm-dd hh:ii",
	        autoclose: true,
	        todayBtn: true,
	        language:'zh-CN',
	        pickerPosition:"bottom-left"
	      });
	    $(".form_date").datetimepicker({
	    	startView: 2, 
	    	minView: 2,
	        format: "yyyy-mm-dd",
	        autoclose: true,
	        todayBtn: true,
	        language:'zh-CN',
	        pickerPosition:"bottom-left"
	      });    
	    $(".dateMonth").datetimepicker({
	    	startView: 3, 
	    	minView: 3,
	        format: "yyyy-mm",
	        autoclose: true,
	        todayBtn: true,
	        language:'zh-CN',
	        pickerPosition:"bottom-left"
	      });
		
	}

}
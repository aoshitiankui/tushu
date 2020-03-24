function openupfile(id,name){
	window.open(cur_path+'/upload.jsp?id='+id+'&name='+name,'upload','height=400,width=500,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
}
function opentree(sqlid,treetype,id,name,p){
	window.open(cur_path+'/CommonTree.jsp?sqlid='+sqlid+'&p='+p+'&isCheckBox='+treetype+'&isAutoClose=1&getTreeValueStyle=2&displayText='+name+'&displayVlaue='+id,'tree','height=420,width=300,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
}
function changeselect(selfid,changeid,sqlid){
	if($("#"+selfid).val()==""){
		$("#"+changeid).html("");
		return ;
	}
	var url=cur_path+'/changeselect.do?sqlid='+sqlid;
	url+='&param0='+$("#"+selfid).val();
	$.get(url,function (data){
		var objs = eval("("+data+")");
		$("#"+changeid).html("");
		$.each(objs,function (i,obj){
			$("#"+changeid),append("<option value='"+obj[0]+"'>"+obj[1]+"</option>");
		});
	});
}
function getsqldata(sqlid,params,callback){
	var url=cur_path+'/changeselect.do?sqlid='+sqlid;
	if(params!=null&&params!=''){
		if (typeof params =="string"){
			url+='&param0='+params;
		}else{
			for(i=0;i<params.length;i++){
				url+='&param'+i+'='+params[0];
			}
		}
	}
	$.get(url,function (data){
		callback(data);
	});
}
function isemail(str){
		var result=str.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/);
		if(result==null) return false;
		return true;
}
function isint(str)
{
var result=str.match(/^(-|\+)?\d+$/);
if(result==null) return false;
return true;
}
function isalphanumber(str)
{
var result=str.match(/^[a-zA-Z0-9]+$/);
if(result==null) return false;
return true;
}
function istel(str)
{

var result=str.match(/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/);
if(result==null) result=str.match(/^1[358]\d{9}$/);
if(result==null) return false;
return true;
}
function isnotnull(str)
{
if(str==null||str=="") return false;
return true;
}
var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];//
var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];//
function iscard(idCard){
	if (idCard.length == 15) {
        return isValidityBrithBy15IdCard(idCard);
    } else if (idCard.length == 18) {
        var a_idCard = idCard.split("");//
        if(isValidityBrithBy18IdCard(idCard)&&isTrueValidateCodeBy18IdCard(a_idCard)){
            return true;
        }else {
            return false;
        }
    } else {
        return false;
    }
}

/**
* @return
*/

function isTrueValidateCodeBy18IdCard(a_idCard) {
    var sum = 0; //
    if (a_idCard[17].toLowerCase() == 'x') {
        a_idCard[17] = 10;//
    }
    for ( var n = 0; n < 17; n++) {
        sum += Wi[n] * a_idCard[n];//
    }
    valCodePosition = sum % 11;//
    if (a_idCard[17] == ValideCode[valCodePosition]) {
        return true;
    } else {
        return false;

    }

}
/**
  * @return
  */
function isValidityBrithBy18IdCard(idCard18){
    var year =  idCard18.substring(6,10);
    var month = idCard18.substring(10,12);
    var day = idCard18.substring(12,14);
    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));
    if(temp_date.getFullYear()!=parseFloat(year)
          ||temp_date.getMonth()!=parseFloat(month)-1
          ||temp_date.getDate()!=parseFloat(day)){
              return false;
    }else{
        return true;
    }

}

 /**
   * @return
   */

  function isValidityBrithBy15IdCard(idCard15){
      var year =  idCard15.substring(6,8);
      var month = idCard15.substring(8,10);
      var day = idCard15.substring(10,12);
      var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));
      if(temp_date.getYear()!=parseFloat(year)
              ||temp_date.getMonth()!=parseFloat(month)-1
              ||temp_date.getDate()!=parseFloat(day)){
                  return false;
        }else{
            return true;
        }
  }
/**

*/
function maleOrFemalByIdCard(idCard){
    if(idCard.length==15){
        if(idCard.substring(14,15)%2==0){
            return 'female';
        }else{
            return 'male';
        }
    }else if(idCard.length ==18){
        if(idCard.substring(14,17)%2==0){
            return 'female';
        }else{
            return 'male';
        }
    }else{
        return null;
    }
}
function showdatemore(str){
	WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd HH:mm:ss'})
}
function showdate(str){
	WdatePicker({isShowClear:false,dateFmt:'yyyy-MM-dd'})
}
function ValidateF(e, pnumber) 
{ 
if (!/^\d+[.]?\d*$/.test(pnumber)) 
{ 
e.value = /^\d+[.]?\d*/.exec(e.value); 
} 
return false; 
}
function ValidateI(e, pnumber){ 
if (!/^\d+$/.test(pnumber)){ 
e.value = /^\d+/.exec(e.value);} 
return false; 
}
function openDiaLog(url,sign,formid)  
{  
    $('#dia').dialog({  
        title: tableName+sign,  
        href: cur_path+url,  
        modal: true,  
        buttons:[{ //Ϊ������Ӱ�ť  
            text:'����',  
            handler:function(){  
                if(check()){
                	$.post($("#"+formid).attr("action"), $("#"+formid).serialize(), function(data) {
                		alert(data.msg);
                		if(data.code==0){
                			$("#dia").dialog('close');
                			loadData(_dgid,_formid);
                		}
                    },"json");
                } 
            }  
        },{  
            text:'�ر�',  
            handler:function(){$("#dia").dialog('close');}  
        }]  
        });  
    $('#dia').dialog("open");
}
var _dgid;
var _formid;
var _dg;
var _btns;
function loadData(dgid,formid){
	_dgid = dgid;
	_formid = formid;
	if(!_btns){
		_btns=[{ 
	        text: '��ѯ', 
	        iconCls: 'icon-search', 
	        handler: function() { 
	        	loadData(_dgid,_formid); 
	        } 
	    },{ 
	        text: '���', 
	        iconCls: 'icon-add', 
	        handler: function() { 
	        	addDia(); 
	        } 
	    }];
	}
	if(!_dg){
		_dg = $('#'+dgid).datagrid({ 
		    title:tableName+"�б�", 
		    iconCls:'icon-edit',//ͼ�� 
		    width: 700, 
		    height: 'auto', 
		    nowrap: false, 
		    striped: true, 
		    border: true, 
		    collapsible:false,//�Ƿ���۵��� 
		    fit: true,//�Զ���С 
		    url:'', 
		    //sortName: 'code', 
		    //sortOrder: 'desc', 
		    remoteSort:false,  
		    idField:'', 
		    singleSelect:false,//�Ƿ�ѡ 
		    pagination:true,//��ҳ�ؼ� 
		    rownumbers:true,//�к� 
		    frozenColumns:[[ 
		        {field:'ck',checkbox:false} 
		    ]], 
		    toolbar: _btns, 
		}); 
		//���÷�ҳ�ؼ� 
		var p = $('#'+dgid).datagrid('getPager'); 
		$(p).pagination({ 
		    pageSize: 10,//ÿҳ��ʾ�ļ�¼������Ĭ��Ϊ10 
		    pageList: [10,20,50],//��������ÿҳ��¼�������б� 
		    beforePageText: '��',//ҳ���ı���ǰ��ʾ�ĺ��� 
		    afterPageText: 'ҳ    �� {pages} ҳ', 
		    total:0,
		    displayMsg: '��ǰ��ʾ {from} - {to} ����¼   �� {total} ����¼',
		    onSelectPage:function(pageNumber, pageSize){
		    	query(pageNumber,pageSize);
		    }
		    });
	}
	
	var query = function(pageNumber, pageSize){
		$.post($("#"+formid).attr("action")+"&pageNumber="+pageNumber+"&pageSize="+pageSize, $("#"+formid).serialize(), function(data) {
			if(data.rows==undefined){
				data.rows=[];
			}
			$('#'+dgid).datagrid("loadData",data);
        },"json");
	}
	query(1,10);
}
function editopt(id,url,formid){
	return "<a href=\"javascript:openDiaLog('"+url+id+"','�޸�','"+formid+"')\">�༭</>";
}
function delopt(id,url){
	return "<a href=\"javascript:del('"+url+id+"')\">ɾ��</>";
}
function del(url){
	if(confirm("ȷ��ɾ����")){
		$.post(cur_path+url,  function(data) {
			if(data.code=='0'){
				alert('ɾ���ɹ���');
				loadData(_dgid,_formid);
			}
        },"json");
	}
}

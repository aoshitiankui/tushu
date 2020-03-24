var zTree ,rMenu,myTreeId;
function OnRightClick(event, treeId, treeNode) {
	zTree.cancelSelectedNode();
	if (!treeNode && event.target.tagName.toLowerCase() != "button" && $(event.target).parents("a").length == 0) {
		showRMenu("root", event.clientX, event.clientY);
		if(document.getElementById(myTreeId)){$("#"+myTreeId).val("");}
	} else if (treeNode && !treeNode.noR) {
		//if(treeNode.level!=0){
			zTree.selectNode(treeNode);
			showRMenu("node", event.clientX, event.clientY);
			setVals(treeNode);
		//}
	}
}

function showRMenu(type, x, y) {
	$("#rMenu ul").show();
	if (type=="root") {
		$("#rMenu ul").hide();
	} else {
		$("#rMenu ul").show();
	}
	rMenu.css({"top":y+"px", "left":x+"px", "visibility":"visible"});

	$("body").bind("mousedown", onBodyMouseDown);
}

function hideRMenu() {
	if (rMenu) rMenu.css({"visibility": "hidden"});
	$("body").unbind("mousedown", onBodyMouseDown);
}
function onBodyMouseDown(event){
	if (!(event.target.id == "rMenu" || $(event.target).parents("#rMenu").length>0)) {
		rMenu.css({"visibility" : "hidden"});
	}
}

function setVals(treeNode){
	if(document.getElementById(myTreeId)){
		var val="";
		var k=0;
		for(tempKey in treeNode){
			if(isNaN(treeNode[tempKey])&&treeNode[tempKey].toString().indexOf('function')>=0){continue;};
			if(k>0){val+=",";}
			val+="\""+tempKey+"\":\""+treeNode[tempKey]+"\"";
			k++;
		}
		$('#'+myTreeId).val("({"+val+"})");
	}
}
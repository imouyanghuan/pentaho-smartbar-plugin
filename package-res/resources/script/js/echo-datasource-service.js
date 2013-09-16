document.write('<div id="echoDatasourceDialog" class="flora" style="display:none" title="New Echo Datasource">');
document.write('<p>New Datasource</p>');
document.write('<form id="echoDatasourceDialogForm" name="echoDatasourceDialogForm" method="post">');
document.write('<input type="text" id="datasourceName" value="" name="datasource"><br>');
document.write('</form>');
document.write('</div>');

var EchoDatasourceService =  {
	type: "Echo",
	editable: true,
	removable: true,
	importable:  false,
	exportable: false,
	newUI: "javascript:window.top.showEchoDatasourceDialog({callback})",
	editUI: "javascript:window.top.showEditEchoDatasourceDialog({callback}, {datasourceId})",
	init: function(){
		
	},
	getIds: function(){
		var datasourceInfos = [];
	    $.ajax({
	         url: CONTEXT_PATH + "plugin/echo/api/datasource/ids",
	         success:function(data) {
	        	var itemList = $(data).find('Item');
	        	for(i=0;i<itemList.length;i++) {
	        		var item = itemList[i];
				var datasourceInfo = {
				    name : null,
			            id : null,
				    type : null,
			            editable : false,
 			            removable : false,
			            importable : false,
			            exportable : false
				};
	        		
	        		if(item != null) {
					datasourceInfo.name = item.childNodes[0].data;
					datasourceInfo.id = item.childNodes[0].data;
					datasourceInfo.type =  EchoDatasourceService.type;
					datasourceInfo.editable = EchoDatasourceService.editable;
					datasourceInfo.removable = EchoDatasourceService.removable;
					datasourceInfo.importable = EchoDatasourceService.importable;
					datasourceInfo.exportable = EchoDatasourceService.exportable;
			    	        datasourceInfos.push(datasourceInfo); 
			    	}
	        		
	        	}
	          },
	          type: "GET",
	          async:   false,
	          mimeType: "text/xml",
	          dataType: "xml"
	    });

	    return datasourceInfos;
	},
	getNewUI: function(){
		return EchoDatasourceService.newUI;
	},
	getType: function(){
		return EchoDatasourceService.type;
	},
	getEditUI: function(datasourceId){
		return EchoDatasourceService.editUI;	
	},
	doExport: function(){
		
	},
	doRemove: function(datasourceId, callback){
		$.ajax({
				url: CONTEXT_PATH + "plugin/echo/api/datasource/remove",
				data: datasourceId,
				success:function(data) {
					callback.success(true);
				},
				ajax:true,
				type: "DELETE",
				mimeType: "text/xml",
				dataType: "text/xml"
			});	
	}
		  
};


var registerUIDatasourceService =  function(EchoDatasourceService) {
	if(typeof window.top.pho == 'undefined' || typeof window.top.pho.registerUIDatasourceService == 'undefined'){
		setTimeout(function(){
			registerUIDatasourceService(EchoDatasourceService);
		  }, 200);
		  return;
	} else {
		window.top.pho.registerUIDatasourceService(EchoDatasourceService);		
	}
};

registerUIDatasourceService(EchoDatasourceService);

	var globalCallback;


    var cancel = function() {
        $("#echoDatasourceDialog").dialog("close");
    };
    
    var getResponse = function(){
	     var datasourceName = $("#datasourceName").val();
			$.ajax({
				url: CONTEXT_PATH + "plugin/echo/api/datasource/add",
				data: datasourceName,
				success:function(data) {
					globalCallback.onOk(data);
					$("#echoDatasourceDialog").dialog("close");
				},
				ajax:true,
				type: "PUT",
				mimeType: "text/xml",
				dataType: "text/xml"
			});
	};

var showEchoDatasourceDialog = function(callback) {

	var dialogOpts = {
	    modal: true,
	    zIndex:1200,
	    buttons:{
	       "Done":getResponse,
	       "Cancel":cancel
	    },
	    autoOpen: false
	};

	globalCallback = callback;
	$(document).ready(function(){
		$("#echoDatasourceDialog").dialog(dialogOpts);
		$("#echoDatasourceDialog").dialog("open");
	});

};


var showEditEchoDatasourceDialog = function(callback, datasourceId) {

	var dialogOpts = {
	    modal: true,
	    zIndex:1200,
	    title: 'Edit Echo Datasource',
	    buttons:{
	       "Done":getResponse,
	       "Cancel":cancel
	    },
	    autoOpen: false
	};

	globalCallback = callback;
	$(document).ready(function(){
		$("#echoDatasourceDialog").dialog(dialogOpts);
		$("#echoDatasourceDialog").dialog("open");
	});

};
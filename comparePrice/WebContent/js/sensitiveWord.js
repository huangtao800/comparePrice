$(function(){
	$('a.removeSensitiveWord').live('click',function(event){
		var sensitiveId=($(this).parent().parent()).find('tr.td_sensitiveWordId').text();
		//var id=       ($(this).parent().parent()).find('td.td_toForbidId').text();
		alert(commodityId);
		var tr_forbid=$(this).parent().parent();

		$.get('RemoveSensitiveWordAction',{sensitiveId:sensitiveId},function(response){
			if(response=="Y"){
				alert("成功屏蔽该商品！");
				tr_forbid.detach(); ///???????????????
			}
		});	
		
	});

});
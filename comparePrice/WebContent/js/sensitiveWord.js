$(function(){
	$('#sensitiveWord').attr('value','');
/*	
	
	$('a.removeSensitiveWord').live('click',function(event){
		alert("asd");
		var sensitiveId=($(this).parent().parent()).find('tr.td_sensitiveWordId').text();
		//var id=       ($(this).parent().parent()).find('td.td_toForbidId').text();
		alert(sensitiveId);
		var tr_forbid=$(this).parent().parent();

		$.get('RemoveSensitiveWordAction',{sensitiveId:sensitiveId},function(response){
			if(response=="Y"){
				alert("成功屏蔽该商品！");
				tr_forbid.detach(); ///???????????????
			}
		});	
		
	});
*/
});
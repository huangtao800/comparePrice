$(function(){
	$('a.forbid').live('click',function(event){
		var commodityId=($(this).parent().parent()).find('tr.td_toForbidId').text();
		//var id=       ($(this).parent().parent()).find('td.td_toForbidId').text();
		alert(commodityId);
		var tr_forbid=$(this).parent().parent();

		$.get('ForbidAction',{commodityId:commodityId},function(response){
			if(response=="Y"){
				alert("成功屏蔽该商品！");
				tr_forbid.detach(); ///???????????????
			}
		});	
		
	});

	$('a.cancelForbid').live('click',function(event){
		var commodityId=($(this).parent().parent()).find('tr.td_cancelForbidId').text();
		alert(commodityId);
		var tr_cancelforbid=$(this).parent().parent();

		$.get('CancelForbidAction',{commodityId:commodityId},function(response){
			if(response=="Y"){
				alert("已经取消屏蔽该商品！");
				tr_cancelforbid.detach(); ///???????????????
			}
		});	


	});
})
$(document).ready(function(){
	$(".deleteSelected").click(function(){
	//	$("input[name='newsletter']").attr("checked", true);
		$("input[name='checkboxid']").each(function(){
			if($(this).attr("checked")=="checked")
			{
				var id = $(this).val();
				var myurl = "/ExMvc/StudentServlet?router=delete&id="+id;
				$.ajax({type:"GET",url: myurl, async: false});
				//var i=  0;
			}
		});
		window.location.href = "/ExMvc/StudentServlet";  
	});
	
	$("table tr:gt(0)").find("td:eq(0)").each(function(i){
		$(this).text(i+1);
	});
});
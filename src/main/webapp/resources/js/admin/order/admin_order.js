const orderNumber = $('#ordernumber_M')
const orderDate = $('#orderDate_M')
const orderName = $('#orderName_M')
const orderPhone = $('#userPhoneNum_M')
const UserName = $('#userName_M')




$("#datepicker" ).datepicker({
    	dateFormat: 'yy/mm/dd'
   });
    
   $("#datepicker1" ).datepicker({
		dateFormat: 'yy/mm/dd'
});



$('.order_modal_go').click(function() {
	const o_no = $("#orderInput_M").val();
	$('#order_modal').show();
	$('#order_modal').css('z-index', '3');
	// 모달 on
	
	$("#update_modal").attr("action", "")
	$("body").css("overflow", 'hidden');
	
	$.ajax({
		type: "GET", //요청 메소드 방식
		url: "order.get",
		data: {o_no},
		success : function(result){
			
		},
	});

})

$("#cancleModal").click(function() {
	$('#order_modal').hide();
	// 모달 off
	$("body").css("overflow", 'auto');

});
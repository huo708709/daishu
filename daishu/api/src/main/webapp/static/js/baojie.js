$(function() {
	window.onhashchange = function() {
		var hashStr = location.hash.replace("#","");
		if (hashStr == 'second') {
			$('body > .am-container').hide();
	        $('#baojie_second').show();
		} else if (hashStr == 'frist') {
			$('body > .am-container').hide();
			$('#baojie_frist').show();
		} else if (hashStr == 'address') {
			$('body > .am-container').hide();
			$('#address_container').show();
		} else {
			$('body > .am-container').hide();
			$('#baojie_frist').show();
		}
	}
    $('#next').on('click', function(event) {
    	var name = $('#baojie_frist input[name="name"]').val();
    	if (!name) {
    		event.preventDefault();
    		$('#my-alert .am-modal-bd').text('请填写您的姓名');
    		$('#my-alert').modal();
    		$('#baojie_frist input[name="name"]').focus();
    		return;
    	}
    	var phone = $('#baojie_frist input[name="phone"]').val();
    	if (!phone) {
    		event.preventDefault();
    		$('#my-alert .am-modal-bd').text('请填写您的电话');
    		$('#my-alert').modal();
    		$('#baojie_frist input[name="phone"]').focus();
    		return;
    	}
//    	var addressId = $('#baojie_frist input[name="addressId"]').val();
//    	if (!addressId) {
//    		event.preventDefault();
//    		$('#my-alert .am-modal-bd').text('请选择您的服务地址');
//    		$('#my-alert').modal();
//    		return;
//    	}
        $('#baojie_frist').hide();
        $('#baojie_second').show();
    });
    $('#submit_order').on('click', function() {
        $('#baojie_second').hide();
        $('#baojie_payment').show();
    });
    $('#baojie_second').on('click', 'li.day', function() {
    	$('#baojie_second').find('li.day').removeClass('active');
    	$(this).addClass('active');
    });
    $('#baojie_second').on('click', 'a.schedule-time', function() {
    	$('#baojie_second').find('a.schedule-time').removeClass('active');
    	$(this).addClass('active');
    });
    var address = new Address();
});
$(function() {
	window.onhashchange = function() {
		showPage();
	}
	function showPage() {
		var hashStr = location.hash.replace("#","");
		if (hashStr == 'frist') {
			$('body .am-container-page').hide();
			$('#baojie_frist').show();
		} else if (hashStr == 'address') {
			$('body .am-container-page').hide();
			$('#address_container').show();
		} else {
			$('body .am-container-page').hide();
			$('#baojie_frist').show();
		}
	}
	function validateFirst() {
		var name = $('#baojie_frist input[name="name"]').val();
    	if (!name) {
    		event.preventDefault();
    		$('#my-alert .am-modal-bd').text('请填写您的姓名');
    		$('#my-alert').modal();
    		$('#baojie_frist input[name="name"]').focus();
    		return false;
    	}
    	var phone = $('#baojie_frist input[name="phone"]').val();
    	if (!phone) {
    		event.preventDefault();
    		$('#my-alert .am-modal-bd').text('请填写您的电话');
    		$('#my-alert').modal();
    		$('#baojie_frist input[name="phone"]').focus();
    		return false;
    	}
    	var addressId = $('#baojie_frist input[name="addressId"]').val();
    	if (!addressId) {
    		event.preventDefault();
    		$('#my-alert .am-modal-bd').text('请选择您的服务地址');
    		$('#my-alert').modal();
    		return false;
    	}
    	return true;
	}
	showPage();
    $('#next').on('click', function(event) {
    	if (validateFirst()) {
    		$('#orderSubmit').submit();
    	}
    });
    var address = new Address();
});
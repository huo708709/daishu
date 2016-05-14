$(function() {
	window.onhashchange = function() {
		showPage();
	}
	function showPage() {
		var hashStr = location.hash.replace("#","");
		if (hashStr == 'second') {
			$('body .am-container-page').hide();
	        $('#baojie_second').show();
		} else if (hashStr == 'frist') {
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
//    	var addressId = $('#baojie_frist input[name="addressId"]').val();
//    	if (!addressId) {
//    		event.preventDefault();
//    		$('#my-alert .am-modal-bd').text('请选择您的服务地址');
//    		$('#my-alert').modal();
//    		return false;
//    	}
    	return true;
	}
	showPage();
    $('#next').on('click', function(event) {
    	validateFirst();
    });
    $('#baojie_second').on('click', 'li.day', function() {
    	$('#baojie_second').find('li.day').removeClass('active');
    	$(this).addClass('active');
    	$('#my-modal-loading').modal();
    	var baojieType = $(this).data('baojietype');
    	var date = $(this).data('date');
    	daishu.io.httppost('schedule/getAvailableAyiCountMap', {
    		baoJieType: baojieType,
    		serviceDate: date
    	}, '', function(data) {
    		var type1 = data['1'];
    		if (type1 <= 0) {
    			$('#baojie_second a.schedule-time').eq(0).removeClass('active').addClass('disable');
    		} else {
    			$('#baojie_second a.schedule-time').eq(0).removeClass('disable');
    		}
    		var type2 = data['2'];
    		if (type2 <= 0) {
    			$('#baojie_second a.schedule-time').eq(1).removeClass('active').addClass('disable');
    		} else {
    			$('#baojie_second a.schedule-time').eq(1).removeClass('disable');
    		}
    		var type3 = data['3'];
    		if (type3 <= 0) {
    			$('#baojie_second a.schedule-time').eq(2).removeClass('active').addClass('disable');
    		} else {
    			$('#baojie_second a.schedule-time').eq(2).removeClass('disable');
    		}
    		var type4 = data['4'];
    		if (type4 <= 0) {
    			$('#baojie_second a.schedule-time').eq(3).removeClass('active').addClass('disable');
    		} else {
    			$('#baojie_second a.schedule-time').eq(3).removeClass('disable');
    		}
    		$('#my-modal-loading').modal('close');
    	}, function() {
    		
    	});
    });
    $('#baojie_second').on('click', 'a.schedule-time', function(event) {
    	$('#baojie_second').find('a.schedule-time').removeClass('active');
    	$(this).addClass('active');
    });
    $('#area').blur(function() {
    	var area = $('#area').val();
    	var unit = $('#price').data('unit');
    	$('#priceShow').text(area * unit);
    	$('#price').val(area * unit);
    });
    $('#submit_order').on('click', function(event) {
    	var serviceDate = $('#baojie_second input[name="serviceDate"]:checked').val();
    	if (!serviceDate) {
    		event.preventDefault();
    		$('#my-alert .am-modal-bd').text('请选择服务日期');
    		$('#my-alert').modal();
    		return;
    	}
    	var serviceTimeType = $('#baojie_second input[name="serviceTimeType"]:checked').val();
    	if (!serviceTimeType) {
    		event.preventDefault();
    		$('#my-alert .am-modal-bd').text('请选择服务时间段');
    		$('#my-alert').modal();
    		return;
    	}
    	var area = $('#baojie_second input[name="area"]').val();
    	if (!area) {
    		event.preventDefault();
    		$('#my-alert .am-modal-bd').text('请填写服务面积');
    		$('#my-alert').modal();
    		return;
    	}
    	$('#orderSubmit').submit();
    });
    var address = new Address();
});
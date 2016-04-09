wx.ready(function() {
	$('.huiyuanka-list').on('click', 'button', function() {
    	var viptype = $(this).data('viptype');
    	$.ajax({
			url: 'recharge/add',
			type: 'POST',
			dataType: 'json',
			data: {
				type: viptype
			},
			success: function(data) {
				wx.chooseWXPay({
					appId: data.appId,
					timestamp: data.timeStamp + "",
					nonceStr: data.nonceStr,
					package: data.package,
					signType: "MD5",
					paySign: data.paySign,
					success: function(data1) {
						pay(phone, name, serviceShopId, data.orderNum);
					},
					fail: function() {
						alert("支付失败");
					},
					cancel: function() {
						window.location.href = "auth";
					}
				});
			}
		});
    });
});
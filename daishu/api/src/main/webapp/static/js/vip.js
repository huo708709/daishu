wx.ready(function() {
	$('.huiyuanka-list').on('click', 'button', function() {
		$('#my-modal-loading').modal();
    	var viptype = $(this).data('viptype');
    	daishu.io.httppost('recharge/add', {type: viptype}, '', function(data) {
    		$('#my-modal-loading').modal('close');
    		wx.chooseWXPay({
				appId: data.appId,
				timestamp: data.timeStamp + "",
				nonceStr: data.nonceStr,
				package: data.package,
				signType: "MD5",
				paySign: data.paySign,
				success: function(data) {
//					alert("支付成功");
					$('#my-alert .am-modal-bd').text('支付成功');
		    		$('#my-alert').modal();
				},
				fail: function() {
//					alert("支付失败");
					$('#my-alert .am-modal-bd').text('支付失败');
		    		$('#my-alert').modal();
				},
				cancel: function() {
//					alert("支付取消");
					$('#my-alert .am-modal-bd').text('支付取消');
		    		$('#my-alert').modal();
				}
			});
    	});
    });
});
define('component/formatter', [], function() {
	
	return {
		baojieTypeFormatter: function(data) {
			if (1 == data) {
				return '小时保洁';
			} else if (2 == data) {
				return '请个阿姨';
			} else if (3 == data) {
				return '收纳整理';
			} else if (4 == data) {
				return '擦玻璃';
			} else if (5 == data) {
				return '家居开荒';
			} else if (6 == data) {
				return '家电家居';
			} else if (7 == data) {
				return '企业保洁';
			} else if (8 == data) {
				return '干洗';
			} else if (9 == data) {
				return '包月订单';
			} else {
				return '未知';
			}
		},
		orderAuditStatusFormatter: function(data) {
			if (1 == data) {
				return '待审核';
			} else if (2 == data) {
				return '审核通过';
			} else if (3 == data) {
				return '审核不通过';
			}else{
				return data;
			}
		},
		orderPayStatusFormatter: function(data) {
			if (1 == data) {
				return '待支付';
			} else if (2 == data) {
				return '服务中';
			} else if (3 == data) {
				return '待评价';
			} else if (4 == data) {
				return '已评价';
			} else if (5 == data) {
				return '已取消';
			} else{
				return data;
			}
		},
		serviceTimeTypeFormatter: function(data) {
			if (1 == data) {
				return '8:00-12:00';
			} else if (2 == data) {
				return '12:00-15:00';
			} else if (3 == data) {
				return '15:00-18:00';
			} else if (4 == data) {
				return '18:00-20:00';
			} else{
				return data;
			}
		},
		payTypeFormatter: function(data) {
			if (1 == data) {
				return '微信支付';
			} else if (2 == data) {
				return '现金支付';
			} else if (3 == data) {
				return '会员卡支付';
			} else{
				return data;
			}
		},
		customerStatusFormatter: function(data) {
			if (1 == data) {
				return '正常';
			} else{
				return '禁用';
			}
		}
	};
});
define('component/formatter', [], function() {
	
	return {
		baojieTypeFormatter: function(data) {
			if (1 == data) {
				return '常规保洁';
			} else if (2 == data) {
				return '精细保洁';
			} else if (3 == data) {
				return '深度保洁';
			} else if (4 == data) {
				return '擦玻璃';
			} else if (5 == data) {
				return '家居开荒';
			} else if (6 == data) {
				return '家电清洗';
			} else if (7 == data) {
				return '家具护理';
			} else if (8 == data) {
				return '干洗';
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
			} else{
				return data;
			}
		}
	};
});
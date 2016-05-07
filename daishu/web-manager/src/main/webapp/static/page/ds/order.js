define('page/ds/order', ['component/curd', 'component/form', 'component/formatter', 'component/chooseAyi','component/modal'], function(CURD, FORM, Formatter,ChooseAyi,Modal) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_order'),
	            onDataLoad: function() {
	            	$.fn.editable.defaults.mode = 'inline';
	    			$.fn.editable.defaults.inputclass = 'form-control';
	    	        $.fn.editable.defaults.url = 'ds/order/changePrice';
	    			$('#datatable_order .editable_item').editable();
	            },
	            dataTable: { 
	                ajax: {
	                    url: 'ds/order/list_paged',
	                },
	                order: [
	                    [1, 'asc']
	                ],
	                columns: [{
	                	data: 'id', orderable: false, render: function(data) {
	                		return '<input type="checkbox" title="' + data + '" class="checkboxes" value="' + data + '" />';
	                	}
	                }, {
	                	data: 'orderNo'
	                }, {
	                	data: 'customerName'
	                }, {
	                	data: 'createTime'
	                }, {
	                	data: 'serviceDate'
	                },{
	                	data: 'serviceTimeType', render: function(data) {
	                		return Formatter.serviceTimeTypeFormatter(data);
	                	}
	                },{
	                	data: 'auditStatus', render: function(data) {
	                		return Formatter.orderAuditStatusFormatter(data);
	                	}
	                },{
	                	data: 'payStatus', render: function(data) {
	                		return Formatter.orderPayStatusFormatter(data);
	                	}
	                },{
	                	data: 'baojieType', render: function(data) {
	                		return Formatter.baojieTypeFormatter(data);
	                	}
	                }, {
	                	data: 'ayiName'
	                },{
	                	data: 'price', render: function(data, type, row, meta) {
	                		return '<a class="editable_item" href="javascript:;" id="price" data-type="text" data-pk="'+row.id+'" data-original-title="输入价格">'+data+'</a>';
	                	}
	                }, {
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '<a class="btn btn-xs default purple choose_ayi" data-id="' + row.id + '" href="javascript:"> 指派阿姨 </a>';
//	                		s += '<a class="btn btn-xs default blue skip_to_edit" href="ds/order/update?id=' + row.id + '"> 修改 </a>';
	                		if(row.payStatus == 1){
	                			s += '<a class="btn btn-xs default purple order_update_pay_status" data-id="' + row.id + '" href="javascript:"> 修改支付状态为"服务中" </a>';
	                		}
	                		s += '<a class="btn btn-xs default red order_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a><br>';
	                		s += '<a class="btn btn-xs default blue skip_to_edit" href="ds/order/copy?id=' + row.id + '"> 复制订单 </a><br>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			$('#serviceDate').datetimepicker({
				format: 'yyyy-mm-dd',
				language: 'zh-CN',
				minView: 1
			});
			FORM.initFormValidate($('#order_copy_form'), {
				rules: {
					area: {
						required: true,
					},
					price: {
						required: true,
					},
					serviceTimeType: {
						required: true
					},
					serviceDate: {
						required: true
					},
					baojieType: {
						required: true
					}
				}
			}, function() {
            	the.gridReload();
            }, function() {
            	the.gridReload();
            });
		},
		bind: function() {
			var the = this;
			$('#order_container').on('click', '.order_delete', function() {
				var orderId = $(this).data('id');
				the.deleteOrder([orderId]);
			}).on('click', '.order_update_pay_status', function() {
				var orderId = $(this).data('id');
				the.updatePayStatusByIds([orderId]);
			}).on('click', '.orders_delete', function() {
				the.deleteOrder(grid.getSelectedRows());
			});
			$(document).on('click', '.choose_ayi', function() {
				var userId = $(this).data('id');
				ChooseAyi.assignAyi(userId);
			});
		},
		unbind: function() {
			$('#order_container').off();
			$(document).off('click', '.choose_ayi');
		},
		deleteOrder: function(orderIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'ds/order/delete',
				data: {
					ids: orderIds
				}
			}, function() {
				the.gridReload();
			}, function() {
				the.gridReload();
			});
		},
		updatePayStatusByIds: function(orderIds) {
			var the = this;
			CURD.operateByIds(
				'确认修改支付状态？',
				{
				url: 'ds/order/updatePayStatusByIds',
				data: {
					ids: orderIds
				}
			}, function() {
				the.gridReload();
			}, function() {
				the.gridReload();
			});
		},
		gridReload: function() {
			grid.getDataTable().ajax.reload(false);
		},
		destroy: function() {
			if (grid) {
				grid.destroy();
			}
			this.unbind();
		}
	};
});
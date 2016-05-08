define('page/ds/order_statistic', ['component/curd', 'component/form', 'component/formatter', 'component/chooseAyi','component/modal'], function(CURD, FORM, Formatter,ChooseAyi,Modal) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_order_statistic'),
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
	                	data: 'phone'
	                }, {
	                	data: 'addressContent'
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
	                	data: 'price'
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			$('#order_birthday').datetimepicker({
				format: 'yyyy-mm-dd',
				language: 'zh-CN',
				minView: 1
			});
			FORM.initFormValidate($('#order_form'), {
				rules: {
					name: {
						required: true,
					},
					phone: {
						required: true,
					},
					cardNo: {
						required: true
					},
					cardPlace: {
						required: true
					},
					address: {
						required: true
					},
					birthday: {
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
			$('#order_statistic_container').on('click', '.order_delete', function() {
				var orderId = $(this).data('id');
				the.deleteAyi([orderId]);
			}).on('click', '.orders_delete', function() {
				the.deleteAyi(grid.getSelectedRows());
			});
			$(document).on('click', '.choose_ayi', function() {
				var userId = $(this).data('id');
				ChooseAyi.assignAyi(userId);
			});
		},
		unbind: function() {
			$('#order_statistic_container').off();
			$(document).off('click', '.choose_ayi');
		},
		deleteAyi: function(orderIds) {
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
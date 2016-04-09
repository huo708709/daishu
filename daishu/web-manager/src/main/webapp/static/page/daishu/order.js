define('page/daishu/order', ['component/curd', 'component/form', 'component/formatter', 'component/chooseAyi','component/modal'], function(CURD, FORM, Formatter,ChooseAyi,Modal) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_order'),
	            onDataLoad: function() {
	            	$.fn.editable.defaults.mode = 'inline';
	    			$.fn.editable.defaults.inputclass = 'form-control';
	    	        $.fn.editable.defaults.url = 'daishu/order/changePrice';
	    			$('#datatable_order .editable_item').editable();
	            },
	            dataTable: { 
	                ajax: {
	                    url: 'daishu/order/list_paged',
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
	                	data: 'serviceTime'
	                },{
	                	data: 'auditStatus'
	                },{
	                	data: 'payStatus'
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
//	                		s += '<a class="btn btn-xs default blue skip_to_edit" href="daishu/order/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red order_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
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
			$('#order_container').on('click', '.order_delete', function() {
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
			$('#order_container').off();
			$(document).off('click', '.choose_ayi');
		},
		deleteAyi: function(orderIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'daishu/order/delete',
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
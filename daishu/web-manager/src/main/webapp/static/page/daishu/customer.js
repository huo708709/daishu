define('page/daishu/customer', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_customer'),
	            dataTable: { 
	                ajax: {
	                    url: 'daishu/customer/list_paged',
	                },
	                order: [
	                    [1, 'asc']
	                ],
	                columns: [{
	                	data: 'id', orderable: false, render: function(data) {
	                		return '<input type="checkbox" title="' + data + '" class="checkboxes" value="' + data + '" />';
	                	}
	                }, {
	                	data: 'weixinName'
	                }, {
	                	data: 'name'
	                }, {
	                	data: 'phone'
	                }, {
	                	data: 'status'
	                }, {
	                	data: 'lastTime', render: function(data, type, row, meta) {
	                		if (data) return data;
	                		else return "";
	                	}
	                }, {
	                	data: 'firstTime', render: function(data, type, row, meta) {
	                		if (data) return data;
	                		else return "";
	                	}
	                }, {
	                	data: 'address'
	                }, {
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '<a class="btn btn-xs default blue skip_to_edit" href="daishu/customer/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red customer_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			FORM.initFormValidate($('#customer_form'), {
				rules: {
					name: {
						required: true,
					},
					code: {
						required: true,
					},
					icon: {
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
			$('#customer_container').on('click', '.customer_delete', function() {
				var userId = $(this).data('id');
				the.deleteCustomer([userId]);
			}).on('click', '.customers_delete', function() {
				the.deleteCustomer(grid.getSelectedRows());
			});
		},
		unbind: function() {
			$('#customer_container').off();
		},
		deleteCustomer: function(customerIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'daishu/customer/delete',
				data: {
					ids: customerIds
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
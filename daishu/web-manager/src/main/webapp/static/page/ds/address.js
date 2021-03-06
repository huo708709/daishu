define('page/ds/address', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_address'),
	            dataTable: { 
	                ajax: {
	                    url: 'ds/address/list_paged',
	                },
	                order: [
	                    [1, 'asc']
	                ],
	                columns: [{
	                	data: 'id', orderable: false, render: function(data) {
	                		return '<input type="checkbox" title="' + data + '" class="checkboxes" value="' + data + '" />';
	                	}
	                }, {
	                	data: 'name'
	                }, {
	                	data: 'jobNo'
	                }, {
	                	data: 'phone'
	                }, {
	                	data: 'cardNo'
	                }, {
	                	data: 'cardPlace'
	                }, {
	                	data: 'address'
	                }, {
	                	data: 'birthday'
	                }, {
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '<a class="btn btn-xs default blue skip_to_edit" href="ds/address/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red address_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			$('#address_birthday').datetimepicker({
				format: 'yyyy-mm-dd',
				language: 'zh-CN',
				minView: 1
			});
			FORM.initFormValidate($('#address_form'), {
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
			$('#address_container').on('click', '.address_delete', function() {
				var addressId = $(this).data('id');
				the.deleteAyi([addressId]);
			}).on('click', '.addresss_delete', function() {
				the.deleteAyi(grid.getSelectedRows());
			});
		},
		unbind: function() {
			$('#address_container').off();
		},
		deleteAyi: function(addressIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'ds/address/delete',
				data: {
					ids: addressIds
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
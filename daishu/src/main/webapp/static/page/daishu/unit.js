define('page/daishu/unit', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_unit'),
	            dataTable: { 
	                ajax: {
	                    url: 'daishu/unit/list_paged',
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
	                	data: 'price'
	                }, {
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '<a class="btn btn-xs default blue skip_to_edit" href="daishu/unit/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red unit_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			$('#unit_birthday').datetimepicker({
				format: 'yyyy-mm-dd',
				language: 'zh-CN',
				minView: 1
			});
			FORM.initFormValidate($('#unit_form'), {
				rules: {
					name: {
						required: true,
					},
					price: {
						required: true,
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
			$('#unit_container').on('click', '.unit_delete', function() {
				var unitId = $(this).data('id');
				the.deleteAyi([unitId]);
			}).on('click', '.units_delete', function() {
				the.deleteAyi(grid.getSelectedRows());
			});
		},
		unbind: function() {
			$('#unit_container').off();
		},
		deleteAyi: function(unitIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'daishu/unit/delete',
				data: {
					ids: unitIds
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
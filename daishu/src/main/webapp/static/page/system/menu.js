define('page/system/menu', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_menu'),
	            dataTable: { 
	                ajax: {
	                    url: 'system/menu/list_paged',
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
	                	data: 'code'
	                }, {
	                	data: 'url'
	                }, {
	                	data: 'icon'
	                }, {
	                	data: 'parentName'
	                }, {
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '<a class="btn btn-xs default blue skip_to_edit" href="system/menu/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red menu_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			FORM.initFormValidate($('#menu_form'), {
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
			$('#menu_container').on('click', '.menu_delete', function() {
				var userId = $(this).data('id');
				the.deleteMenu([userId]);
			}).on('click', '.menus_delete', function() {
				the.deleteMenu(grid.getSelectedRows());
			});
		},
		unbind: function() {
			$('#menu_container').off();
		},
		deleteMenu: function(menuIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'system/menu/delete',
				data: {
					ids: menuIds
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
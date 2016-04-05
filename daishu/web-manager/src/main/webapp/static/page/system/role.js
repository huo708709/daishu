define('page/system/role', ['component/curd', 'component/form', 'component/authorizeMenu'], function(CURD, FORM, AuthorizeMenu) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_role'),
	            dataTable: { 
	                ajax: {
	                    url: 'system/role/list_paged',
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
	                	data: 'description'
	                }, {
	                	orderable: false, render: function(data, type, row, meta) {
	                		var s = '<a class="btn btn-xs default blue skip_to_edit" href="system/role/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red role_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		s += '<a class="btn btn-xs default purple authorize_menu" data-id="' + row.id + '" href="javascript:"> 授权 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			FORM.initFormValidate($('#role_form'), {
				rules: {
					name: {
						required: true,
					},
					description: {
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
			$('#role_container').on('click', '.role_delete', function() {
				var roleId = $(this).data('id');
				the.deleteRole([roleId]);
			}).on('click', '.roles_delete', function() {
				the.deleteRole(grid.getSelectedRows());
			});
			$(document).on('click', '.authorize_menu', function() {
				var roleId = $(this).data('id');
				AuthorizeMenu.authorize(roleId);
			});
		},
		unbind: function() {
			$('#role_container').on('click');
			$(document).off('click', '.authorize_menu');
		},
		deleteRole: function(roleIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'system/role/delete',
				data: {
					ids: roleIds
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
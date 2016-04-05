define('page/system/user', ['component/curd', 'component/form', 'component/chooseRole'], function(CURD, FORM, ChooseRole) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_user'),
	            dataTable: { 
	                ajax: {
	                    url: 'system/user/list_paged',
	                },
	                order: [
	                    [1, 'asc']
	                ],
	                columns: [{
	                	data: 'id', orderable: false, render: function(data) {
	                		return '<input type="checkbox" title="' + data + '" class="checkboxes" value="' + data + '" />';
	                	}
	                }, {
	                	data: 'username'
	                }, {
	                	data: 'email'
	                }, {
	                	data: 'phone'
	                }, {
	                	data: 'status', render: function(data, type, full, meta) {
	                		if ('0' == data) {
	                			return '<button class="btn btn-xs default green user_status" data-id="' + full.id + '" data-status="1"> 正常 </button>';
	                		} else {
	                			return '<button class="btn btn-xs default red user_status" data-id="' + full.id + '" data-status="0"> 锁定 </button>';
	                		}
	                	}
	                }, {
	                	orderable: false, render: function(data, type, row, meta) {
	                		var s = '<a class="btn btn-xs default blue skip_to_edit" href="system/user/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red user_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		s += '<a class="btn btn-xs default purple choose_role" data-id="' + row.id + '" href="javascript:"> 角色 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			FORM.initFormValidate($('#user_form'), {
				rules: {
					username: {
						required: true,
					},
					password: {
						required: true,
					},
					phone: {
						required: true,
						number: true
					},
					email: {
						required: true,
						email: true
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
			$('#user_container').on('click', '.user_delete', function() {
				var userId = $(this).data('id');
				the.deleteUser([userId]);
			}).on('click', '.users_delete', function() {
				the.deleteUser(grid.getSelectedRows());
			}).on('click', '.user_status', function() {
				var userId = $(this).data('id');
				var status = $(this).data('status');
				the.updateUserStatus(userId, status)
			});
			$(document).on('click', '.choose_role', function() {
				var userId = $(this).data('id');
				ChooseRole.assignRole(userId);
			});
		},
		unbind: function() {
			$('#user_container').off('click');
			$(document).off('click', '.choose_role');
		},
		updateUserStatus: function(userId, status) {
			var the = this;
			CURD.addOrUpdate({
				url: 'system/user/update/status/' + status,
				data: {
					id: userId
				}
			}, function() {
				the.gridReload();
			}, function() {
				the.gridReload();
			});
		},
		deleteUser: function(userIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'system/user/delete',
				data: {
					ids: userIds
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
define('component/chooseRole', ['component/modal', 'component/curd'], function(Modal, CURD) {
	
	function createChooseRoleGrid() {
		this.element = $('#datatable_choose_role');
		this.grid = this.element.DataTable({
			dom: "<'row'<'col-md-12'f>><'table-scrollable't>",
			scrollY: 350,
			scrollX: true,
			scroller: true,
			deferRender: true,
			ordering: false,
			page: false,
			pagingType: 'simple_numbers'
		});
	}
	
	return {
		assignRole: function(userId) {
			var the = this;
			Modal.open({
				backdrop: 'static',
				remote: 'system/role/choice?userId=' + userId,
				loadedCallBack: function() {
					createChooseRoleGrid.call(the);
				},
				closedCallBack: function() {
					the.destroy();
				},
				affirmCallBack: function() {
					var roleIds = [];
					the.element.find(':checked').each(function() {
						roleIds.push($(this).val());
					});
					CURD.ajax({
						url: 'system/user/assign_roles',
						data: {
							userId: userId,
							roleIds: roleIds
						}
					}, function() {
					}, function() {
					});
				}
			});
		},
		destroy: function() {
			this.grid.destroy();
		}
	}
});
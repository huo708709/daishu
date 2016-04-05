define('component/authorizeMenu', ['component/curd', 'component/modal'], function(CURD, Modal) {
	function createAuthorizeMenu() {
		$('#authorize_menu_treegrid').treegrid();
	}
	
	return {
		authorize: function(roleId) {
			var the = this;
			Modal.open({
				backdrop: 'static',
				remote: 'system/menu/authorization?roleId=' + roleId,
				loadedCallBack: function() {
					createAuthorizeMenu.call(the);
				},
				closedCallBack: function() {
					the.destroy();
				},
				affirmCallBack: function() {
					CURD.submitForm($('#authorize_menu_form'));
				}
			});
		},
		destroy: function() {
//			this.grid.destroy();
		}
	}
});
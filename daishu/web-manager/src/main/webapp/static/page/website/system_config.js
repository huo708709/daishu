define('page/website/system_config', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			$.fn.editable.defaults.mode = 'inline';
			$.fn.editable.defaults.inputclass = 'form-control';
	        $.fn.editable.defaults.url = 'website/system_config/update';
			$('#system_config_table .editable_item').editable();
			this.bind();
		},
		bind: function() {
			var the = this;
		},
		unbind: function() {
			$('#system_config_container').off();
		},
		destroy: function() {
			if (grid) {
				grid.destroy();
			}
			this.unbind();
		}
	};
});
define('page/ds/schedule', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			$.fn.editable.defaults.mode = 'inline';
			$.fn.editable.defaults.inputclass = 'form-control';
	        $.fn.editable.defaults.url = 'ds/schedule/update';
			$('#schedule_table .editable_item').editable();
			this.bind();
		},
		bind: function() {
			var the = this;
		},
		unbind: function() {
			$('#schedule_table').off();
		},
		destroy: function() {
			if (grid) {
				grid.destroy();
			}
			this.unbind();
		}
	};
});
define('page/ds/member_card', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			$.fn.editable.defaults.mode = 'inline';
			$.fn.editable.defaults.inputclass = 'form-control';
	        $.fn.editable.defaults.url = 'ds/member_card/update';
			$('#member_card_table .editable_item').editable();
			this.bind();
		},
		bind: function() {
			var the = this;
		},
		unbind: function() {
			$('#member_card_table').off();
		},
		destroy: function() {
			if (grid) {
				grid.destroy();
			}
			this.unbind();
		}
	};
});
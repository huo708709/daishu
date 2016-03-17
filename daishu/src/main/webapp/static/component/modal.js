define('component/modal', [], function() {
	
	function createModal(options) {
		var the = this;
		this.element = $('<div class="modal"><div class="modal-dialog modal-lg"><div class="modal-content"><div/><div/><div/>');
		this.element.modal(options).on('loaded.bs.modal', function(event) {
			if (options.loadedCallBack) {
				options.loadedCallBack($(this));
			}
		}).on('hide.bs.modal', function(event) {
			if (options.closeCallBack) {
				options.closeCallBack($(this));
			}
		}).on('hidden.bs.modal', function(event) {
			if (options.closedCallBack) {
				options.closedCallBack($(this));
			}
			$(this).removeData("bs.modal");
			$(this).remove();
		}).on('click', '[data-affirm="modal"]', function(event) {
			if (options.affirmCallBack) {
				options.affirmCallBack($(this));
			}
			the.close();
		}).on('show.bs.modal', function(event) {
			if (options.showCallBack) {
				options.showCallBack($(this));
			}
		}).on('shown.bs.modal', function(event) {
			if (options.shownCallBack) {
				options.shownCallBack($(this));
			}
		});
	}
	
	return {
		open: function(options) {
			createModal.call(this, options);
		},
		close: function() {
			this.element.modal('hide');
		}
	}
});
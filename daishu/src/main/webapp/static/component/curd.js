define('component/curd', [], function() {
	
	function showMessage(data) {
		if (data && data.action == 'toast') {
			toastr.success(data.message);
		} else if (data && data.action == 'alert') {
			bootbox.alert({
				size: 'small',
				message: data.message
			});
		}
	}
	
	return {
		submitForm: function(form, options, successCallBack, errorCallBack) {
			options = $.extend({dataType: 'json'}, options);
			options.success = function(data) {
				showMessage(data);
        		App.stopPageLoading();
        		$('.page-content > .page-content-body').slideDown();
        		$('.page-content > .page-edit-body').slideUp();
        		successCallBack && successCallBack.apply(this, arguments);
        	};
        	options.error = function(data) {
        		showMessage(data);
        		App.stopPageLoading();
        		errorCallBack && errorCallBack.apply(this, arguments);
        	};
			App.startPageLoading();
            $(form).ajaxSubmit(options);
		},
		addOrUpdate: function(options, successCallBack, errorCallBack) {
			this.ajax(options, function(data) {
				successCallBack && successCallBack.apply(this, arguments);
			}, function() {
				errorCallBack && errorCallBack.apply(this, arguments);
			});
		},
		deleteByIds: function(options, successCallBack, errorCallBack) {
			var the = this;
			if (options.data && options.data.ids && options.data.ids.length > 0) {
				bootbox.confirm('确认删除？', function(result) {
					if (result) {
						the.ajax(options, function(data) {
							successCallBack && successCallBack.apply(this, arguments);
						}, function() {
							errorCallBack && errorCallBack.apply(this, arguments);
						});
					}
				});
			} else {
				showMessage({action: 'toast',message: '请选择需要删除项目'});
			}
		},
		ajax: function(options, successCallBack, errorCallBack) {
			App.startPageLoading();
			options = $.extend({
				type: 'POST',
				dataType: 'json',
				cache: false,
				success: function(data) {
					App.stopPageLoading();
					showMessage(data);
					successCallBack && successCallBack.apply(this, arguments);
				},
				error: function(data) {
					App.stopPageLoading();
					showMessage(data);
					errorCallBack && errorCallBack.apply(this, arguments);
				}
			}, options);
			$.ajax(options);
		}
	}
});
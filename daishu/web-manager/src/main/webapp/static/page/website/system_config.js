define('page/website/system_config', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			$.fn.editable.defaults.mode = 'inline';
			$.fn.editable.defaults.inputclass = 'form-control';
	        $.fn.editable.defaults.url = 'website/system_config/update';
			$('#system_config_table .editable_item').editable();
			$('#summernote_xieyi').summernote({height: 300});
			$('#summernote_guize').summernote({height: 300});
			
			FORM.initFormValidate($('#xieyi_form'), {
				preSubmit: function() {
					$('#content_xieyi').val($('#summernote_xieyi').code());
				}
			}, function() {
				toastr.success('编辑成功');
            }, function() {
            	toastr.success('编辑失败');
            });
			FORM.initFormValidate($('#guize_form'), {
				preSubmit: function() {
					$('#content_guize').val($('#summernote_guize').code());
				}
			}, function() {
				toastr.success('编辑成功');
            }, function() {
            	toastr.success('编辑失败');
            });
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
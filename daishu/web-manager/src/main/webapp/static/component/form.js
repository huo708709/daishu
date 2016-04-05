define('component/form', ['component/curd'], function(CURD) {
	
	return {
		initFormValidate: function(form, options, successCallBack, errorCallBack) {
            var error = $('.alert-danger', form);
            var success = $('.alert-success', form);
            form.validate($.extend(true, {
				errorElement: 'span',
				errorClass: 'help-block help-block-error',
				focusInvalid: false,
				ignore: "",
				invalidHandler: function (event, validator) {            
                    success.hide();
                    error.show();
                    App.scrollTo(error, -200);
                },
                errorPlacement: function (error, element) {
                    var icon = $(element).parent('.input-icon').children('i');
                    icon.removeClass('fa-check').addClass("fa-warning");  
                    icon.attr("data-original-title", error.text()).tooltip({'container': 'body'});
                },
                highlight: function (element) {
                    $(element).closest('.form-group').removeClass("has-success").addClass('has-error'); 
                },
                unhighlight: function (element) {
                },
                success: function (label, element) {
                    var icon = $(element).parent('.input-icon').children('i');
                    $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    icon.removeClass("fa-warning").addClass("fa-check");
                },
                submitHandler: function (form) {
                    success.show();
                    error.hide();
                    App.startPageLoading();
                    if (options && options.preSubmit) {
                    	options.preSubmit.call();
                    }
                    CURD.submitForm(form, {}, successCallBack, errorCallBack);
                }
			}, options));
		}
	}
});
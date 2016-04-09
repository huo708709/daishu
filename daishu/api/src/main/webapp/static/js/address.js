//$(function() {
//    
//    function loadedAddressPage() {
//    	$(document).on('click', '.address')
//    }
//});
var Address = function(e, options) {
	options = options || {};
	this.init();
	return this;
}
Address.prototype.init = function() {
	var the = this;
	$('#address').on('click', function() {
    	$('body > div.am-container').hide();
    	$('#address_container').show();
    });
	$('#address_container').on('click', '.address_add', function() {
		
	}).on('click', '.address_list', function() {
		
	}).on('click', 'button.add', function() {
		the.add();
	}).on('click', '.address_update', function() {
		the.update();
	}).on('click', '.address_delete', function() {
		the.deleteByIds($(this));
	});
	return this;
}
Address.prototype.add = function() {
	var area = $('#address_edit').find('[name="area"]').val();
	var street = $('#address_edit').find('[name="street"]').val();
	var content = $('#address_edit').find('[name="content"]').val();
	
	daishu.io.httppost('address/add', {
		area: area,
		street: street,
		content: content
	});
}
Address.prototype.deleteByIds = function(target) {
	$('#my-confirm').modal({
		relatedTarget: this,
		onConfirm: function(options) {
			daishu.io.httppost('address/delete', {
				ids: [1]
			}, '', function(data) {
				
			}, function() {
				
			});
		},
		onCancel: function() {
		}
	});
}
Address.prototype.update = function() {
	
}
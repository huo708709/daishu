$(function() {
    $('#address').on('click', function() {
    	$('body > div.am-container').hide();
    	$('#address_container').show().load("address");
    });
//    $(document).on('click', '.address')
});
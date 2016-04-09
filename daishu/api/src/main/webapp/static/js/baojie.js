$(function() {
    $('#next').on('click', function() {
        $('#baojie_frist').hide();
        $('#baojie_second').show();
    });
    $('#submit_order').on('click', function() {
        $('#baojie_second').hide();
        $('#baojie_payment').show();
    });
    var address = new Address();
});
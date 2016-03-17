(function(){

var now = { row:1, col:1 }, last = { row:0, col:0};
const towards = { up:1, right:2, down:3, left:4};
var isAnimating = false;

s=window.innerHeight/500;
ss=250*(1-s);

$('.wrap').css('-webkit-transform','scale('+s+','+s+') translate(0px,-'+ss+'px)');

document.addEventListener('touchmove',function(event){
	event.preventDefault(); },false);

$(document).swipeUp(function(){
	if (isAnimating) return;
	last.row = now.row;
	last.col = now.col;
	if (last.row != 6) { now.row = last.row+1; now.col = 1; pageMove(towards.up);}	
})

$(document).swipeDown(function(){
	if (isAnimating) return;
	last.row = now.row;
	last.col = now.col;
	if (last.row!=1) { now.row = last.row-1; now.col = 1; pageMove(towards.down);}	
})

$(document).swipeLeft(function(){
	if (isAnimating) return;
	last.row = now.row;
	last.col = now.col;
	if (last.row>1 && last.row<5 && last.col==1) { now.row = last.row; now.col = 2; pageMove(towards.left);}	
})

$(document).swipeRight(function(){
	if (isAnimating) return;
	last.row = now.row;
	last.col = now.col;
	if (last.row>1 && last.row<5 && last.col==2) { now.row = last.row; now.col = 1; pageMove(towards.right);}	
})

function pageMove(tw){
	var lastPage = ".page-"+last.row+"-"+last.col,
		nowPage = ".page-"+now.row+"-"+now.col;
	
	switch(tw) {
		case towards.up:
			outClass = 'pt-page-moveToTop';
			inClass = 'pt-page-moveFromBottom';
			break;
		case towards.right:
			outClass = 'pt-page-moveToRight';
			inClass = 'pt-page-moveFromLeft';
			break;
		case towards.down:
			outClass = 'pt-page-moveToBottom';
			inClass = 'pt-page-moveFromTop';
			break;
		case towards.left:
			outClass = 'pt-page-moveToLeft';
			inClass = 'pt-page-moveFromRight';
			break;
	}
	isAnimating = true;
	$(nowPage).removeClass("hide");
	
	$(lastPage).addClass(outClass);
	$(nowPage).addClass(inClass);
	
	setTimeout(function(){
		$(lastPage).removeClass('page-current');
		$(lastPage).removeClass(outClass);
		$(lastPage).addClass("hide");
		$(lastPage).find("img").addClass("hide");
		$(nowPage).find("label").addClass("hide");
		$(nowPage).find("input").addClass("hide");
		$(nowPage).find("div").addClass("hide");
		$(nowPage).find("button").addClass("hide");
		
		$(nowPage).addClass('page-current');
		$(nowPage).removeClass(inClass);
		$(nowPage).find("img").removeClass("hide");
		$(nowPage).find("label").removeClass("hide");
		$(nowPage).find("input").removeClass("hide");
		$(nowPage).find("div").removeClass("hide");
		$(nowPage).find("button").removeClass("hide");
		
		isAnimating = false;
	},600);
}
$('#wrap6-1').css('height', document.body.scrollHeight);
$(document).on('click', 'img', function() {
	var the = $(this);
	var selected = $(this).attr('selected');
	var src = $(this).attr('src');
	var length = src.length;
	$('#service_shop_id').val('');
	if (selected == '1') {
		src = src.substring(0, length - 6) + '.png';
		$(this).attr('src', src);
		var point = $(this).attr('point');
		$(this).attr('selected', '0');
	} else {
		src = src.substring(0, length - 4) + '-1.png';
		$(this).attr('src', src);
		$(this).attr('selected', '1');
		$('#service_shop_id').val(point);
	}
	$('.point_img').each(function() {
		if ($(this) != the) {
			var selected1 = $(this).attr('selected');
			var src1 = $(this).attr('src');
			if (selected1 == '1') {
				src1 = src1.substring(0, length - 6) + '.png';
				$(this).attr('src', src1);
				$(this).attr('selected', '0');
			}
		}
	});
});
$('#submit-btn').on('click', function() {
	var name = $('#name').val();
	var phone = $('#phone').val();
	var service_shop_id = $('#service_shop_id').val();
	if (!name) {
		alert('请填写姓名');
		return;
	}
	if (!phone) {
		alert('请填写电话');
		return;
	}
	if (!service_shop_id) {
		alert('请选择服务店');
		return;
	}
	$('#orderform').submit();
});
})();
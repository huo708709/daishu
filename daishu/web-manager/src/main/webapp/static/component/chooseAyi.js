define('component/chooseAyi', ['component/modal', 'component/curd'], function(Modal, CURD) {
	
	function createchooseAyiGrid() {
		this.element = $('#datatable_choose_ayi');
		this.grid = this.element.DataTable({
			dom: "<'row'<'col-md-12'f>><'table-scrollable't>",
			scrollY: 350,
			scrollX: true,
			scroller: true,
			deferRender: true,
			ordering: false,
			page: false,
			pagingType: 'simple_numbers'
		});
	}
	
	return {
		assignAyi: function(orderId) {
			var the = this;
			Modal.open({
				backdrop: 'static',
				remote: 'daishu/ayi/choice?orderId=' + orderId,
				loadedCallBack: function() {
					createchooseAyiGrid.call(the);
				},
				closedCallBack: function() {
					the.destroy();
				},
				affirmCallBack: function() {
					var ayiIds = [];
					the.element.find(':checked').each(function() {
						ayiIds.push($(this).val());
					});
					if(ayiIds.length==0){
						alert("请选择一个保洁人员");
					}else if(ayiIds.length > 1){
						alert("只能选择一个保洁人员");
					}
					
					
					CURD.ajax({
						url: 'daishu/ayi/assign_ayi',
						data: {
							orderId: orderId,
							ayiId: ayiIds[0]
						}
					}, function() {
					}, function() {
					});
				}
			});
		},
		destroy: function() {
			this.grid.destroy();
		}
	}
});
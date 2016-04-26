define('page/data/data_order', ['component/curd', 'component/form', 'component/formatter', 'component/chooseAyi','component/modal'], function(CURD, FORM, Formatter,ChooseAyi,Modal) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_data_order'),
	            dataTable: { 
	                ajax: {
	                    url: 'data/data_order/list_paged_order_data',
	                },
	                order: [
	                    [0, 'desc']
	                ],
	                columns: [ {
	                	data: 'orderDate'
	                }, {
	                	data: 'orderCount'
	                }, {
	                	data: 'orderGmv'
	                }, {
	                	data: 'payTypeWeiXin'
	                },{
	                	data: 'payTypeCash'
	                },{
	                	data: 'payTypeMember'
	                }]
	            }
	        });
			this.bind();
			
			$('#startTime').datetimepicker({
				format: 'yyyy-mm-dd',
				language: 'zh-CN',
				minView: 2
			});
			$('#endTime').datetimepicker({
				format: 'yyyy-mm-dd',
				language: 'zh-CN',
				minView: 2
			});
		},
		initEdit: function() {
		},
		bind: function() {
		},
		unbind: function() {
		},
		gridReload: function() {
			grid.getDataTable().ajax.reload(false);
		},
		destroy: function() {
			if (grid) {
				grid.destroy();
			}
			this.unbind();
		}
	};
});
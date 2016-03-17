define('page/website/banner', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_banner'),
	            dataTable: { 
	                ajax: {
	                    url: 'website/banner/list_paged',
	                },
	                order: [
	                    [1, 'asc']
	                ],
	                columns: [{
	                	data: 'id', orderable: false, render: function(data) {
	                		return '<input type="checkbox" title="' + data + '" class="checkboxes" value="' + data + '" />';
	                	}
	                }, {
	                	data: 'title'
	                }, {
	                	data: 'createTime'
	                }, {
	                	data: 'url'
	                }, {
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '';//'<a class="btn btn-xs default blue skip_to_edit" href="system/menu/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red banner_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			FORM.initFormValidate($('#banner_form'), {
			}, function() {
            	the.gridReload();
            }, function() {
            	the.gridReload();
            });
		},
		bind: function() {
			var the = this;
			$('#banner_container').on('click', '.banner_delete', function() {
				var bannerId = $(this).data('id');
				the.deleteNews([bannerId]);
			}).on('click', '.banner_batch_delete', function() {
				the.deleteNews(grid.getSelectedRows());
			});
		},
		unbind: function() {
			$('#menu_container').off();
		},
		deleteNews: function(bannerIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'website/banner/delete',
				data: {
					ids: bannerIds
				}
			}, function() {
				the.gridReload();
			}, function() {
				the.gridReload();
			});
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
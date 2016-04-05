define('page/website/news', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_news'),
	            dataTable: { 
	                ajax: {
	                    url: 'website/news/list_paged',
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
	                	data: 'digest'
	                }, {
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '';//'<a class="btn btn-xs default blue skip_to_edit" href="system/menu/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red news_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			$('#summernote_news').summernote({height: 300});
			FORM.initFormValidate($('#news_form'), {
				rules: {
					title: {
						required: true,
					},
					digest: {
						required: true,
					}
				},
				preSubmit: function() {
					$('#content').val($('#summernote_news').code());
				}
			}, function() {
            	the.gridReload();
            }, function() {
            	the.gridReload();
            });
		},
		bind: function() {
			var the = this;
			$('#news_container').on('click', '.news_delete', function() {
				var newsId = $(this).data('id');
				the.deleteNews([newsId]);
			}).on('click', '.news_batch_delete', function() {
				the.deleteNews(grid.getSelectedRows());
			});
		},
		unbind: function() {
			$('#menu_container').off();
		},
		deleteNews: function(newsIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'website/news/delete',
				data: {
					ids: newsIds
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
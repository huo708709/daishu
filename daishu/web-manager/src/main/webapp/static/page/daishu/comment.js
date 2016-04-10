define('page/daishu/comment', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_comment'),
	            dataTable: { 
	                ajax: {
	                    url: 'daishu/comment/list_paged',
	                },
	                order: [
	                    [1, 'asc']
	                ],
	                columns: [{
	                	data: 'id', orderable: false, render: function(data) {
	                		return '<input type="checkbox" title="' + data + '" class="checkboxes" value="' + data + '" />';
	                	}
	                }, {
	                	data: 'orderNo'
	                }, {
	                	data: 'customerName'
	                }, {
	                	data: 'starLevel'
	                },{
	                	data: 'content'
	                },{
	                	data: 'createTime'
	                },{
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '<a class="btn btn-xs default red comment_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
	                }]
	            }
	        });
			this.bind();
		},
		bind: function() {
			var the = this;
			$('#comment_container').on('click', '.comment_delete', function() {
				var commentId = $(this).data('id');
				the.deleteComment([commentId]);
			}).on('click', '.comments_delete', function() {
				the.deleteComment(grid.getSelectedRows());
			});
		},
		unbind: function() {
			$('#comment_container').off();
		},
		deleteComment: function(commentIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'daishu/comment/delete',
				data: {
					ids: commentIds
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
define('page/website/business', ['component/curd', 'component/form'], function(CURD, FORM) {
	
	var grid = null;
	return {
		init: function() {
			grid = new Datatable();
			grid.init({
	            src: $('#datatable_business'),
	            dataTable: { 
	                ajax: {
	                    url: 'website/business/list_paged',
	                },
	                order: [
	                    [1, 'asc']
	                ],
	                columns: [{
	                	data: 'id', orderable: false, render: function(data) {
	                		return '<input type="checkbox" title="' + data + '" class="checkboxes" value="' + data + '" />';
	                	}
	                }, {
	                	data: 'name'
	                }, {
	                	data: 'code'
	                }, {
	                	data: 'intro'
	                }, {
	                	data: 'unitName'
	                }/*, {
	                	orderabel: false, render: function(data, type, row, meta) {
	                		var s = '';//'<a class="btn btn-xs default blue skip_to_edit" href="system/menu/update?id=' + row.id + '"> 修改 </a>';
	                		s += '<a class="btn btn-xs default red business_delete" data-id="' + row.id + '" href="javascript:"> 删除 </a>';
	                		return s;
	                	}
	                }*/]
	            }
	        });
			this.bind();
		},
		initEdit: function() {
			var the = this;
			$('#summernote_business').summernote({height: 300});
			FORM.initFormValidate($('#business_form'), {
				rules: {
					name: {
						required: true,
					},
					code: {
						required: true,
					}
				},
				preSubmit: function() {
					$('#business_description').val($('#summernote_business').code());
				}
			}, function() {
            	the.gridReload();
            }, function() {
            	the.gridReload();
            });
		},
		bind: function() {
			var the = this;
			$('#business_container').on('click', '.business_delete', function() {
				var businessId = $(this).data('id');
				the.deleteNews([businessId]);
			}).on('click', '.business_batch_delete', function() {
				the.deleteNews(grid.getSelectedRows());
			});
		},
		unbind: function() {
			$('#menu_container').off();
		},
		deleteNews: function(businessIds) {
			var the = this;
			CURD.deleteByIds({
				url: 'website/business/delete',
				data: {
					ids: businessIds
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
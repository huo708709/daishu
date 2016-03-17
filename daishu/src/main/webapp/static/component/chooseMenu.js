define('component/chooseMenu', ['component/modal'], function(Modal) {
	
	function createChooseMenu() {
		this.grid = new Datatable();
		this.grid.init({
            src: $('#datatable_choose_menu'),
            dataTable: { 
                bStateSave: true,
                lengthMenu: [
                    [10, 20, 50, 100, 150, -1],
                    [10, 20, 50, 100, 150, 'All']
                ],
                pageLength: 10,
                ajax: {
                    url: 'system/role/list_paged',
                },
                order: [
                    [1, 'asc']
                ],
                columns: [{
                	data: 'id', orderable: false, render: function(data) {
                		return '<input type="checkbox" class="checkboxes" value="' + data + '" />';
                	}
                }, {
                	data: 'name'
                }, {
                	data: 'description'
                }]
            }
        });
	}
	
	function destroyChooseMenuGrid() {
		this.grid.getDataTable().destroy();
	}
	
	return {
		init: function() {
			this.bind();
		},
		bind: function() {
			var the = this;
			$(document).on('click', '.choose_menu button', function(event) {
				var userId = $(this).data('userid');
				Modal.open({
					backdrop: 'static',
					remote: 'role/choose?userId=' + userId,
					loadedCallBack: function() {
						createChooseMenu.call(the);
					},
					closedCallBack: function() {
						the.destroy();
					}
				});
			});
		},
		unbind: function() {
			$(document).off('click', '.choose_role button');
		},
		destroy: function() {
			this.unbind();
			destroyChooseMenuGrid.call(this);
		}
	}
});

        $(document).ready(function () {
            $('#sidebarToggle').click(function () {
                $('#sidebar').toggleClass('collapsed');
                $('#mainContent').toggleClass('sidebar-collapsed');
                var icon = $('#sidebarToggleIcon i');
                if ($('#sidebar').hasClass('collapsed')) {
                    icon.removeClass('fa-chevron-left').addClass('fa-chevron-right');
                } else {
                    icon.removeClass('fa-chevron-right').addClass('fa-chevron-left');
                }
            });
        });

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daily Standup tracker!</title>
        <style>
            .green {color: green}
            .orange {color: orange}
            .red {color: red}
        </style>
        <link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
        <script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
        <script type="text/javascript">
            var _url = "api/standup/";
            $(document).ready(function () {
                $.ajax({
                    type: "GET",
                    url: _url + window.location.hash.substr(1)
                }).done(function( standup ) {
                    var tomorrow = '';
                    var today = '';
                    var yesterday = '';
                    var old = '';
                    jQuery.each(standup.dailyStatuses, function() {
                        yesterday += this.statuses + "\n"
                    });
                    $('textarea#yesterday').val(yesterday);
                });
            });
        </script>
    </head>
    <body>
        <!-- Home -->
        <div data-role="page" id="page1">
            <div data-role="content">
                <div data-role="fieldcontain" id="tomorrow" class="green">
                    <fieldset data-role="controlgroup">
                        <label for="tomorrow">
                            Tomorrow
                        </label>
                        <textarea name="tomorrow" id="tomorrow" placeholder="What are you going to work on?"></textarea>
                    </fieldset>
                </div>
                <div data-role="fieldcontain" id="today" class="orange">
                    <fieldset data-role="controlgroup">
                        <label for="today">
                            Today
                        </label>
                        <textarea name="today" id="today" placeholder="What did you work on?"></textarea>
                    </fieldset>
                </div>
                <div data-role="fieldcontain" id="yesterday" class="red">
                    <fieldset data-role="controlgroup">
                        <label for="yesterday">
                            Yesterday
                        </label>
                        <textarea name="yesterday" id="yesterday" placeholder=""></textarea>
                    </fieldset>
                </div>
                <div data-role="fieldcontain" id="past">
                    <fieldset data-role="controlgroup">
                        <label for="past">
                            Past
                        </label>
                        <textarea name="past" id="past" placeholder=""></textarea>
                    </fieldset>
                </div>
            </div>
        </div>
    </body>
</html>

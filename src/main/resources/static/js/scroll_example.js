let count = 0;
jQuery(document).ready(function () {
    doAjax(count);
    $(window).scroll(function () {
        if ($(window).height() + $(window).scrollTop() >= $(document).height()) {
            count = $("#count").val();
            doAjax(count);
        }
    });

    function doAjax(count) {
        $.ajax({
            url: "/dz/getData",
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            mimeType: "application/json",
            success: function (data) {
                console.log(data);
                for (let i = 0; i < data.length; i++) {
                    count++;
                    $("#table").append("<tr><th scope=\"row\">" + count + "</th><td>" + data[i] + "</td></tr>");
                }
                $("#count").empty();
                $("#count").val(count);
            }
        })
    }
});

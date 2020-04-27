jQuery(document).ready(function () {
    getCount();
    setInterval(getCount, 120000);
});

function getCount() {
    jQuery(document).ready(function () {
        getBalance();
        $.ajax({
            url: "/getApiAviCount",
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            mimeType: "application/json",
            success: function (data) {
                console.log(data);
                $("#sms-count").empty();
                $("#sms-count").append(data);
            }
        })
    });
}

function getBalance() {
    jQuery(document).ready(function () {
        $.ajax({
            url: "/getApiAviBalance",
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            mimeType: "application/json",
            success: function (data) {
                console.log(data);
                $("#sms-balance").empty();
                $("#sms-balance").append(data);
            }
        })
    })
}
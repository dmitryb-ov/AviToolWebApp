jQuery(document).ready(function () {
    $("#sendbutton").click(function () {
        let inputText = $("#mytext").val();
        let inputLang = $("#mylang").val();
        $.ajax({
            url: "dz/getTranslate",
            type: "GET",
            dataType: "text",
            data: ({
                "text": inputText,
                "lang": inputLang
            }),
            success: function (mydata) {
                console.log("HELLO");
                console.log(mydata);
                $("#textarea").empty();
                $("#textarea").append(mydata);
            },
            error: function (mydata) {
                console.log("Error");
                console.log(mydata);
            }
        });
    });
});
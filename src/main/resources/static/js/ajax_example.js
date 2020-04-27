$(#marks).on('change', function () {
    let inputValue = $(this).val();
    console.log(inputValue);

    $.ajax({
        url: "/dz/getModels",
        type: "GET",
        dataType: "json",
        contentType: "application/json",
        mimeType: "application/json",
        data: ({
            text: inputValue
        }),
        success: function (data) {
            let result = data;
            console.log(result);
        }
    })
});
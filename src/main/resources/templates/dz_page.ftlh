<#include "includes/header.ftlh"/>
<title>Dz</title>
<#--<script type="text/javascript" src="jquery-3.3.1.js"></script>-->
<#--<script type="text/javascript" src="script/ajax_example.js"></script>-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script type="text/javascript">
    // let CACHE = {};
    // jQuery(document).ready(function () {
    //     $("#marks").on('change', function () {
    //         let inputValue = $("#marks").val();
    //         console.log(inputValue);
    //         if (CACHE[inputValue] == null) {
    //             $.ajax({
    //                 url: "dz/getModels",
    //                 type: "GET",
    //                 dataType: "json",
    //                 contentType: "application/json",
    //                 mimeType: "application/json",
    //                 data: ({
    //                     mark: inputValue
    //                 }),
    //                 success: function (data) {
    //                     let result = data;
    //                     console.log(result);
    //                     console.log(result.length);
    //                     CACHE[inputValue] = data;
    //                     showResult(result);
    //                 }
    //             })
    //         } else {
    //             let result = CACHE[inputValue];
    //             showResult(result);
    //         }
    //     });
    //
    //     function showResult(result) {
    //         $("#models").find("option").remove();
    //         for (let i = 0; i < result.length; i++) {
    //             $("#models").append("<option value =" + result[i] + ">" + result[i] + "</option>")
    //         }
    //     }
    // });
</script>
<script type="text/javascript" src="js/scroll_example.js"></script>
<script type="text/javascript" src="js/translate_example.js"></script>
<#include "includes/close_header.ftlh">
<label id="count" hidden></label>
<h1>Выбор авто и марки</h1>
<select name="marks" id="marks">
    <option value="none">Выбрать марку</option>
    <option value="bmw">BMW</option>
    <option value="nissan">Nissan</option>
    <option value="lada">Lada</option>
    <option value="audi">Audi</option>
</select>
<label id="textarea">Text: </label>
<select name="models" id="models">
    <option value="none">Пусто</option>
</select>
<input type="text" id="mytext" name="mytext">
<select name="mylang" id="mylang">
    <option value="en">English</option>
    <option value="fr">France</option>
</select>
<input type="submit" value="Ok" name="sendbutton" id="sendbutton">
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Email</th>
    </tr>
    </thead>
    <tbody id="table">

    </tbody>
</table>
<iframe
<#include "includes/footer.ftlh">
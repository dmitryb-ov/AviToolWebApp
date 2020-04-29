function copyLogin() {
    let copyText = document.getElementById("login");
    copyText.select();
    document.execCommand("copy");
}

function copyPassword() {
    let copyText = document.getElementById("password");
    copyText.select();
    document.execCommand("copy");
}

function copyNumber() {
    let copyText = document.getElementById("phoneNumber");
    copyText.select();
    document.execCommand("copy");
}
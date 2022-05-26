// mã hóa hình ảnh thành base64
var input = document.querySelector('input[type=file]');
input.onchange = function () {
    var file = input.files[0],
            reader = new FileReader();

    reader.onloadend = function () {
        var b64 = reader.result;
        document.querySelector('#imageAvatar').innerHTML += `<input type="hidden" name="imageAvatar" value="${b64}">`;
        document.getElementById("imageAvatar").querySelector('.form-control').value = file.name;
    };

    reader.readAsDataURL(file);
};
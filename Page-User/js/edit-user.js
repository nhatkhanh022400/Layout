
document.getElementById('btn1').addEventListener('click', (Event) => {
    Event.preventDefault();
    Swal.fire(
        'Cập Nhật Thành Công',
    )
});


document.getElementById('btn2').addEventListener('click', (Event) => {
    Event.preventDefault();
    Swal.fire(
        'Thêm khóa Đào Tạo thành công',
    )
})

// mã hóa hình ảnh thành base64
var input = document.querySelector('input[type=file]');
input.onchange = function () {
    var file = input.files[0],
        reader = new FileReader();

    reader.onloadend = function () {

        var b64 = reader.result.replace(/^data:.+;base64,/, '');
        console.log(b64);
    };

    reader.readAsDataURL(file);
};



$(document).ready(function() {
	
    var readURL = function(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $('.profile-pic').attr('src', e.target.result);
            }
    
            reader.readAsDataURL(input.files[0]);
        }
    }
   
    $(".file-upload").on('change', function(){
        readURL(this);
    });
    
    $(".upload-button").on('click', function() {
       $(".file-upload").click();
    });
});
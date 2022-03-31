let navbar = document.querySelector('.header .navbar');

document.querySelector('#menu-btn').onclick = () => {
    navbar.classList.toggle('active');
}

window.onscroll = () => {
    navbar.classList.remove('active');
}




// ========================================hiện thị sản phẩn===============================================
const product = [
    { id: 1, image: "images/teacher-1.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 2, image: "images/teacher-1.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
]

let perPage = 6;
let currentPage = 1;
let start = 0;
let end = perPage;
function renderProduct(product) {
    html = '';
    const content = product.map((item, index) => {
        html += '<div class="image">';
        html += '<img src="'+ item.image +'" alt="">';
        html += '<div class="share">';
        html +=  '<button>Chi Tiết</button>';
        html +=  '<div class="status"> '+ item.statusCourse +' <br>  '+ item.dayStart +''
        html += '</div>';
        html += '</div>';
        html += '</div>';
        html += '<div class="content">';
        html =+ '<h3> '+ item.title +' </h3>';
        html +='<span>'+ item.teach +'</span>';
        html += '</div>';
        console.log(html);
        return html;
    })
    document.getElementById('product').innerHTML = html;
}
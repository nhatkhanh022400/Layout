let navbar = document.querySelector('.header .navbar');

document.querySelector('#menu-btn').onclick = () =>{
    navbar.classList.toggle('active');
}

window.onscroll = () =>{
    navbar.classList.remove('active');
}

$(document).ready(function(){
    $(window).scroll(function(){
        $(".teachersani").each(function(){
            const pos = $(this).offset().top;
            const winTop = $(window).scrollTop();
            if (pos < winTop + 600) {
                $(this).addClass("slide");
            }
        })
    })
})


// ========================================hiện thị sản phẩn===============================================
const product = [
    { id: 1, image: "images/teacher-1.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart:"Bắt Đầu: 22/03/2022", statusCourse:"Trạng Thái: Hoàn Thành" },
    { id: 2, image: "images/teacher-1.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart:"Bắt Đầu: 22/03/2022", statusCourse:"Trạng Thái: Hoàn Thành" },
    
]

let perPage = 6;
let currentPage = 1;
let start = 0;
let end = perPage;
function renderProduct(){
    html = '';
    const content = product.map((item, index) => {
        `<div class="image">
        <img src="${item.image}" alt="">
        <div class="share">
            <button>Chi Tiết</button>
            <div class="status">
            ${item.statusCourse}<br>
            ${item.dayStart}
            </div>
        </div>
    </div>
    <div class="content">
        <h3>${item.title}</h3>
        <span>${item.teach}</span>
    </div>`
    })
}
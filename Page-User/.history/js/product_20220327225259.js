// ========================================hiện thị khóa học cơ bản===============================================
var myapp = angular.module('myApp', [])
myapp.controller('myCtrl', function($scope) {
$scope.courses= [
    {
        image: "images/blog-1.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành"
    },
    {
        image: "images/blog-2.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" 
    }
];
  
});
// const courseBasic = [
//     { id: 1, image: "images/blog-1.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 2, image: "images/blog-2.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 3, image: "images/blog-3.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 4, image: "images/blog-4.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 5, image: "images/blog-5.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 6, image: "images/blog-6.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 7, image: "images/blog-7.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 8, image: "images/blog-8.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 9, image: "images/blog-7.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 10, image: "images/blog-6.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 11, image: "images/blog-5.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 12, image: "images/blog-4.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 13, image: "images/blog-3.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 14, image: "images/blog-2.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 15, image: "images/blog-1.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 16, image: "images/blog-2.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 17, image: "images/blog-3.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 18, image: "images/blog-4.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 19, image: "images/blog-5.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 20, image: "images/blog-6.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 21, image: "images/blog-7.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 22, image: "images/blog-8.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 23, image: "images/blog-7.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 24, image: "images/blog-6.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 26, image: "images/blog-5.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
//     { id: 26, image: "images/blog-4.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },

// ]



// function renderList() {
//     html = '';
//     const content = courseBasic.map((item, index) => {
//         if (index >= start && index < end) {
//             html += '<div class="box">';
//             html += '<div class="image">';
//             html += '<img src="' + item.image + '" alt="">';
//             html += '<div class="share">';
//             html += '<a href="course-detail.html">';
//             html += '<button>Chi Tiết</button>';
//             html += '</a>';
//             html += '<div class="status"> ';
//             html += '' + item.statusCourse + '';
//             html += '<br>';
//             html += '' + item.dayStart + '';
//             html += '</div>';
//             html += '</div>';
//             html += '</div>';
//             html += '<div class="content">';
//             html += '<h3>' + item.title + '</h3>';
//             html += '<span>' + item.teach + '</span>';
//             html += '</div>';
//             html += '</div>';
//             console.log(html);
//             return html;
//         }
//     })
//     document.getElementById('courseBasic').innerHTML = html;
// }
// renderList();

// ====================================Chuyen Trang================
// let perPage = 8;
// let currentPage = 1;
// let start = 0;
// let end = perPage;
// const btnNext = document.querySelector('.btn-next');
// const btnPrev = document.querySelector('.btn-prev');
// let totalPages = Math.ceil(courseBasic.length / perPage);
// function getCurrentPage(currentPage) {
//     start = (currentPage - 1) * perPage;
//     end = currentPage * perPage;
// }

// renderListPage();

// function renderListPage() {
//     let html = '';
//     html += `<li class="active"><a>${1}</a></li>`;
//     for (let i = 2; i <= totalPages; i++) {
//         html += `<li><a>${i}</a></li>`
//     }
//     document.getElementById('number-page').innerHTML = html;
// }


// function changePage() {
//     const currentPages = document.querySelectorAll('.number-page li');
//     for (let i = 0; i < currentPages.length; i++) {
//         currentPages[i].addEventListener('click', () => {
//             let value = i + 1;
//             currentPage = value;
//             $('.number-page li').removeClass('active');
//             currentPages[i].classList.add('active');
//             if (currentPage > 1 && currentPage < totalPages) {
//                 $('.btn-prev').removeClass('btn-active');
//                 $('.btn-next').removeClass('btn-active');
//             }
//             if (currentPage === 1) {
//                 $('.btn-prev').addClass('btn-active');
//             };
//             if (currentPage === totalPages) {
//                 $('.btn-next').addClass('btn-active')
//             }
//             getCurrentPage(currentPage);
//             renderList();
//         })


//     }

// }
// changePage();

// btnNext.addEventListener('click', () => {
//     currentPage++;
//     if (currentPage > totalPages) {
//         currentPage = totalPages;
//     }
//     if (currentPage === totalPages) {
//         $('.btn-next').addClass('btn-active');
//     }
//     $('.btn-prev').removeClass('btn-active');
//     $('.number-page li').removeClass('active');
//     $(`.number-page li:eq(${currentPage - 1})`).addClass('active');
//     getCurrentPage(currentPage);
//     renderList();
// })

// btnPrev.addEventListener('click', () => {
//     currentPage--;
//     if (currentPage <= 1) {
//         currentPage = 1;
//     }
//     if (currentPage === 1) {
//         $('.btn-prev').addClass('btn-active');
//     }
//    $('.btn-next').removeClass('btn-active');
//     $('.number-page li').removeClass('active');
//     $(`.number-page li:eq(${currentPage - 1})`).addClass('active');
//     getCurrentPage(currentPage);
//     renderList();
// })






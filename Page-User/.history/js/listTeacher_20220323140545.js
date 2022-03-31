let perPage = 8;
let currentPage = 1;
let start = 0;
let end = perPage;
// ========================================hiện thị khóa học cơ bản===============================================
const listTeacher = [
    { id: 1, image: "images/teacher-1.png", department: "Tên Khóa Học", nameTeacher: "Người Dạy" },
    { id: 2, image: "images/teacher-2.png", department: "Tên Khóa Học", nameTeacher: "Người Dạy" },
    { id: 3, image: "images/teacher-3.png", department: "Tên Khóa Học", nameTeacher: "Người Dạy" },
    { id: 4, image: "images/teacher-4.png", department: "Tên Khóa Học", nameTeacher: "Người Dạy" },
    { id: 5, image: "images/teacher-5.png", department: "Tên Khóa Học", nameTeacher: "Người Dạy" },
    { id: 6, image: "images/teacher-6.png", department: "Tên Khóa Học", nameTeacher: "Người Dạy" },
    { id: 7, image: "images/teacher-7.png", department: "Tên Khóa Học", nameTeacher: "Người Dạy" },
    { id: 8, image: "images/teacher-8.png", department: "Tên Khóa Học", nameTeacher: "Người Dạy" },
]


function renderList() {
    html = '';
    const contents = listTeacher.map((item, index) => {
        if (index >= start && index < end) {
            html += '<div class="box">';
            html += '<div class="image">';
            html += '<img src="images/teacher-2.png" alt=""';
            html += '<div class="social">';
            html += '<a href="#" class="fab fa-facebook-f"></a>';
            html += '<a href="#" class="fab fa-twitter"></a>';
            html += '<a href="#" class="fab fa-instagram"></a>';
            html += '<a href="#" class="fas fa-mobile-alt"></a>';
            html += '</div>';
            html += '</div>';
            html += '<div class="content">';
            html += '<h3>nguyễn văn b</h3>';
            html += '<span>khoa Marketing</span>';
            html += '</div>';
            html += '</div>';
            console.log(html);
            return html;
        }
    })
    document.getElementById('listTeacher').innerHTML = html;
}
renderList();
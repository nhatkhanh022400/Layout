let perPage = 8;
let currentPage = 1;
let start = 0;
let end = perPage;
// ========================================hiện thị khóa học cơ bản===============================================
const courseBasic = [
    { id: 1, image: "images/teacher-1.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 2, image: "images/teacher-2.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 3, image: "images/teacher-3.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 4, image: "images/teacher-4.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 5, image: "images/teacher-5.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 6, image: "images/teacher-6.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 7, image: "images/teacher-7.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 8, image: "images/teacher-8.png", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
]


function renderBasic() {
    html = '';
    const content = courseBasic.map((item, index) => {
        if (index >= start && index < end) {
            html += '<div class="box">';
            html += '<div class="image">';
            html += '<img src="' + item.image + '" alt="">';
            html += '<div class="share">';
            html += '<a href="#">';
            html += '<button>Chi Tiết</button>';
            html += '</a>';
            html += '<div class="status"> ';
            html += '' + item.statusCourse + '';
            html += '<br>';
            html += '' + item.dayStart + '';
            
            html += '</div>';
            html += '</div>';
            html += '<div class="content">';
             html += '<h3>'+ item.title+'</h3>';
              html +='<span>'+ item.teach+'</span>';
                html +='</div>';
            html += '</div>';

            html += '</div>';
            console.log(html);
            return html;
        }
    })
    document.getElementById('courseBasic').innerHTML = html;
}
renderBasic();





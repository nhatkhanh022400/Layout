// ========================================hiện thị sản phẩn===============================================
const image = [
    { id: 1, image: "images/teacher-1.png", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 2, image: "images/teacher-1.png", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 3, image: "images/teacher-1.png", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 4, image: "images/teacher-1.png", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 5, image: "images/teacher-1.png", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 6, image: "images/teacher-1.png", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 7, image: "images/teacher-1.png", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 8, image: "images/teacher-1.png", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
]

const name = [
    {title: "Tên Khóa Học", teach: "Người Dạy"},
    {title: "Tên Khóa Học", teach: "Người Dạy"},
    {title: "Tên Khóa Học", teach: "Người Dạy"},
    {title: "Tên Khóa Học", teach: "Người Dạy"},
    {title: "Tên Khóa Học", teach: "Người Dạy"},
    {title: "Tên Khóa Học", teach: "Người Dạy"},
    {title: "Tên Khóa Học", teach: "Người Dạy"},
    {title: "Tên Khóa Học", teach: "Người Dạy"},
]

let perPage = 6;
let currentPage = 1;
let start = 0;
let end = perPage;
function renderImage() {
    html = '';
    const content = image.map((item, index) => {
        if (index >= start && index < end) {
            html += '<img src="'+ item.image +'" alt="">';
             html +=   '<div class="share">';
                   html += '<button>Chi Tiết</button>' ;
                    html += '<div class="status">';
                        html += ''+ item.statusCourse +'';
                        html += '<br>';
                        html += ''+ item.dayStart+ '';
                    html += '</div>';
                html += '</div>';
            console.log(html);
            return html;
        }

    })
    
    document.getElementById('image').innerHTML = html;
}
renderImage();
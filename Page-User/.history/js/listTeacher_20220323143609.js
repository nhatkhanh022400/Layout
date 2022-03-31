let perPage = 8;
let currentPage = 1;
let start = 0;
let end = perPage;
// ========================================hiện thị khóa học cơ bản===============================================
const listTeacher = [
    { id: 1, image: "images/teacher-1.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy A",  },
    { id: 2, image: "images/teacher-2.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy B",  },
    { id: 3, image: "images/teacher-3.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy C",  },
    { id: 4, image: "images/teacher-4.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy D",  },
    { id: 5, image: "images/teacher-5.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy E",  },
    { id: 6, image: "images/teacher-6.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy F",  },
    { id: 7, image: "images/teacher-7.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy G",  },
    { id: 8, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  }
]


function renderList() {
    html = '';
    const contents = listTeacher.map((item, index) => {
        if (index >= start && index < end) {
            html += '<div class="box">';
            html += '<div class="image">';
            html += '<img src="' + item.image + '" alt="">';
            html += '<div class="social">';
            html += '<a href="#" class="fab fa-facebook-f">';
            html += '</a>';
            html += '<a href="#" class="fab fa-twitter">';
            html += '</a>';
            html += '<a href="#" class="fab fa-instagram">';
            html += '</a>';
            html += '<a href="#" class="fas fa-mobile-alt">';
            html += '</a>';
            html += '</div>';
            html += '</div>';
            html += '<div class="content">';
            html += '<h3>'+ item.nameTeacher +'</h3>';
            html += '<span>'+ item.department +'</span>';
            html += '</div>';
            html += '</div>';
            console.log(html);
            return html;
        }
    })
    document.getElementById('listTeacher').innerHTML = html;
}
renderList();
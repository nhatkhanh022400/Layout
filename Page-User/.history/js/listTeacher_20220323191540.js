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
    { id: 8, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 9, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 10, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 11, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 12, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 13, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 14, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 15, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 16, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 17, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 18, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 19, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
    { id: 20, image: "images/teacher-8.png",department: "Tên Phòng Ban", nameTeacher: "Người Dạy H",  },
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

// ====================================Chuyen Trang================
const btnNext = document.querySelector('.btn-next');
const btnPrev = document.querySelector('.btn-prev');
const totalPages = Math.ceil(listTeacher.length/perPage);
function getCurrentPage(currentPage) {
    start = (currentPage - 1) * perPage;
    end = currentPage * perPage;
}

function renderListPage() {
    let html = '';
    html += `<li class="active"><a>${1}</a></li>`;
    for (let i = 0; i < totalPages; i++) {
        html += `<li><a>${i}</a></li>`
    }
    document.getElementById('number-page').innerHTML=html;
}

function changePage() {
    const currentPage = document.querySelectorAll('.numberpage-page li');
    for (let i = 0; i < currentPage.length; i++) {
        let value = i + 1;
        currentPage = value;
        
    }
    
}

btnNext.addEventListener('click', ()=>{
    currentPage++;
    if (currentPage > totalPages) {
        currentPage = totalPages;
    }
    getCurrentPage(currentPage);
    renderList();
})

btnPrev.addEventListener('click', ()=>{
    currentPage--;
    if (currentPage <= 1) {
        currentPage = 1;
    }
    getCurrentPage(currentPage);
    renderList();
})
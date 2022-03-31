// // ========================================hiện thị khóa học cơ bản===============================================
// const listTeacher = [
//     { id: 1, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy A", },
//     { id: 2, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy B", },
//     { id: 3, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy C", },
//     { id: 4, image: "images/teacher-4.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy D", },
//     { id: 5, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy E", },
//     { id: 6, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy F", },
//     { id: 7, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy G", },
//     { id: 8, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 9, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 10, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 11, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 12, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 13, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 14, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 15, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 16, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 17, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 18, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 19, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 21, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 22, image: "images/teacher-4.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 23, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 24, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 25, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 26, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 27, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 28, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 29, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 30, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 31, image: "images/teacher-4.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 32, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 33, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 34, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 35, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 36, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 37, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 38, image: "images/teacher-4.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 39, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 40, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
//     { id: 41, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },

// ]

// let perPage = 8;
// let currentPage = 1;
// let start = 0;
// let end = perPage;
// const btnNext = document.querySelector('.btn-next');
// const btnPrev = document.querySelector('.btn-prev');
// let totalPages = Math.ceil(listTeacher.length / perPage);
// function getCurrentPage(currentPage) {
//     start = (currentPage - 1) * perPage;
//     end = currentPage * perPage;
// }


// function renderList() {
//     html = '';
//     const contents = listTeacher.map((item, index) => {
//         if (index >= start && index < end) {
//             html += '<div class="box">';
//             html += '<div class="image">';
//             html += '<img src="' + item.image + '" alt="">';
//             html += '<div class="social">';
//             html += '<a href="#" class="fab fa-facebook-f">';
//             html += '</a>';
//             html += '<a href="#" class="fab fa-twitter">';
//             html += '</a>';
//             html += '<a href="#" class="fab fa-instagram">';
//             html += '</a>';
//             html += '<a href="#" class="fas fa-mobile-alt">';
//             html += '</a>';
//             html += '</div>';
//             html += '</div>';
//             html += '<div class="content">';
//             html += '<h3>' + item.nameTeacher + '</h3>';
//             html += '<span>' + item.department + '</span>';
//             html += '</div>';
//             html += '</div>';
//             console.log(html);
//             return html;
//         }
//     })
//     document.getElementById('listTeacher').innerHTML = html;
    
// }
// renderList();

// // ====================================Chuyen Trang================
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
//                 $('.btn-next').removeClass('btn-active')
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
//         $('.btn-next').addClass('btn-active')
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
//         $('.btn-prev').addClass('btn-active')
//     }
//     $('.btn-next').removeClass('btn-active');
//     $('.number-page li').removeClass('active');
//     $(`.number-page li:eq(${currentPage - 1})`).addClass('active');
//     getCurrentPage(currentPage);
//     renderList();
// })


// // ============================================Search===================================================



let perPage = 6;
let idPage = 1;
let start = 0;
let end = perPage;

const product = [
    { id: 1, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy A", },
    { id: 2, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy B", },
    { id: 3, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy C", },
    { id: 4, image: "images/teacher-4.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy D", },
    { id: 5, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy E", },
    { id: 6, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy F", },
    { id: 7, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy G", },
    { id: 8, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 9, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 10, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 11, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 12, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 13, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 14, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 15, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 16, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 17, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 18, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 19, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 21, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 22, image: "images/teacher-4.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 23, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 24, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 25, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 26, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 27, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 28, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 29, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 30, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 31, image: "images/teacher-4.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 32, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 33, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 34, image: "images/teacher-8.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 35, image: "images/teacher-7.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 36, image: "images/teacher-6.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 37, image: "images/teacher-5.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 38, image: "images/teacher-4.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 39, image: "images/teacher-3.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 40, image: "images/teacher-2.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
    { id: 41, image: "images/teacher-1.png", department: "Tên Phòng Ban", nameTeacher: "Người Dạy H", },
]

let productArr = [];
let showAdd = false;

const addBookBtn = document.getElementById('add');
const name = document.getElementById('name');
const imgLink = document.getElementById('imgLink');
const addBook = document.getElementById('add-book');
addBook.addEventListener('click', () => {
    if (imgLink.value !== '' && name.value !== '') {
        productArr.push({
            id: product.length + 1,
            image: imgLink.value,
            title: name.value
        })
    }
});


function highlightText() {
    const title = document.querySelectorAll('.content__product__item h3');
    title.forEach((title, index) => {
        let titleText = title.innerHTML;
        let indexOf = Number(titleText.toLocaleLowerCase().indexOf(searchText.value.toLocaleLowerCase()));
        let searchTextLength = searchText.value.length;
        titleText = titleText.substring(0, indexOf) + "<span class='highlight'>" + titleText.substring(indexOf, indexOf + searchTextLength) + "</span>" + titleText.substring(indexOf + searchTextLength, titleText.length);
        title.innerHTML = titleText;
        
    })
}


productArr = product;


const pageConfig = document.querySelector('.page-config select');
const mySelect = document.getElementById('mySelect');
const countTotalPage = document.querySelector('.total-page');
const countTotalProduct = document.querySelector('.total-item');

let totalPages = Math.ceil(productArr.length / perPage);
const searchText = document.querySelector('.content__search input');
const searchBtn = document.getElementById('search');


function initRender(productAr, totalPage) {
    renderProduct(productAr);
    renderListPage(totalPage);
}

initRender(productArr, totalPages);

function getCurrentPage(indexPage) {
    start = (indexPage - 1) * perPage;
    end = indexPage * perPage;
    totalPages = Math.ceil(productArr.length / perPage);
    countTotalPage.innerHTML = `Total pages: ${totalPages}`;
    countTotalProduct.innerHTML = `Total Product:  ${productArr.length}`
}

const deleteBtn = document.querySelectorAll('.content__product__item .delete');

deleteBtn.forEach((item, index) => {
    deleteBtn[index].addEventListener('click', () => {
        product.splice(index, 1);
        productArr = product;
        renderProduct(productArr)
    });
});

getCurrentPage(1);

searchBtn.addEventListener('click', () => {
    idPage = 1;
    productArr = [];
    product.forEach((item, index) => {
        if (item.title.toLocaleLowerCase().indexOf(searchText.value.toLocaleLowerCase()) != -1) {
            productArr.push(item);
        }
    });
    if (productArr.length === 0) {
        $('.no-result').css('display', 'block')
    } else {
        $('.no-result').css('display', 'none')
    }
    getCurrentPage(idPage);
    
    initRender(productArr, totalPages);
    changePage();
    if (totalPages <= 1) {
        $('.btn-prev').addClass('btn-active');
        $('.btn-next').addClass('btn-active');
    } else {
        $('.btn-next').removeClass('btn-active');
    }
});

searchText.addEventListener("keyup", (event) => {
    if (event.keyCode === 13) {
        event.preventDefault();
        searchBtn.click();
    }
});

addBookBtn.addEventListener('click', () => {
    showAdd = !showAdd;
    if (showAdd) {
        $('.add-book').css('display', 'flex');
    } else {
        $('.add-book').css('display', 'none');
    }
})


pageConfig.addEventListener('change', () => {
    idPage = 1;
    perPage = Number(pageConfig.value);
    getCurrentPage(idPage);
    initRender(productArr, totalPages);
    if (totalPages == 1) {
        $('.btn-prev').addClass('btn-active');
        $('.btn-next').addClass('btn-active');
    } else {
        $('.btn-next').removeClass('btn-active');
    }
    changePage();
});



function renderProduct(product) {
    html = '';
    const content = product.map((item, index) => {
        if (index >= start && index < end) {
            html += '<div class="content__product__item">';
            html += '<a>';
            html += '<img src=' + item.image + '>';
            html += '</a>';
            html += '<h3>' + item.title + '</h3>';
            html += '</div>';
            return html;
        }
    });
    document.getElementById('product').innerHTML = html;
    highlightText();
}

function renderListPage(totalPages) {
    let html = '';
    html += `<li class="current-page active"><a>${1}</a></li>`;
    for (let i = 2; i <= totalPages; i++) {
        html += `<li><a>${i}</a></li>`;
    }
    if (totalPages === 0) {
        html = ''
    }
    document.getElementById('number-page').innerHTML = html;
}

function changePage() {
    const idPages = document.querySelectorAll('.number-page li');
    const a = document.querySelectorAll('.number-page li a');
    for (let i = 0; i < idPages.length; i++) {
        idPages[i].onclick = function () {
            let value = i + 1;
            const current = document.getElementsByClassName('active');
            current[0].className = current[0].className.replace('active', '');
            this.classList.add('active');
            if (value > 1 && value < idPages.length) {
                $('.btn-prev').removeClass('btn-active');
                $('.btn-next').removeClass('btn-active');
            }
            if (value == 1) {
                $('.btn-prev').addClass('btn-active');
                $('.btn-next').removeClass('btn-active');
            }
            if (value == idPages.length) {
                $('.btn-next').addClass('btn-active');
                $('.btn-prev').removeClass('btn-active');
            }
            idPage = value;
            getCurrentPage(idPage);
            renderProduct(productArr);
        };
    }
}

changePage();

$('.btn-next').on('click', () => {
    idPage++;
    if (idPage > totalPages) {
        idPage = totalPages;
    }
    if (idPage == totalPages) {
        $('.btn-next').addClass('btn-active');
    } else {
        $('.btn-next').removeClass('btn-active');
    }
    console.log(idPage);
    const btnPrev = document.querySelector('.btn-prev');
    btnPrev.classList.remove('btn-active');
    $('.number-page li').removeClass('active');
    $(`.number-page li:eq(${idPage - 1})`).addClass('active');
    getCurrentPage(idPage);
    renderProduct(productArr);
});

$('.btn-prev').on('click', () => {
    idPage--;
    if (idPage <= 0) {
        idPage = 1;
    }
    if (idPage == 1) {
        $('.btn-prev').addClass('btn-active');
    } else {
        $('.btn-prev').removeClass('btn-active');
    }
    const btnNext = document.querySelector('.btn-next');
    btnNext.classList.remove('btn-active');
    $('.number-page li').removeClass('active');
    $(`.number-page li:eq(${idPage - 1})`).addClass('active');
    getCurrentPage(idPage);
    renderProduct(productArr);
});




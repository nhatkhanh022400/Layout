AOS.init();

PrintCopyRight();

function PrintCopyRight() {
    console.log("%cHello! \ud83d\ude4b", "color: #29c4a9;font-size: 16px;font-weight: 600;"),
            console.log("%cVLU front-end was built with HTML, CSS, and lots of love. \n\nVLU back-end was built with SQL Server, and lots of love. \n\n\ud83d\udc49 Want to learn with us? Check out ".concat(window.location.origin, "/VLU/home"), "color: #29c4a9;font-size: 14px;");
}

let navbar = document.querySelector('.header .navbar');

document.querySelector('#menu-btn').onclick = () => {
    navbar.classList.toggle('active');
};

window.onscroll = () => {
    navbar.classList.remove('active');
};

var loader = document.getElementById("preloader");
window.addEventListener("load", function () {
    loader.style.display = "none";
});
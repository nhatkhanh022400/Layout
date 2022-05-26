PrintCopyRight();

function PrintCopyRight() {
    console.log("%cHello! \ud83d\ude4b", "color: #29c4a9;font-size: 16px;font-weight: 600;"),
            console.log("%cVLU front-end was built with HTML, CSS, and lots of love. \n\nVLU back-end was built with SQL Server, and lots of love. \n\n\ud83d\udc49 Want to learn with us? Check out ".concat(window.location.origin, "/VLU/home"), "color: #29c4a9;font-size: 14px;");
}

var loader = document.getElementById("preloader");
window.addEventListener("load", function () {
    loader.style.display = "none";
});

$(document).ready(function () {
    /* Mobile menu */
    $('.mobile-menu-icon').click(function () {
        $('.templatemo-left-nav').slideToggle();
    });

    /* Close the widget when clicked on close button */
    $('.templatemo-content-widget .fa-times').click(function () {
        $(this).parent().slideUp(function () {
            $(this).hide();
        });
    });
});
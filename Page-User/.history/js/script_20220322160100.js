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

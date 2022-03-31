let navbar = document.querySelector('.header .navbar');

document.querySelector('#menu-btn').onclick = () => {
    navbar.classList.toggle('active');
}

window.onscroll = () => {
    navbar.classList.remove('active');
}

var loader = document.getElementById("preloader");
window.addEventListener("laod", function(){
    loader.style.display = "none";
})





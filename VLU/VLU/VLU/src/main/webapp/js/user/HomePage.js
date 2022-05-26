$(document).ready(function () {
    $(".image-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        infinite: true,
        arrows: true,
        draggable: false,
        prevArrow: false,
        nextArrow: false,
        dots: true,
        responsive: [
            {
                breakpoint: 1025,
                settings: {
                    slidesToShow: 1
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 1,
                    arrows: false,
                    infinite: false
                }
            }
        ],
        autoplay: true,
        autoplaySpeed: 900
    });
});
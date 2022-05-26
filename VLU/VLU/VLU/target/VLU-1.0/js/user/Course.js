$(document).ready(function () {
    $(".image-slider").slick({
        slidesToShow: 3,
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
        autoplaySpeed: 1000
    });
});

// ========================================hiện thị khóa học cơ bản===============================================
var myapp = angular.module('myapp', ['angularUtils.directives.dirPagination']);

function ExistingCourseAPI(ApiJson) {
    myapp.controller('myCtrl', function myCtrl($scope) {
        $scope.courses = ApiJson;
    });
}

function UpcomingCourseAPI(ApiJson) {
    myapp.controller('myCtrls', function myCtrls($scope) {
        $scope.courses = ApiJson;
    });
}
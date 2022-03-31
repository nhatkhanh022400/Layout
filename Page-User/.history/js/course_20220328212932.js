// ========================================hiện thị khóa học cơ bản===============================================
var myapp = angular.module('myapp', ['angularUtils.directives.dirPagination'])
myapp.controller('myCtrl', function myCtrl($scope) {
$scope.courses= [
    {
        image: "images/blog-1.jpg", title: "Tên Khóa Khánh", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành"
    },
    { image: "images/blog-2.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" 
    },
    { id: 1, image: "images/blog-1.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 2, image: "images/blog-2.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
   { id: 3, image: "images/blog-3.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
    { id: 4, image: "images/blog-4.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 5, image: "images/blog-5.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 6, image: "images/blog-6.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 7, image: "images/blog-7.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 8, image: "images/blog-8.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 9, image: "images/blog-7.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 10, image: "images/blog-6.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 11, image: "images/blog-5.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 12, image: "images/blog-4.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 13, image: "images/blog-3.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 14, image: "images/blog-2.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" },
     { id: 15, image: "images/blog-1.jpg", title: "Tên Khóa Học", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Hoàn Thành" }
];
  
});


myapp.controller('myCtrls', function myCtrls($scope) {
    $scope.courses= [
        
        { id: 1, image: "https://images.unsplash.com/photo-1476718406336-bb5a9690ee2a?ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=687&q=80", title: "This is demo title title", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Sắp Ra Mắt" },
         { id: 2, image: "images/blog-2.jpg", title: "This is demo title", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Sắp Ra Mắt" },
       { id: 3, image: "images/blog-3.jpg", title: "This is demo title", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Sắp Ra Mắt" },
        { id: 4, image: "images/blog-4.jpg", title: "This is demo title", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Sắp Ra Mắt" },
         { id: 5, image: "images/blog-5.jpg", title: "This is demo title", teach: "Người Dạy", dayStart: "Bắt Đầu: 22/03/2022", statusCourse: "Trạng Thái: Sắp Ra Mắt" }
         

    ];
      
    });









 
var app = angular.module('user-app', []);
app.controller('abc', function abc($scope) {
    $scope.insides = [
        {
            img: 'images/blog-1.jpg',
            dayStart: '24/03/2022',
            teach: 'Bởi: Giảng Viên',
            title: 'Tên Khóa Học',
            
        },
        {
            img: 'images/blog-2.jpg',
            dayStart: '24/03/2022',
            teach: 'Bởi: Giảng Viên',
            title: 'Tên Khóa Học',
            
        },
        {
            img: 'images/blog-3.jpg',
            dayStart: '24/03/2022',
            teach: 'Bởi: Giảng Viên',
            title: 'Tên Khóa Học',
            
        },
    ];

});


app.controller('abcd', function abcd($scope) {
    $scope.test = {};
    $scope.outsides = [
        {
            img: 'images/blog-1.jpg',
            time: '6 tháng',
            teach: 'Bởi: Giảng Viên',
            title: 'Tên Khóa Học',
            issued: 'Cycber Soft'
        },
        {
            img: 'images/blog-2.jpg',
            time: '6 tháng',
            teach: 'Bởi: Giảng Viên',
            title: 'Tên Khóa Học',
            issued: 'Cycber Soft'
        },
        {
            img: 'images/blog-3.jpg',
            time: '6 tháng',
            teach: 'Bởi: Giảng Viên',
            title: 'Tên Khóa Học',
            issued: 'Cycber Soft'
        },
    ];
   
});






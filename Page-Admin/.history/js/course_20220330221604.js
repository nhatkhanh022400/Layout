var app = angular.module("myapp", []);
app.controller("viewCril", function($scope){
    $scope.test = {};
    $scope.listCourses = [
        {
            STT:"1",
            nameCourse: "Angular",
            statusCourse: "Done",
            startDay: "30/03/2022",
            endDay: "30/03/2024",
            teach: "NGuyễn Đăng Nhân",
            edit: "Sửa",
            delete: "Xóa"
        }
    ]
})
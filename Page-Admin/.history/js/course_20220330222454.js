var app = angular.module("myapp", []);
app.controller("viewCril", function($scope){
    $scope.test = {};
    $scope.save = function(){
        $scope.listCourses.push(angular.copy($scope.test))
    };
    $scope.listCourses = [
        {
            stt:"1",
            nameCourse: "Angular",
            statusCourse: "Done",
            startDay: "30/03/2022",
            endDay: "30/03/2024",
            teach: "Nguyễn Đăng Nhân",
            decription:"Nhanh Gọn Lẹ",
            edit: "Sửa",
            delete: "Xóa"
        }
    ]
})